package com.example.tpspringboot.controller;

import com.example.tpspringboot.entity.*;
import com.example.tpspringboot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.*;

@RestController
public class RegistroIncidenteRestController {
    @Autowired
    private RegistroIncidenteService registroIncidenteService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private IncidenteService incidenteService;

    @Autowired
    private TecnicoService tecnicoService;

    @Autowired
    private TipoProblemaService tipoProblemaService;

    //Create
    @PostMapping("/registroIncidentes")
    public RegistroIncidente saveRegistro(@Validated @RequestBody Map<String, Object> body){

        //LECTURA DE DATOS:
        String fechaIncidenteString = String.valueOf(body.get("fechaIncidente"));
        Date fechaIncidente = java.sql.Date.valueOf(fechaIncidenteString);
        //String fechaResolucionString = String.valueOf(body.get("fechaResolucion"));
        //Date fechaResolucion = Date.valueOf(fechaResolucionString);
        Date fechaResolucion = null;
        String detalleProblema = String.valueOf(body.get("detalleProblema"));
        //String observacionTecnica = String.valueOf(body.get("observacionTecnica"));
        //String resueltoInt = String.valueOf(body.get("resuelto"));
        Boolean resuelto = false;

        //CLIENTE

        Long clienteId = Long.valueOf((Integer) body.get("cliente_id"));
        //ToDo validar si existe el cliente_id. Sino tirar exception
        Cliente c = clienteService.findClienteById(clienteId);

        //INCIDENTE

        Long incidenteId = Long.valueOf((Integer) body.get("incidente_id"));
        Incidente i = incidenteService.findIncidenteById(incidenteId);

        //TECNICO

        Long tecnicoId = Long.valueOf((Integer) body.get("tecnico_id"));
        Tecnico t = tecnicoService.findTecnicoById(tecnicoId);

        //TIPO PROBLEMA

        /*
        Set<TipoProblema> tp = new HashSet<TipoProblema>();
        for (Integer id: (ArrayList<Integer>) body.get("problemas")) {
            TipoProblema tipoProblema = tipoProblemaService.findTipoProblemaById(Long.valueOf(id));
            tp.add(tipoProblema);
        }

         */

        //REGISTRO INCIDENTE

        RegistroIncidente registro = new RegistroIncidente();
        registro.setFechaIncidente(fechaIncidente);
        registro.setFechaResolucion(fechaResolucion);
        registro.setDetalleProblema(detalleProblema);
        //registro.setObservacionTecnica(observacionTecnica);
        registro.setResuelto(resuelto);
        registro.setCliente(c);
        registro.setIncidente(i);
        registro.setTecnico(t);
        //registro.setProblemas(tp);

        return registroIncidenteService.saveRegistroIncidente(registro);
    }

    @GetMapping("/registroIncidentes")
    public List<RegistroIncidente> fetchRegistroList(){
        return registroIncidenteService.getAllRegistroIncidente();
    }

    //ToDo UpdateRegistroIncidente

    @DeleteMapping("registroIncidentes/{id}")
    public String deleteRegistroIncidenteById(@PathVariable("id") Long id){
        registroIncidenteService.deleteRegistroIncidenteById(id);
        return "Incidente eliminado correctamente";
    }

    @GetMapping("/registroIncidentes/CantidadResueltosByTecnicoId/{id}")
    public int getCantidadResueltosByTecnicoId (@PathVariable("id") Long id){
        return registroIncidenteService.getCantidadResueltosByTecnicoId(id);
    }

    @GetMapping("/registroIncidentes/CantRtosByTecnicoIdIncidenteID/{id}")
    public int getCantRtosByTecnicoIdIncidenteID (@PathVariable("id") Long tecnico_id, @PathVariable("id") Long incidente_id){
        return registroIncidenteService.getCantRtosByTecnicoIdIncidenteID(tecnico_id, incidente_id);
    }

}
