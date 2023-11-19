package com.example.tpspringboot.service;

import com.example.tpspringboot.entity.Persona;
import com.example.tpspringboot.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImp implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Persona savePersona(Persona p) {
        return personaRepository.save(p);
    }

    @Override
    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public Persona updatePersona(Persona persona, Long id) {
        Persona personaDB = personaRepository.getReferenceById(id);
        if(!persona.getNombre().trim().isEmpty())
            personaDB.setNombre(persona.getNombre());
        if(persona.getContacto() != null) {
            if (!persona.getContacto().getEmail().trim().isEmpty())
                personaDB.getContacto().setEmail(persona.getContacto().getEmail());
            if (!persona.getContacto().getCelular().trim().isEmpty())
                personaDB.getContacto().setCelular(persona.getContacto().getCelular());
        }
        if(persona.getNacionalidad() != null)
            personaDB.setNacionalidad(persona.getNacionalidad());
        personaDB.setMascotas(persona.getMascotas());

        return personaRepository.save(personaDB);
    }

    @Override
    public void deletePersonaById(Long id) {
        personaRepository.deleteById(id);
    }
}
