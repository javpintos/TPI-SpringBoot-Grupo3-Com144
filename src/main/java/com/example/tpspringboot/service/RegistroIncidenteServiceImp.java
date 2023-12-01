package com.example.tpspringboot.service;

import com.example.tpspringboot.entity.RegistroIncidente;
import com.example.tpspringboot.entity.Tecnico;
import com.example.tpspringboot.repository.RegistroIncidenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        riDB.setFechaEstimada(ri.getFechaEstimada());

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
    public int getCantRtosByTecnicoIdIncidenteID(Long tecnico_id, Long incidente_id) {
        return registroIncidenteRepository.getCantRtosByTecnicoIdIncidenteID(tecnico_id,incidente_id);
    }

    @Override
    public RegistroIncidente findRegistroIncidenteById(Long id){
        return registroIncidenteRepository.getReferenceById(id);
    }

    @Override
    public Tecnico findAllTecnicosByIncidenciaResueltaEntreFechas(Date fechaIncidente, Date fechaResolucion) {
        return registroIncidenteRepository.findAllTecnicosByIncidenciaResueltaEntreFechas(fechaIncidente,fechaResolucion);
    }

    @Override
    public RegistroIncidente getIncidentesByDate(Date fechaIncidente) {
        return registroIncidenteRepository.getIncidentesByDate(fechaIncidente);
    }

}
