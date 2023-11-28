package com.example.tpspringboot.service;

import com.example.tpspringboot.entity.Servicio;
import com.example.tpspringboot.entity.TipoProblema;
import com.example.tpspringboot.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioServiceImp implements ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public Servicio findServicioById(Long id) {
        return servicioRepository.getReferenceById(id);
    }
}
