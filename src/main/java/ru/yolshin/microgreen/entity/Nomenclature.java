package ru.yolshin.microgreen.entity;

import javax.persistence.*;

@Entity(name = "microgreen_nomenclature")
@Table(name = "microgreen_nomenclature")
public class Nomenclature extends TreeReference<Nomenclature> {
    @ManyToOne
    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
