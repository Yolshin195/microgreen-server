package ru.yolshin.microgreen.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private BigDecimal price;
    private Date create;
    @ManyToOne
    private Nomenclature nomenclature;
}
