package com.example.tpspringboot.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "mascota")
public class Mascota extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tipo_id", nullable=false)
    private TipoMascota tipo;

    @ManyToMany(mappedBy = "mascotas")
    Set<Persona> personas;
}
