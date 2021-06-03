package ru.yolshin.microgreen.repository;

import org.springframework.data.repository.CrudRepository;
import ru.yolshin.microgreen.entity.Nomenclature;

public interface NomenclatureRepository extends CrudRepository<Nomenclature, Long> {
}
