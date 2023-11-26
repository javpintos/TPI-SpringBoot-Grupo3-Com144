package com.example.tpspringboot.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "servicio")
public class Servicio extends BaseEntity{
    @ManyToMany(mappedBy = "servicios")
    Set<Cliente> clientes;
}
