package ru.yolshin.microgreen.controller;

import org.springframework.web.bind.annotation.*;
import ru.yolshin.microgreen.entity.Order;
import ru.yolshin.microgreen.repository.OrderRepository;
import ru.yolshin.microgreen.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {
    private OrderRepository orderRepository;
    private OrderService orderService;

    public OrderController(OrderRepository orderRepository, OrderService orderService) {
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }

    @GetMapping
    Iterable<Order> findAll() {
        return this.orderRepository.findAll();
    }

    @PostMapping
    Order save(@RequestBody Order order) {
        return this.orderRepository.save(order);
    }

    @PostMapping("register")
    void create(@RequestBody Order order) {
        this.orderService.save(order);
    }

}
