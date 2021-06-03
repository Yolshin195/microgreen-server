package ru.yolshin.microgreen.controller;

import org.springframework.web.bind.annotation.*;
import ru.yolshin.microgreen.entity.NomenclatureInStock;
import ru.yolshin.microgreen.entity.Price;
import ru.yolshin.microgreen.repository.NomenclatureInStockRepository;
import ru.yolshin.microgreen.repository.PriceRepository;

@RestController
@RequestMapping("price")
public class PriceController {
    private PriceRepository priceRepository;

    public PriceController(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @GetMapping
    public Iterable<Price> findAll() {
        return priceRepository.findAll();
    }

    @PostMapping
    public void save(@RequestBody Price price) {
        priceRepository.save(price);
    }
}
