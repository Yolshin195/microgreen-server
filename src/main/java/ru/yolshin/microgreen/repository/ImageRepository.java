package ru.yolshin.microgreen.repository;

import org.springframework.data.repository.CrudRepository;
import ru.yolshin.microgreen.entity.Image;

public interface ImageRepository extends CrudRepository<Image, Long> {
    Image findByOriginFileName(String originFileName);
}
