package ru.yolshin.microgreen.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yolshin.microgreen.service.DocumentToPlantService;

@RestController
@RequestMapping("admin/document/toplant")
public class DocumentToPlantController {
    private DocumentToPlantService documentToPlantService;

    public DocumentToPlantController(DocumentToPlantService documentToPlantService) {
        this.documentToPlantService = documentToPlantService;
    }

    public ResponseEntity<?> create() {
        return ResponseEntity.ok(new Object());
    }
}
