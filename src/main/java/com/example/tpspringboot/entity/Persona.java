package com.example.tpspringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "persona")
public class Persona extends BaseEntity{
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="nacionalida_id", nullable=false)
    private Nacionalidad nacionalidad;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contacto_id", referencedColumnName = "id")
    private Contacto contacto;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    name = "persona_mascota",
    joinColumns = @JoinColumn(name = "persona_id"),
    inverseJoinColumns = @JoinColumn(name = "mascota_id"))
    Set<Mascota> mascotas;
}
