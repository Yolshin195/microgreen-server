package ru.yolshin.microgreen.controller;

import org.springframework.web.bind.annotation.*;
import ru.yolshin.microgreen.entity.Order;
import ru.yolshin.microgreen.repository.OrderRepository;

@RestController
@RequestMapping("order")
public class OrderController {
    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    Iterable<Order> findAll() {
        return this.orderRepository.findAll();
    }

    @PostMapping
    Order save(@RequestBody Order order) {
        return this.orderRepository.save(order);
    }

}
