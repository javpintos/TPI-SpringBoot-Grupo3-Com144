package com.example.tpspringboot.service;

import com.example.tpspringboot.entity.Especialidad;
import com.example.tpspringboot.entity.RegistroIncidente;
import com.example.tpspringboot.entity.Tecnico;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface RegistroIncidenteService {
    RegistroIncidente saveRegistroIncidente(RegistroIncidente ri);
    List<RegistroIncidente> getAllRegistroIncidente();
    RegistroIncidente updateRegistroIncidente (RegistroIncidente ri, Long id);
    void deleteRegistroIncidenteById(Long id);
    int getCantidadResueltosByTecnicoId (Long id);
    int getCantRtosByTecnicoIdIncidenteID (Long tecnico_id, Long incidente_id);
    RegistroIncidente findRegistroIncidenteById(Long id);
    Tecnico findAllTecnicosByIncidenciaResueltaEntreFechas(Date fechaIncidente, Date fechaResolucion);
    RegistroIncidente getIncidentesByDate(Date fechaIncidente);
}
