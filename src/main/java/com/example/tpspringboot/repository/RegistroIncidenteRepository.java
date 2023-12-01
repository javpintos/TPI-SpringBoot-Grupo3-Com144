package com.example.tpspringboot.repository;

import com.example.tpspringboot.entity.Especialidad;
import com.example.tpspringboot.entity.RegistroIncidente;
import com.example.tpspringboot.entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public interface RegistroIncidenteRepository extends JpaRepository<RegistroIncidente, Long> {
    //@Query("SELECT t from Tecnico t where t.id = :id")

    //Quién fue el técnico con más incidentes resueltos en los últimos N días
    @Query("SELECT COUNT (*) from RegistroIncidente ri where ri.tecnico.id = :id AND ri.resuelto = true ")
    int getCantidadResueltosByTecnicoId(@Param("id") Long id);

    //Quién fue el técnico con más incidentes resueltos de una determinada especialidad en los últimos N días

    @Query("SELECT COUNT (*) from RegistroIncidente ri where ri.tecnico.id = :tecnico_id AND ri.incidente.id=:incidente_id")
    int getCantRtosByTecnicoIdIncidenteID(@Param("tecnico_id") Long tecnicoId, @Param("incidente_id") Long incidenteId);

    /**/
    @Query (" SELECT t FROM Tecnico as t "+
            " WHERE t.id =  ( SELECT ri.tecnico.id FROM RegistroIncidente as ri "+
            " WHERE ri.resuelto = TRUE "+
            " AND ri.fechaEstimada BETWEEN :fecha_incidente AND :fecha_resolucion "+
            " GROUP BY ri.tecnico.id ORDER BY COUNT(ri.id) DESC LIMIT 1) ")
    public Tecnico findAllTecnicosByIncidenciaResueltaEntreFechas(@Param("fecha_incidente") Date fechaIncidente,
                                                                  @Param("fecha_resolucion")Date fechaResolucion
                                                                  );



    //Para emitir reportes diarios de los incidentes asignados a cada tecnico y su estado
    //@Query("SELECT ri.tecnico.id, ri.incidente.id, ri.resuelto FROM RegistroIncidente ri WHERE ri.fechaIncidente= :fecha_incidente")
    @Query("SELECT ri FROM RegistroIncidente ri WHERE ri.fechaIncidente= :fecha_incidente " +
            "GROUP BY ri.tecnico.id")
/*
    @Query (" SELECT t FROM Tecnico as t "+
            " WHERE t.id =  ( SELECT ri.tecnico.id FROM RegistroIncidente as ri "+
            " WHERE ri.resuelto = TRUE "+
            " AND ri.fechaEstimada BETWEEN :fecha_incidente AND :fecha_resolucion "+
            " GROUP BY ri.tecnico.id ORDER BY COUNT(ri.id) DESC LIMIT 1) ")

 */

    RegistroIncidente getIncidentesByDate(@Param("fecha_incidente") Date fechaIncidente);//group by

}