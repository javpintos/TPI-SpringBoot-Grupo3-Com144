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
        String fechaEstimadaString = String.valueOf(body.get("fechaEstimada"));
        Date fechaEstimada = java.sql.Date.valueOf(fechaEstimadaString);

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
        for (Integer id: (ArrayList<Integer>) body.get("tipoProblemas")) {
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
        registro.setFechaEstimada(fechaEstimada);
        //registro.setProblemas(tp);

        return registroIncidenteService.saveRegistroIncidente(registro);
    }

    @GetMapping("/registroIncidentes")
    public List<RegistroIncidente> fetchRegistroList(){
        return registroIncidenteService.getAllRegistroIncidente();
    }

    //ToDo UpdateRegistroIncidente
    @PutMapping("/registroIncidentes/{id}")
    public RegistroIncidente updateRegistroIncidente (@Validated @RequestBody Map<String, Object> body, @PathVariable("id") Long id){
        //CREACION DEL RegistroIncidente
        RegistroIncidente ri = new RegistroIncidente();

        if(body.get("fechaIncidente") != null) {
            String fechaIncidenteString = String.valueOf(body.get("fechaIncidente"));
            Date fechaIncidente = java.sql.Date.valueOf(fechaIncidenteString);
            ri.setFechaIncidente(fechaIncidente);
        }

        if(body.get("fechaResolucion") != null) {
            String fechaResolucionString = String.valueOf(body.get("fechaResolucion"));
            Date fechaResolucion = Date.valueOf(fechaResolucionString);
            ri.setFechaResolucion(fechaResolucion);
        }

        if(body.get("detalleProblema") != null) {
            String detalleProblema = String.valueOf(body.get("detalleProblema"));
            ri.setDetalleProblema(detalleProblema);
        }

        if(body.get("observacionTecnica") != null) {
            String observacionTecnica = String.valueOf(body.get("observacionTecnica"));
            ri.setObservacionTecnica(observacionTecnica);
        }

        if(body.get("resuelto") != null) {
            Boolean resuelto = (Boolean) body.get("resuelto");
            ri.setResuelto(resuelto);


            /*Integer isResuelto = (Integer) body.get("resuelto");
            if (isResuelto == 0){
                ri.setResuelto(false);
            }else{
                ri.setResuelto(true);
            }

             */
        }

        if(body.get("fechaEstimada") != null) {
            String fechaEstimadaString = String.valueOf(body.get("fechaEstimada"));
            Date fechaEstimada = java.sql.Date.valueOf(fechaEstimadaString);
            ri.setFechaEstimada(fechaEstimada);
        }

        /*
        //NACIONALIDAD
        if(body.get("nacionalidadID") != null) {
            Long nacionalidadId = Long.valueOf((Integer) body.get("nacionalidadID"));
            Nacionalidad n = nacionalidadService.findNacionalidadById(nacionalidadId);
            p.setNacionalidad(n);
        }
         */

        //CLIENTE
        if(body.get("cliente_id") != null) {
            Long clienteId = Long.valueOf((Integer) body.get("cliente_id"));
            //ToDo validar si existe el cliente_id. Sino tirar exception
            Cliente c = clienteService.findClienteById(clienteId);

            ri.setCliente(c);
        }


        //INCIDENTE
        if(body.get("incidente_id") != null) {
            Long incidenteId = Long.valueOf((Integer) body.get("incidente_id"));
            Incidente i = incidenteService.findIncidenteById(incidenteId);
            ri.setIncidente(i);
        }

        //TECNICO
        if(body.get("tecnico_id") != null) {
            Long tecnicoId = Long.valueOf((Integer) body.get("tecnico_id"));
            Tecnico t = tecnicoService.findTecnicoById(tecnicoId);
            ri.setTecnico(t);
        }

        /*
        //MASCOTAS
        Set<Mascota> m = new HashSet<Mascota>();
        if(body.get("mascotas") != null) {
            for (Integer mascotaId : (ArrayList<Integer>) body.get("mascotas")) {
                Mascota mascota = mascotaService.findMascotaById(Long.valueOf(mascotaId));
                m.add(mascota);
            }
        }
        p.setMascotas(m);
         */


        //TIPO PROBLEMA
        Set<TipoProblema> tp = new HashSet<TipoProblema>();
        if(body.get("tipoProblemas") != null) {
            for (Integer idTp : (ArrayList<Integer>) body.get("tipoProblemas")) {
                TipoProblema tipoProblema = tipoProblemaService.findTipoProblemaById(Long.valueOf(idTp));
                tp.add(tipoProblema);
            }
        }
        ri.setTipoProblemas(tp);

        return registroIncidenteService.updateRegistroIncidente(ri, id);
    }

    @DeleteMapping("registroIncidentes/{id}")
    public String deleteRegistroIncidenteById(@PathVariable("id") Long id){
        registroIncidenteService.deleteRegistroIncidenteById(id);
        return "Registro Incidente eliminado correctamente";
    }

    @GetMapping("/registroIncidentes/CantidadResueltosByTecnicoId/{id}")
    public int getCantidadResueltosByTecnicoId (@PathVariable("id") Long id){
        return registroIncidenteService.getCantidadResueltosByTecnicoId(id);
    }

    @GetMapping("/registroIncidentes/CantRtosByTecnicoIdIncidenteID")
    public int getCantRtosByTecnicoIdIncidenteID (@RequestParam("tecnicoId") Long tecnico_id, @RequestParam("incidenteId") Long incidente_id){
        return registroIncidenteService.getCantRtosByTecnicoIdIncidenteID(tecnico_id, incidente_id);
    }
    @GetMapping("/TecnicoConMasIncidentesResueltosNdias/{dias}")
    public Tecnico getTecnicoConMasIncidentesResueltos(@Validated @PathVariable("dias") Integer dias) {
        return null;//Todo method
    }

    @GetMapping("/registroIncidentes/findAllTecnicosByIncidenciaResueltaEntreFechas")//no sé que poner en vez de {id} va {fechaIncidente}
    public Tecnico findAllTecnicosByIncidenciaResueltaEntreFechas (@RequestParam("fechaIncidente") Date fecha_incidente, @RequestParam("fechaResolucion") Date fecha_resolucion){
        return registroIncidenteService.findAllTecnicosByIncidenciaResueltaEntreFechas(fecha_incidente, fecha_resolucion);
    }

    @GetMapping("/registroIncidentes/getIncidentesByDate")
    public RegistroIncidente getIncidentesByDate (@RequestParam("fechaIncidente") Date fecha_incidente){
        return registroIncidenteService.getIncidentesByDate(fecha_incidente);
    }

}
