package com.example.tpspringboot.service;

import com.example.tpspringboot.entity.RegistroIncidente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RegistroIncidenteService {
    RegistroIncidente saveRegistroIncidente(RegistroIncidente ri);
    List<RegistroIncidente> getAllRegistroIncidente();
    RegistroIncidente updateRegistroIncidente (RegistroIncidente ri, Long id);
    void deleteRegistroIncidenteById(Long id);
    int getCantidadResueltosByTecnicoId (Long id);
    int getCantRtosByTecnicoIdIncidenteID (Long tecnico_id, Long incidente_id);
}
