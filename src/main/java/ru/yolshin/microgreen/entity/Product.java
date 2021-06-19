package ru.yolshin.microgreen.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "microgreen_product")
@Table(name = "microgreen_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int count;
    private BigDecimal price;
    @ManyToOne
    private NomenclatureInStock nomenclatureInStock;
    @JsonIgnore
    @ManyToOne
    private Order order;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public NomenclatureInStock getNomenclatureInStock() {
        return nomenclatureInStock;
    }

    public void setNomenclatureInStock(NomenclatureInStock nomenclatureInStock) {
        this.nomenclatureInStock = nomenclatureInStock;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
