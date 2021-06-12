package ru.yolshin.microgreen.repository;

import org.springframework.data.repository.CrudRepository;
import ru.yolshin.microgreen.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
