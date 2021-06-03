package ru.yolshin.microgreen.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int count;
    private BigDecimal price;
    @ManyToOne
    private NomenclatureInStock nomenclature;
    @JsonIgnore
    @ManyToOne
    private Order order;
}
