package com.example.tpspringboot.service;

import com.example.tpspringboot.entity.Especialidad;
import com.example.tpspringboot.entity.RegistroIncidente;
import com.example.tpspringboot.entity.Tecnico;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public interface RegistroIncidenteService {
    RegistroIncidente saveRegistroIncidente(RegistroIncidente ri);
    List<RegistroIncidente> getAllRegistroIncidente();
    RegistroIncidente updateRegistroIncidente (RegistroIncidente ri, Long id);
    void deleteRegistroIncidenteById(Long id);
    int getCantidadResueltosByTecnicoId (Long id);
    int getCantRtosByTecnicoIdIncidenteID (Long tecnicoId, Long incidenteId);

    Tecnico findAllTecnicosByIncidenciaResueltaEntreFechas(Date fechaIncidente, Date fechaResolucion, Especialidad e);

    Long tecnicoMasRapido(Long id);

    List<RegistroIncidente> getIncidentesByDay(Date fechaIncidente);

    List<RegistroIncidente> getTecnicoConMasRegistrosResueltosEnNDias(Boolean resuelto, int numDias);
    RegistroIncidente findRegistroIncidenteById(Long id);
}
