package ru.yolshin.microgreen.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "microgreen_price")
@Table(name = "microgreen_price")
public class Price extends AbstractEntity {
    private BigDecimal price;
    @Column(name = "date_create")
    private Date create;
    @ManyToOne
    private Nomenclature nomenclature;
    @ManyToOne
    private Counterparty counterparty;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public Nomenclature getNomenclature() {
        return nomenclature;
    }

    public void setNomenclature(Nomenclature nomenclature) {
        this.nomenclature = nomenclature;
    }
}
