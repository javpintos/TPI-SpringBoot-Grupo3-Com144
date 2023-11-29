package com.example.tpspringboot.repository;

import com.example.tpspringboot.entity.RegistroIncidente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RegistroIncidenteRepository extends JpaRepository<RegistroIncidente, Long> {
    //@Query("SELECT t from Tecnico t where t.id = :id")

    //Quién fue el técnico con más incidentes resueltos en los últimos N días
    @Query("SELECT COUNT (*) from RegistroIncidente ri where ri.tecnico.id = :id")
    int getCantidadResueltosByTecnicoId(@Param("id") Long id);

    //Quién fue el técnico con más incidentes resueltos de una determinada especialidad en los últimos N días
    @Query("SELECT COUNT (*) from RegistroIncidente ri where ri.tecnico.id = :tecnico_id AND ri.incidente.id=:incidente_id")
    int getCantRtosByTecnicoIdIncidenteID(@Param("tecnico_id") Long tecnicoId, @Param("incidente_id") Long incidenteId);

    /*Quién fue el técnico que más rápido resolvió los incidentes*/
    /*@Query("SELECT ri FROM RegistroIncidente ri WHERE ri.id=:incidente_id ORDER BY FUNCTION('datediff', 'fecha_resolucion', 'fecha_incidente')")
    Long tecnicoMasRapido(@Param("incidente_id") Long id);*/

    //Para emitir reportes diarios de los incidentes asignados a cada tecnico y su estado
    @Query("SELECT ri.tecnico, ri.incidente, ri.resuelto FROM RegistroIncidente ri WHERE ri.id= :tecnico_id AND ri.fechaIncidente= :fecha_incidente")
    List<RegistroIncidente> getIncidentesByTecnico(@Param("tecnico_id") Long tecnicoId, @Param("fecha_incidente") Date fechaIncidente);

    //Quién fue el técnico con más registros resueltos en los últimos N días
    //@Query("SELECT t from Tecnico t where t.id = :id")
   /*@Query("SELECT ri.tecnicoId COUNT(ri.resuelto) AS cantidad FROM RegistroIncidente ri " +
            "WHERE ri.fechaResolucion >= CURRENT_DATE - :numDias " +
            "GROUP BY ri.tecnicoId ORDER BY cantidad DESC LIMIT 1")
    List<RegistroIncidente> getTecnicoConMasRegistrosResueltosEnNDias(@Param("resuelto") Boolean resuelto, @Param("numDias") int numDias);
*/
}