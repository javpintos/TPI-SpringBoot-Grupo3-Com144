package com.example.tpspringboot.service;

import com.example.tpspringboot.entity.Servicio;
import org.springframework.stereotype.Service;

@Service
public interface ServicioService {
    Servicio findServicioById(Long id);
}
