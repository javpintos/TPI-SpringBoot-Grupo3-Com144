package com.example.tpspringboot.controller;

import com.example.tpspringboot.entity.Especialidad;
import com.example.tpspringboot.entity.Tecnico;
import com.example.tpspringboot.service.EspecialidadService;
import com.example.tpspringboot.service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class TecnicoRestController {
    @Autowired
    private TecnicoService tecnicoService;
    @Autowired
    private EspecialidadService especialidadService;

    //Create
    @PostMapping("/tecnicos")
    public Tecnico saveTecnico(@Validated @RequestBody Map<String, Object> body){

        //LECTURA DE DATOS:
        //NOMBRE
        String nombre = String.valueOf(body.get("nombre"));
        String mail = String.valueOf(body.get("mail"));
        String telefono = String.valueOf(body.get("telefono"));

        //ESPECIALIDAD
        Set<Especialidad> e = new HashSet<Especialidad>();
        for (Integer id: (ArrayList<Integer>) body.get("especialidades")) {
            Especialidad especialidad = especialidadService.findEspecialidadById(Long.valueOf(id));
            e.add(especialidad);
        }
        //CREACION DEL OBJETO TECNICO
        Tecnico tecnico = new Tecnico();
        tecnico.setNombre(nombre);
        tecnico.setMail(mail);
        tecnico.setTelefono(telefono);
        tecnico.setEspecialidades(e);

        return tecnicoService.saveTecnico(tecnico);
    }

    @GetMapping("/tecnicos")
    public List<Tecnico> fetchTecnicoList(){
        return tecnicoService.getAllTecnico();
    }

    @PutMapping("tecnicos/{id}")
    public Tecnico updateTecnico(@Validated @RequestBody Map<String, Object> body, @PathVariable("id") Long id){
        //CREACION DEL OBJETO TECNICO
        Tecnico tecnico = new Tecnico();
        //LECTURA DE DATOS:
        //NOMBRE
        if(body.get("nombre") != null) {
            String nombre = String.valueOf(body.get("nombre"));
            tecnico.setNombre(nombre);
        }

        if(body.get("mail") != null && body.get("telefono") != null) {
            String mail = String.valueOf(body.get("mail"));
            tecnico.setMail(mail);
            String telefono = String.valueOf(body.get("telefono"));
            tecnico.setTelefono(telefono);
        }

        //ESPECIALIDAD
        Set<Especialidad> e = new HashSet<Especialidad>();
        if(body.get("especialidades") != null) {
            for (Integer especialidadId : (ArrayList<Integer>) body.get("especialidades")) {
                Especialidad especialidad = especialidadService.findEspecialidadById(Long.valueOf(especialidadId));
                e.add(especialidad);
            }
        }
        tecnico.setEspecialidades(e);

        return tecnicoService.updateTecnico(tecnico,id);
    }
    @DeleteMapping("tecnicos/{id}")
    public String deleteTecnicoById(@PathVariable("id") Long id){
        tecnicoService.deleteTecnicoById(id);
        return "Técnico eliminado Correctamente";
    }
}
