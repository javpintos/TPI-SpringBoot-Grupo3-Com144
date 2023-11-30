package com.example.tpspringboot.service;

import com.example.tpspringboot.entity.Especialidad;
import com.example.tpspringboot.entity.RegistroIncidente;
import com.example.tpspringboot.entity.Tecnico;
import com.example.tpspringboot.repository.RegistroIncidenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class RegistroIncidenteServiceImp implements RegistroIncidenteService{
    @Autowired
    private RegistroIncidenteRepository registroIncidenteRepository;

    @Override
    public RegistroIncidente saveRegistroIncidente(RegistroIncidente ri) {
        return registroIncidenteRepository.save(ri);
    }

    @Override
    public List<RegistroIncidente> getAllRegistroIncidente() {
        return registroIncidenteRepository.findAll();
    }

    @Override
    public RegistroIncidente updateRegistroIncidente(RegistroIncidente ri, Long id) {

        RegistroIncidente riDB = registroIncidenteRepository.findById(id).get();

        riDB.setCliente(ri.getCliente());
        riDB.setIncidente(ri.getIncidente());
        riDB.setTecnico(ri.getTecnico());
        //if(!ri.getResuelto())
            riDB.setResuelto(ri.getResuelto());
        riDB.setDetalleProblema(ri.getDetalleProblema());
        riDB.setFechaResolucion(ri.getFechaResolucion());
        riDB.setObservacionTecnica(ri.getObservacionTecnica());
        riDB.setTipoProblemas(ri.getTipoProblemas());
        riDB.setTiempoEstimado(ri.getTiempoEstimado());

        return registroIncidenteRepository.save(riDB);
    }

    @Override
    public void deleteRegistroIncidenteById(Long id) {
        registroIncidenteRepository.deleteById(id);
    }

    @Override
    public int getCantidadResueltosByTecnicoId(Long id) {
        return registroIncidenteRepository.getCantidadResueltosByTecnicoId(id);
    }

    @Override
    public int getCantRtosByTecnicoIdIncidenteID(Long tecnicoId, Long incidenteId) {
        return 0;//registroIncidenteRepository.getCantRtosByTecnicoIdIncidenteID(tecnicoId,incidenteId);
    }

    @Override
    public Tecnico findAllTecnicosByIncidenciaResueltaEntreFechas(Date fechaIncidente, Date fechaResolucion, Especialidad e) {
        return null;//registroIncidenteRepository.findAllTecnicosByIncidenciaResueltaEntreFechas(fechaIncidente,fechaResolucion,e);
    }

    @Override
    public Long tecnicoMasRapido(Long id) {
        return null;//registroIncidenteRepository.tecnicoMasRapido(id);
    }

    @Override
    public List<RegistroIncidente> getIncidentesByDay(Date fechaIncidente) {
        return null;//registroIncidenteRepository.getIncidentesByDate(fechaIncidente);
    }

    @Override
    public List<RegistroIncidente> getTecnicoConMasRegistrosResueltosEnNDias(Boolean resuelto, int numDias) {
        return null;//registroIncidenteRepository.getTecnicoConMasRegistrosResueltosEnNDias(resuelto, numDias);
    }

    @Override
    public RegistroIncidente findRegistroIncidenteById(Long id){
        return registroIncidenteRepository.getReferenceById(id);
    }
}
