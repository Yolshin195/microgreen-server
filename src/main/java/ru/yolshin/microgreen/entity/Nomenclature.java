package ru.yolshin.microgreen.entity;

import javax.persistence.*;

@Entity(name = "microgreen_nomenclature")
@Table(name = "microgreen_nomenclature")
public class Nomenclature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    @Column(columnDefinition = "text")
    private String description;
    @ManyToOne
    private Image image;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
