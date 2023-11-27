package com.example.tpspringboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "incidente")
public class Incidente extends BaseEntity{
    private int tiempoResolucion;
    @ManyToOne
    @JoinColumn(name="servicio_id", referencedColumnName = "id")
    private Servicio servicios;
}