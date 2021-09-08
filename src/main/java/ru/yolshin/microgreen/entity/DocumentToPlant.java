package ru.yolshin.microgreen.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity(name = "microgreen_document_to_plant")
@Table(name = "microgreen_document_to_plant")
public class DocumentToPlant extends AbstractEntity {
    @ManyToOne
    Nomenclature substrate;
    @ManyToOne
    Nomenclature box;
    @ManyToOne
    Nomenclature seed;
    int numberOfSeeds;
    Date seedDate;
    Date putOnRackWithoutLight;
    Date putOnRackWithLight;
}
