package ru.yolshin.microgreen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity(name = "microgreen_purchase")
@Table(name = "microgreen_purchase")
public class Purchase extends BaseEntity {
    @Column(name = "date_create")
    private Date create;
    @ManyToOne
    private Counterparty counterparty;
}
