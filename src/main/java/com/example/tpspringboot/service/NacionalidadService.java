package com.example.tpspringboot.service;

import com.example.tpspringboot.entity.Nacionalidad;
import org.springframework.stereotype.Service;

@Service
public interface NacionalidadService {
    Nacionalidad findNacionalidadById(Long id);
}
