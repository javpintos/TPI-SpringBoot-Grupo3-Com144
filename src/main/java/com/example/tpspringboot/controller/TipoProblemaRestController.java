package com.example.tpspringboot.controller;

import com.example.tpspringboot.entity.*;
import com.example.tpspringboot.service.EspecialidadService;
import com.example.tpspringboot.service.RegistroIncidenteService;
import com.example.tpspringboot.service.TipoProblemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class TipoProblemaRestController {

    @Autowired
    private EspecialidadService especialidadService;

    @Autowired
    private RegistroIncidenteService registroIncidenteService;

    @Autowired
    private TipoProblemaService tipoProblemaService;

    @PostMapping("/tipoProblemas")
    public TipoProblema saveTipoProblema(@Validated @RequestBody Map<String, Object> body){

        //tipo
        String tipo = String.valueOf(body.get("tipo"));

        //tiempo
        Integer tiempo = Integer.valueOf(String.valueOf(body.get("tiempo")));

        //ESPECIALIDADES
        Set<Especialidad> e = new HashSet<Especialidad>();
        if(body.get("especialidades") != null) {
            for (Integer id : (ArrayList<Integer>) body.get("especialidades")) {
                Especialidad especialidad = especialidadService.findEspecialidadById(Long.valueOf(id));
                e.add(especialidad);
            }
        }

        //RegistroIncidente
        Set<RegistroIncidente> r = new HashSet<RegistroIncidente>();
        for (Integer id: (ArrayList<Integer>) body.get("registros")) {
            RegistroIncidente registroIncidente = registroIncidenteService.findRegistroIncidenteById(Long.valueOf(id));
            r.add(registroIncidente);
        }

        //CREACION DEL OBJETO TipoProblema
        TipoProblema t = new TipoProblema();

        return tipoProblemaService.saveTipoProblema(t);
    }

    @GetMapping("/tipoProblemas")
    public List<TipoProblema> getAllTipoProblemas(){
        return tipoProblemaService.getAllTipoProblemas();
    }

    @PutMapping("tipoProblemas/{id}")
    public TipoProblema updateTipoProblema(@Validated @RequestBody Map<String, Object> body, @PathVariable("id") Long id){
        //CREACION DEL OBJETO TipoProblema
        TipoProblema tipoProblema = new TipoProblema();
        //LECTURA DE DATOS:
        //tipo
        if(body.get("tipo") != null) {
            String tipo = String.valueOf(body.get("tipo"));
            tipoProblema.setTipo(tipo);
        }

        if(body.get("tiempo") != null) {
            Integer tiempo = Integer.valueOf(String.valueOf(body.get("tiempo")));
            tipoProblema.setTiempo(tiempo);
        }



        //ESPECIALIDAD
        Set<Especialidad> e = new HashSet<Especialidad>();
        if(body.get("especialidades") != null) {
            for (Integer especialidadId : (ArrayList<Integer>) body.get("especialidades")) {
                Especialidad especialidad = especialidadService.findEspecialidadById(Long.valueOf(especialidadId));
                e.add(especialidad);
            }
        }
        tipoProblema.setEspecialidades(e);

        //REGISTROS

        Set<RegistroIncidente> r = new HashSet<RegistroIncidente>();
        if(body.get("registros") != null) {
            for (Integer registrosId : (ArrayList<Integer>) body.get("registros")) {
                RegistroIncidente registroIncidente = registroIncidenteService.findRegistroIncidenteById(Long.valueOf(registrosId));
                r.add(registroIncidente);
            }
        }
        tipoProblema.setRegistros(r);

        return tipoProblemaService.updateTipoProblema(tipoProblema, id);
    }

    @DeleteMapping("tipoProblemas/{id}")
    public String deleteTipoProblemaById(@PathVariable("id") Long id){
        tipoProblemaService.deleteTipoProblema(id);
        return "TipoProblema eliminado Correctamente";
    }

}
