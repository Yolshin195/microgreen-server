package ru.yolshin.microgreen.repository;

import org.springframework.data.repository.CrudRepository;
import ru.yolshin.microgreen.entity.NomenclatureInStock;

public interface NomenclatureInStockRepository extends CrudRepository<NomenclatureInStock, Long> {
}
