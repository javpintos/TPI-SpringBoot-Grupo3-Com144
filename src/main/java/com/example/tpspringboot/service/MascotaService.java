package com.example.tpspringboot.service;

import com.example.tpspringboot.entity.Mascota;
import org.springframework.stereotype.Service;

@Service
public interface MascotaService {
    Mascota findMascotaById(Long id);
}
