package com.example.tpspringboot.service;

import com.example.tpspringboot.entity.Incidente;
import com.example.tpspringboot.repository.IncidenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncidenteServiceImp implements IncidenteService{

    @Autowired
    private IncidenteRepository incidenteRepository;
    @Override
    public Incidente findIncidenteById(Long id){
        return incidenteRepository.getReferenceById(id);
    }
}
