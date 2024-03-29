package ru.yolshin.microgreen.repository;

import org.springframework.data.repository.CrudRepository;
import ru.yolshin.microgreen.entity.OrderStatus;

import java.util.Optional;

public interface OrderStatusRepository extends CrudRepository<OrderStatus, Long> {
    Optional<OrderStatus> findByValue(String value);
}
