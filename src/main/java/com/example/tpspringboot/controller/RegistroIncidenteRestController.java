package com.example.tpspringboot.controller;

import com.example.tpspringboot.entity.RegistroIncidente;
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


    //Create
    @PostMapping("/registro_incidente")
    public RegistroIncidente saveRegistro(@Validated @RequestBody Map<String, Object> body){

        //LECTURA DE DATOS:
        String fechaIncidenteString = String.valueOf(body.get("fechaIncidente"));
        Date fechaIncidente = Date.valueOf(fechaIncidenteString);
        String fechaResolucionString = String.valueOf(body.get("fechaResolucion"));
        Date fechaResolucion = Date.valueOf(fechaResolucionString);
        String detalleProblema = String.valueOf(body.get("detalleProblema"));
        String observacionTecnica = String.valueOf(body.get("observacionTecnica"));
        String resueltoInt = String.valueOf(body.get("resuelto"));
        Boolean resuelto;
        if (resueltoInt=="1") {resuelto = true;}
        else {
            resuelto = false;
        }


        //TECNICO

        // CLIENTE
        //INCIDENTE

        RegistroIncidente registro = new RegistroIncidente();
        registro.setFechaIncidente(fechaIncidente);
        registro.setFechaResolucion(fechaResolucion);
        registro.setDetalleProblema(detalleProblema);
        registro.setObservacionTecnica(observacionTecnica);
        registro.setResuelto(resuelto);

        return registroIncidenteService.saveRegistroIncidente(registro);
    }

    @GetMapping("/registroincidente")
    public List<RegistroIncidente> fetchRegistroList(){
        return registroIncidenteService.getAllRegistroIncidente();
    }

    @DeleteMapping("registroincidente/{id}")
    public String deleteRegistroIncidenteById(@PathVariable("id") Long id){
        registroIncidenteService.deleteRegistroIncidenteById(id);
        return "Incidente eliminado correctamente";
    }

    @GetMapping("/registroincidente/CantidadResueltosByTecnicoId/{id}")
    public int getCantidadResueltosByTecnicoId (@PathVariable("id") Long id){
        return registroIncidenteService.getCantidadResueltosByTecnicoId(id);
    }

    @GetMapping("/registroincidente/CantRtosByTecnicoIdIncidenteID/{id}")
    public int getCantRtosByTecnicoIdIncidenteID (@PathVariable("id") Long tecnico_id, @PathVariable("id") Long incidente_id){
        return registroIncidenteService.getCantRtosByTecnicoIdIncidenteID(tecnico_id, incidente_id);
    }

}
