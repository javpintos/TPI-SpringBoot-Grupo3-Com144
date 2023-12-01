package com.example.tpspringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "registro_incidente")
public class RegistroIncidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fechaIncidente;
    private Date fechaResolucion;
    private String detalleProblema;
    private String observacionTecnica;
    private Boolean resuelto;
    private Date fechaEstimada;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cliente_id", referencedColumnName = "id")
    private Cliente cliente;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="incidente_id", referencedColumnName = "id")
    private Incidente incidente;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tecnico_id", referencedColumnName = "id")
    private Tecnico tecnico;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="registro_incidente_tipo_problema", joinColumns = @JoinColumn(name="registro_incidente_id"), inverseJoinColumns = @JoinColumn(name="tipo_problema_id"))
    Set<TipoProblema> tipoProblemas;
}
