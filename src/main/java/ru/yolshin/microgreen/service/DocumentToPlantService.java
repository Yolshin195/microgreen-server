package ru.yolshin.microgreen.service;

import org.springframework.stereotype.Service;
import ru.yolshin.microgreen.repository.DocumentToPlantRepository;

@Service
public class DocumentToPlantService {
    private DocumentToPlantRepository repository;

    public DocumentToPlantService(DocumentToPlantRepository documentToPlantRepository) {
        this.repository = documentToPlantRepository;
    }
}
