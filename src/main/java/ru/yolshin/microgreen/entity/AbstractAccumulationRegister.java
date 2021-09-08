package ru.yolshin.microgreen.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AbstractAccumulationRegister extends AbstractRegister {
    @JsonIgnore
    LocalDateTime period;
    @JsonIgnore
    String registrar;
    @JsonIgnore
    @Column(name = "registrar_number")
    Long registrarNumber;
    @JsonIgnore
    @Column(name = "type_of_movement")
    String typeOfMovement;
}
