package ru.yolshin.microgreen.entity;

import javax.persistence.*;

@Entity
public class Nomenclature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String description;
    @ManyToOne
    private Image image;
}
