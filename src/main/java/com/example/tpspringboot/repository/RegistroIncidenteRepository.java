package com.example.tpspringboot.repository;

import com.example.tpspringboot.entity.RegistroIncidente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroIncidenteRepository extends JpaRepository<RegistroIncidente, Long> {
    //@Query("SELECT t from Tecnico t where t.id = :id")

    //Quién fue el técnico con más incidentes resueltos en los últimos N días
    @Query("SELECT COUNT (*) from RegistroIncidente ri where ri.tecnico.id = :id")
    int getCantidadResueltosByTecnicoId (@Param("id") Long id);

    //Quién fue el técnico con más incidentes resueltos de una determinada especialidad en los últimos N días
    //@Query("SELECT COUNT (*) from RegistroIncidente ri where ri.tecnico.id = :tecnico_id AND ri.incidente.id= :incidente_id")
    @Query("SELECT COUNT (*) from RegistroIncidente ri where ri.tecnico.id = :tecnico_id AND ri.incidente.id= :incidente_id")
    int getCantRtosByTecnicoIdIncidenteID (@Param("id") Long tecnico_id, @Param("id") Long incidente_id);

    //Quién fue el técnico que más rápido resolvió los incidentes
}