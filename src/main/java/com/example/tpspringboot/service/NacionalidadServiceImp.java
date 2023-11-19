package com.example.tpspringboot.service;

import com.example.tpspringboot.entity.Nacionalidad;
import com.example.tpspringboot.repository.NacionalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NacionalidadServiceImp implements NacionalidadService{

    @Autowired
    private NacionalidadRepository nacionalidadRepository;

    @Override
    public Nacionalidad findNacionalidadById(Long id) {
        return nacionalidadRepository.getReferenceById(id);
    }
}
