package ru.yolshin.microgreen.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "order_")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date create;
    private Date end;
    @ManyToOne
    private OrderStatus status;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private Set<Product> products;
}
