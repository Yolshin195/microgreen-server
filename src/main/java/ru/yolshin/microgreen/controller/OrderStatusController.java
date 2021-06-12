package ru.yolshin.microgreen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.yolshin.microgreen.entity.Order;
import ru.yolshin.microgreen.entity.OrderStatus;
import ru.yolshin.microgreen.repository.OrderRepository;
import ru.yolshin.microgreen.repository.OrderStatusRepository;

public class OrderStatusController {
    private OrderStatusRepository orderStatusRepository;

    public OrderStatusController(OrderStatusRepository orderStatusRepository) {
        this.orderStatusRepository = orderStatusRepository;
    }

    @GetMapping
    Iterable<OrderStatus> findAll() {
        return this.orderStatusRepository.findAll();
    }

    @GetMapping
    OrderStatus findById(@RequestParam long id) {
        return this.orderStatusRepository.findById(id).orElseThrow();
    }

    @PostMapping
    OrderStatus save(@RequestBody OrderStatus orderStatus) {
        return this.orderStatusRepository.save(orderStatus);
    }
}
