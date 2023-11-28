package com.example.tpspringboot.controller;

import com.example.tpspringboot.entity.Cliente;
import com.example.tpspringboot.entity.Incidente;
import com.example.tpspringboot.entity.RegistroIncidente;
import com.example.tpspringboot.entity.Tecnico;
import com.example.tpspringboot.service.ClienteService;
import com.example.tpspringboot.service.IncidenteService;
import com.example.tpspringboot.service.RegistroIncidenteService;
import com.example.tpspringboot.service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;

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
        String observacionTecnica = String.valueOf(body.get("observacionTecnica"));
        String resueltoInt = String.valueOf(body.get("resuelto"));
        Boolean resuelto = false;
        /*
        if (resueltoInt=="1") {resuelto = true;}

        else {
            resuelto = false;
        }
        */

        //CLIENTE

        Long clienteId = Long.valueOf((Integer) body.get("cliente_id"));
        Cliente c = clienteService.findClienteById(clienteId);

        //INCIDENTE

        Long incidenteId = Long.valueOf((Integer) body.get("incidente_id"));
        Incidente i = incidenteService.findIncidenteById(incidenteId);

        //TECNICO

        Long tecnicoId = Long.valueOf((Integer) body.get("tecnico_id"));
        Tecnico t = tecnicoService.findTecnicoById(tecnicoId);

        RegistroIncidente registro = new RegistroIncidente();
        registro.setFechaIncidente(fechaIncidente);
        registro.setFechaResolucion(fechaResolucion);
        registro.setDetalleProblema(detalleProblema);
        registro.setObservacionTecnica(observacionTecnica);
        registro.setResuelto(resuelto);
        registro.setCliente(c);
        registro.setIncidente(i);
        registro.setTecnico(t);

        return registroIncidenteService.saveRegistroIncidente(registro);
    }

    @GetMapping("/registroIncidentes")
    public List<RegistroIncidente> fetchRegistroList(){
        return registroIncidenteService.getAllRegistroIncidente();
    }

    @DeleteMapping("registroIncidentes/{id}")
    public String deleteRegistroIncidenteById(@PathVariable("id") Long id){
        registroIncidenteService.deleteRegistroIncidenteById(id);
        return "Incidente eliminado correctamente";
    }

    @GetMapping("/registroIncidentes/CantidadResueltosByTecnicoId/{id}")
    public int getCantidadResueltosByTecnicoId (@PathVariable("id") Long id){
        return registroIncidenteService.getCantidadResueltosByTecnicoId(id);
    }

    @GetMapping("/registroincidente/CantRtosByTecnicoIdIncidenteID/{id}")
    public int getCantRtosByTecnicoIdIncidenteID (@PathVariable("id") Long tecnico_id, @PathVariable("id") Long incidente_id){
        return registroIncidenteService.getCantRtosByTecnicoIdIncidenteID(tecnico_id, incidente_id);
    }

}
