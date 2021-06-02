package ru.yolshin.microgreen.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class NomenclatureInStock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int count;
    private Date create;
    @ManyToOne
    private Nomenclature nomenclature;
}
