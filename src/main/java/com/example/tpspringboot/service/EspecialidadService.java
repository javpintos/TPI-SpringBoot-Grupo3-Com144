package com.example.tpspringboot.service;

import com.example.tpspringboot.entity.Especialidad;
import org.springframework.stereotype.Service;

@Service
public interface EspecialidadService {
    Especialidad findEspecialidadById(Long id);
}
