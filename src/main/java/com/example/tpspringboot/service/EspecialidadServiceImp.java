package com.example.tpspringboot.service;

import com.example.tpspringboot.entity.Especialidad;
import com.example.tpspringboot.repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EspecialidadServiceImp implements EspecialidadService{
    @Autowired
    private EspecialidadRepository especialidadRepository;
    @Override
    public Especialidad findEspecialidadById(Long id) {
        return especialidadRepository.getReferenceById(id);
    }
}
