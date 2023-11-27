package com.example.tpspringboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "especialidad")

public class Especialidad extends BaseEntity{
    @ManyToMany(mappedBy="especialidades")
    private Set<Tecnico> tecnicos;
    /*
    @ManyToMany(mappedBy ="especialidades")
    private Set<TipoProblema> problemas;

     */
}
