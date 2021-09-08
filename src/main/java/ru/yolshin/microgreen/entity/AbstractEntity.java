package ru.yolshin.microgreen.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @JsonIgnore
    protected LocalDateTime delete_ts;
    @JsonIgnore
    protected String deleted_us;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDelete_ts() {
        return delete_ts;
    }

    public void setDelete_ts(LocalDateTime delete_ts) {
        this.delete_ts = delete_ts;
    }

    public String getDeleted_us() {
        return deleted_us;
    }

    public void setDeleted_us(String deleted_us) {
        this.deleted_us = deleted_us;
    }
}
