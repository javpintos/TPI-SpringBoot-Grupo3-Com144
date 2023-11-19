package com.example.tpspringboot.service;

import com.example.tpspringboot.entity.Persona;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonaService {

    // Create
    Persona savePersona(Persona p);

    // Read
    List<Persona> getAllPersonas();

    // Update
    Persona updatePersona(Persona p, Long id);

    // Delete
    void deletePersonaById(Long id);
}
