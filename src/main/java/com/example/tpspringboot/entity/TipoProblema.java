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
@Builder
@Table(name = "tipo_problema")
public class TipoProblema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private Integer tiempo;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="tipo_problema_especialidad", joinColumns = @JoinColumn(name="tipo_problema_id"), inverseJoinColumns = @JoinColumn(name="especialidad_id"))
    Set<Especialidad> especialidades;

    //@ManyToMany(mappedBy = "problemas")
    //Set<Especialidad> especialidades;

    @ManyToMany(mappedBy = "problemas")
    Set<RegistroIncidente> registros;
}
