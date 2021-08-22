package ru.yolshin.microgreen.entity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@MappedSuperclass
public abstract class TreeReference<E> extends SuperReference {
    @OneToMany
    @OrderColumn
    @JoinColumn(name = "parent_id")
    private List<E> children = new LinkedList<>();

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "parent_id",insertable=false,updatable=false)
    private E parent;

    public void move(E node, E newParent, E oldParent) {
    }

    public List<E> getChildren() {
        return children;
    }

    public void setChildren(List<E> children) {
        this.children = children;
    }

    public E getParent() {
        return parent;
    }

    public void setParent(E parent) {
        this.parent = parent;
    }
}
