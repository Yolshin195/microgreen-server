package ru.yolshin.microgreen.repository;

import org.springframework.data.repository.CrudRepository;
import ru.yolshin.microgreen.entity.Nomenclature;
import ru.yolshin.microgreen.entity.Price;

public interface PriceRepository extends CrudRepository<Price, Long> {
    Price findFirstByNomenclatureIdOrderByCreateDesc(long nomenclatureId);
    Iterable<Price> findAllByNomenclatureIdOrderByCreateDesc(long nomenclatureId);
}
