package ru.yolshin.microgreen.service;

import org.springframework.stereotype.Service;
import ru.yolshin.microgreen.entity.NomenclatureInStock;
import ru.yolshin.microgreen.entity.Order;
import ru.yolshin.microgreen.entity.OrderStatus;
import ru.yolshin.microgreen.entity.User;
import ru.yolshin.microgreen.repository.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderService {
    private UserRepository userRepository;
    private OrderRepository orderRepository;
    private OrderStatusRepository orderStatusRepository;
    private ProductRepository productRepository;
    private NomenclatureInStockRepository nomenclatureInStockRepository;

    public OrderService(OrderRepository orderRepository, OrderStatusRepository orderStatusRepository, UserRepository userRepository, ProductRepository productRepository, NomenclatureInStockRepository nomenclatureInStockRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.orderStatusRepository = orderStatusRepository;
        this.productRepository = productRepository;
        this.nomenclatureInStockRepository = nomenclatureInStockRepository;

    }

    public Order save(Order order) {
        User user = createUserIsNotExist(order.getUser().getUsername(), order.getUser().getPhone());
        OrderStatus orderStatus = createOrderStatusIsNotExist("CREATED");

        order.setUser(user);
        order.setStatus(orderStatus);
        order.setCreate(new Date());

        Order newOrder = orderRepository.save(order);
        newOrder.getProducts().forEach(product -> {
            product.setOrder(newOrder);
            var nomenclature = nomenclatureInStockRepository.findById(product.getNomenclatureInStock().getId());
            if (nomenclature.isPresent() && nomenclature.get().getAvailable() > product.getCount()) {
                nomenclature.get().setAvailable(nomenclature.get().getAvailable() - product.getCount());
            }
        });

        newOrder.setProducts(toSet(productRepository.saveAll(newOrder.getProducts())));

        return newOrder;
    }

    private OrderStatus createOrderStatusIsNotExist(String statusName) {
        Optional<OrderStatus> orderStatus = orderStatusRepository.findByValue(statusName);

        if (orderStatus.isEmpty()) {
            OrderStatus newOrderStatus = new OrderStatus();
            newOrderStatus.setValue(statusName);

            return orderStatusRepository.save(newOrderStatus);
        }

        return orderStatus.get();
    }

    private User createUserIsNotExist(String username, String phone) {
        Optional<User> user = userRepository.findByPhone(phone);

        if (user.isEmpty()) {
            User newUser = new User();
            newUser.setDate(new Date());
            newUser.setUsername(username);
            newUser.setPhone(phone);
            newUser.setRoles(new String[]{"ANONYMOUS"});

            return userRepository.save(newUser);
        }

        return user.get();
    }

    private <T> Set<T> toSet(Iterable<T> collection) {
        HashSet<T> set = new HashSet<T>();
        for (T item: collection)
            set.add(item);
        return set;
    }
}
