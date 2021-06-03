package ru.yolshin.microgreen.controller;

import org.springframework.web.bind.annotation.*;
import ru.yolshin.microgreen.entity.NomenclatureInStock;
import ru.yolshin.microgreen.repository.NomenclatureInStockRepository;

@RestController
@RequestMapping("nomenclature-in-stock")
public class NomenclatureInStockController {
    private NomenclatureInStockRepository nomenclatureInStockRepository;

    public NomenclatureInStockController(NomenclatureInStockRepository nomenclatureInStockRepository) {
        this.nomenclatureInStockRepository = nomenclatureInStockRepository;
    }

    @GetMapping
    public Iterable<NomenclatureInStock> findAll() {
        return nomenclatureInStockRepository.findAll();
    }

    @PostMapping
    public void save(@RequestBody NomenclatureInStock nomenclature) {
        nomenclatureInStockRepository.save(nomenclature);
    }
}
