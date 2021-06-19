package ru.yolshin.microgreen.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "microgreen_nomenclature_in_stock")
@Table(name = "microgreen_nomenclature_in_stock")
public class NomenclatureInStock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int count;
    private int available;
    @Column(name = "date_create")
    private Date create;
    @ManyToOne
    private Price price;
    @ManyToOne
    private Nomenclature nomenclature;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Nomenclature getNomenclature() {
        return nomenclature;
    }

    public void setNomenclature(Nomenclature nomenclature) {
        this.nomenclature = nomenclature;
    }
}