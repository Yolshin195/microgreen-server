package ru.yolshin.microgreen.controller;

import org.springframework.web.bind.annotation.*;
import ru.yolshin.microgreen.entity.Nomenclature;
import ru.yolshin.microgreen.repository.NomenclatureRepository;

@RestController
@RequestMapping("nomenclature")
public class NomenclatureController {
    private NomenclatureRepository nomenclatureRepository;

    public NomenclatureController(NomenclatureRepository nomenclatureRepository) {
        this.nomenclatureRepository = nomenclatureRepository;
    }

    @GetMapping
    public Iterable<Nomenclature> findAll() {
        return nomenclatureRepository.findAll();
    }

    @GetMapping("find")
    public Iterable<Nomenclature> findAllByTitleContaining(@RequestParam String title) {
        return nomenclatureRepository.findAllByTitleContaining(title);
    }

    @PostMapping
    public void save(@RequestBody Nomenclature nomenclature) {
        nomenclatureRepository.save(nomenclature);
    }
}
