package ru.yolshin.microgreen.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "microgreen_order")
@Table(name = "microgreen_order")
public class Order extends SuperReference {
    @Column(name = "date_create")
    private Date create;
    @Column(name = "date_end")
    private Date end;
    @ManyToOne
    private OrderStatus status;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private Set<Product> products;

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
