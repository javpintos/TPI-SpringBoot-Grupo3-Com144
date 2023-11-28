package com.example.tpspringboot.service;

import com.example.tpspringboot.entity.Incidente;
import org.springframework.stereotype.Service;

@Service
public interface IncidenteService {
    Incidente findIncidenteById(Long id);
}
