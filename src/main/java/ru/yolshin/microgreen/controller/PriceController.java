package ru.yolshin.microgreen.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.yolshin.microgreen.entity.Price;
import ru.yolshin.microgreen.repository.PriceRepository;

import java.util.Date;

@RestController
@RequestMapping("price")
public class PriceController {
    private static final Logger logger = LoggerFactory.getLogger(PriceController.class);
    private PriceRepository priceRepository;

    public PriceController(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @GetMapping
    public Iterable<Price> findAll() {
        return priceRepository.findAll();
    }

    @GetMapping("current")
    public Price findFirsByNomenclatureOrderByCreateDesc(@RequestParam long id) {
        return priceRepository.findFirsByNomenclatureIdOrderByCreateDesc(id);
    }

    @PostMapping
    public void save(@RequestBody Price price) {
        price.setCreate(new Date());
        priceRepository.save(price);
    }
}
