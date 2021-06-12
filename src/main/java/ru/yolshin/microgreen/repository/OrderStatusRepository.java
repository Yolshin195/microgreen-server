package ru.yolshin.microgreen.repository;

import org.springframework.data.repository.CrudRepository;
import ru.yolshin.microgreen.entity.OrderStatus;

public interface OrderStatusRepository extends CrudRepository<OrderStatus, Long> {
}
