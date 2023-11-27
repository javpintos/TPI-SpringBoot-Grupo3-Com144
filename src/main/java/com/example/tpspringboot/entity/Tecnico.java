package com.example.tpspringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tecnico")
public class Tecnico extends BaseEntity{
    private String mail;
    private String telefono;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="tecnico_especialidad", joinColumns = @JoinColumn(name="tecnico_id"), inverseJoinColumns = @JoinColumn(name="especialidad_id"))
    Set<Especialidad> especialidades;

}
