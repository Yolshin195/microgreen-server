package ru.yolshin.microgreen.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.yolshin.microgreen.entity.Nomenclature;

public interface NomenclatureRepository extends CrudRepository<Nomenclature, Long> {
    Iterable<Nomenclature> findAllByTitleContaining(String title);
}
