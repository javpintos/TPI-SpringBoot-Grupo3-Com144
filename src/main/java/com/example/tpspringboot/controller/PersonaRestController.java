package com.example.tpspringboot.controller;

import com.example.tpspringboot.entity.Contacto;
import com.example.tpspringboot.entity.Mascota;
import com.example.tpspringboot.entity.Nacionalidad;
import com.example.tpspringboot.entity.Persona;
import com.example.tpspringboot.service.MascotaService;
import com.example.tpspringboot.service.NacionalidadService;
import com.example.tpspringboot.service.PersonaService;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class PersonaRestController {

    @Autowired
    private PersonaService personaService;
    @Autowired
    private MascotaService mascotaService;
    @Autowired
    private NacionalidadService nacionalidadService;


    // Create
    @PostMapping("/personas")
    public Persona savePersona(@Validated @RequestBody Map<String, Object> body){

        //LECTURA DE DATOS:
        //NOMBRE
        String nombre = String.valueOf(body.get("nombre"));

        //CONTACTO
        String email = String.valueOf(body.get("email"));
        String cel = String.valueOf(body.get("celular"));
        Contacto c = new Contacto();
        c.setEmail(email);
        c.setCelular(cel);

        //NACIONALIDAD
        Long nacionalidadId = Long.valueOf((Integer) body.get("nacionalidadID"));
        Nacionalidad n = nacionalidadService.findNacionalidadById(nacionalidadId);

        //MASCOTAS
        Set<Mascota> m = new HashSet<Mascota>();
        for (Integer id: (ArrayList<Integer>) body.get("mascotas")) {
            Mascota mascota = mascotaService.findMascotaById(Long.valueOf(id));
            m.add(mascota);
        }
        //CREACION DEL OBJETO PERSONA
        Persona p = new Persona();
        p.setNombre(nombre);
        p.setContacto(c);
        p.setNacionalidad(n);
        p.setMascotas(m);

        return personaService.savePersona(p);
    }

    // Read
    @GetMapping("/personas")
    public List<Persona> fetchPersonaList(){
        return personaService.getAllPersonas();
    }

    // Update
    @PutMapping("/personas/{id}")
    public Persona updatePersona(@Validated @RequestBody Map<String, Object> body, @PathVariable("id") Long id){
        //CREACION DEL OBJETO PERSONA
        Persona p = new Persona();
        //LECTURA DE DATOS:
        //NOMBRE
        if(body.get("nombre") != null) {
            String nombre = String.valueOf(body.get("nombre"));
            p.setNombre(nombre);
        }
        //CONTACTO
        if(body.get("email") != null && body.get("celular") != null) {
            Contacto c = new Contacto();
            String email = String.valueOf(body.get("email"));
            c.setEmail(email);
            String cel = String.valueOf(body.get("celular"));
            c.setCelular(cel);
            p.setContacto(c);
        }
        //NACIONALIDAD
        if(body.get("nacionalidadID") != null) {
            Long nacionalidadId = Long.valueOf((Integer) body.get("nacionalidadID"));
            Nacionalidad n = nacionalidadService.findNacionalidadById(nacionalidadId);
            p.setNacionalidad(n);
        }

        //MASCOTAS
        Set<Mascota> m = new HashSet<Mascota>();
        if(body.get("mascotas") != null) {
            for (Integer mascotaId : (ArrayList<Integer>) body.get("mascotas")) {
                Mascota mascota = mascotaService.findMascotaById(Long.valueOf(mascotaId));
                m.add(mascota);
            }
        }
        p.setMascotas(m);
        return personaService.updatePersona(p, id);
    }

    // Delete
    @DeleteMapping("/personas/{id}")
    public String deletePersonaById(@PathVariable("id") Long id){
        personaService.deletePersonaById(id);
        return "Eliminado correctamente";
    }
}
