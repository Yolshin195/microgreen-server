package ru.yolshin.microgreen.repository;

import org.springframework.data.repository.CrudRepository;
import ru.yolshin.microgreen.entity.DocumentToPlant;

public interface DocumentToPlantRepository extends CrudRepository<DocumentToPlant, Long> {
}
