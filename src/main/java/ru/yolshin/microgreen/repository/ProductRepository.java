package ru.yolshin.microgreen.repository;

import org.springframework.data.repository.CrudRepository;
import ru.yolshin.microgreen.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
