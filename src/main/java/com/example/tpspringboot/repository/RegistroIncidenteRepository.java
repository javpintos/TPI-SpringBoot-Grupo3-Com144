package com.example.tpspringboot.repository;

import com.example.tpspringboot.entity.Especialidad;
import com.example.tpspringboot.entity.RegistroIncidente;
import com.example.tpspringboot.entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface RegistroIncidenteRepository extends JpaRepository<RegistroIncidente, Long> {
    //@Query("SELECT t from Tecnico t where t.id = :id")

    //Quién fue el técnico con más incidentes resueltos en los últimos N días
    @Query("SELECT COUNT (*) from RegistroIncidente ri where ri.tecnico.id = :id AND ri.resuelto = true ")
    int getCantidadResueltosByTecnicoId(@Param("id") Long id);

    //Quién fue el técnico con más incidentes resueltos de una determinada especialidad en los últimos N días
    /*
    @Query("SELECT COUNT (*) from RegistroIncidente ri where ri.tecnico.id = :tecnico_id AND ri.incidente.id=:incidente_id")
    int getCantRtosByTecnicoIdIncidenteID(@Param("tecnico_id") Long tecnicoId, @Param("incidente_id") Long incidenteId);

     */
    /*
    @Query (" SELECT t FROM Tecnico as t "+
            " WHERE t.id =  ( SELECT i.tecnico.id FROM Incidencia as i "+
            " WHERE i.resuelto = TRUE "+
            " AND i.fechaEstimada BETWEEN :fechaInicio AND :fechaFin "+
            " AND :e IN (SELECT t.especialidades FROM Tecnico t WHERE t.id = i.tecnico.id)"+
            " GROUP BY i.tecnico.id ORDER BY COUNT(i.id) DESC LIMIT 1) ")
    public Tecnico findAllTecnicosByIncidenciaResueltaEntreFechas(@Param("fechaInicio") LocalDateTime fechaInicio,
                                                                  @Param("fechaFin")LocalDateTime fechaFin, @Param("e") Especialidad e);

     */

    //Quién fue el técnico que más rápido resolvió los incidentes
    /*
    @Query("SELECT ri FROM RegistroIncidente ri WHERE ri.id=:incidente_id ORDER BY FUNCTION('datediff', 'fecha_resolucion', 'fecha_incidente')")
    //Long tecnicoMasRapido(@Param("incidente_id") Long id);
    Long tecnicoMasRapido();

     */


    //Para emitir reportes diarios de los incidentes asignados a cada tecnico y su estado
    @Query("SELECT ri.tecnico, ri.incidente, ri.resuelto FROM RegistroIncidente ri WHERE ri.fechaIncidente= :fecha_incidente")
    //List<RegistroIncidente> getIncidentesByTecnico(@Param("tecnico_id") Long tecnicoId, @Param("fecha_incidente") Date fechaIncidente);
    List<RegistroIncidente> getIncidentesByTecnico(@Param("fecha_incidente") Date fechaIncidente);//group by

    //Quién fue el técnico con más registros resueltos en los últimos N días
    /*
   @Query("SELECT ri.tecnicoId COUNT(ri.resuelto) AS cantidad FROM RegistroIncidente ri " +
            "WHERE ri.fechaResolucion >= CURRENT_DATE - :numDias " +
            "GROUP BY ri.tecnicoId ORDER BY cantidad DESC LIMIT 1")
    List<RegistroIncidente> getTecnicoConMasRegistrosResueltosEnNDias(@Param("resuelto") Boolean resuelto, @Param("numDias") int numDias);
    */
}