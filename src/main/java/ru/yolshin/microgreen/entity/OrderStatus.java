package ru.yolshin.microgreen.entity;

import javax.persistence.*;

@Entity(name = "microgreen_order_status")
@Table(name = "microgreen_order_status")
public class OrderStatus extends BaseEntity {
    private String title;
    private String value;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
