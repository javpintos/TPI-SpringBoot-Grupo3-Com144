package com.example.tpspringboot.controller;

import com.example.tpspringboot.entity.Servicio;
import com.example.tpspringboot.entity.Cliente;
import com.example.tpspringboot.service.ServicioService;
import com.example.tpspringboot.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ServicioService servicioService;


    // Create
    @PostMapping("/clientes")
    public Cliente saveCliente(@Validated @RequestBody Map<String, Object> body){

        //LECTURA DE DATOS:
        //NOMBRE
        String razonSocial = String.valueOf(body.get("razonSocial"));

        //email
        String mail = String.valueOf(body.get("mail"));

        //CUIT
        String cuit = String.valueOf(body.get("cuit"));

        //SERVICIOS
        Set<Servicio> s = new HashSet<Servicio>();
        for (Integer id: (ArrayList<Integer>) body.get("servicios")) {
            Servicio servicio = servicioService.findServicioById(Long.valueOf(id));
            s.add(servicio);
        }
        //CREACION DEL OBJETO CLIENTE
        Cliente c = new Cliente();
        c.setRazonSocial(razonSocial);
        c.setMail(mail);
        c.setCUIT(cuit);
        c.setServicios(s);

        return clienteService.saveCliente(c);
    }

    // Read
    @GetMapping("/clientes")
    public List<Cliente> fetchClienteList(){
        return clienteService.getAllClientes();
    }

    // Update
    @PutMapping("/clientes/{id}")
    public Cliente updateCliente(@Validated @RequestBody Map<String, Object> body, @PathVariable("id") Long id){
        //CREACION DEL OBJETO CLIENTE
        Cliente c = new Cliente();
        //LECTURA DE DATOS:
        //RAZON SOCIAL
        if(body.get("razonSocial") != null) {
            String razonSocial = String.valueOf(body.get("razonSocial"));
            c.setRazonSocial(razonSocial);
        }

        //email
        if(body.get("mail") != null) {
            String mail = String.valueOf(body.get("mail"));
            c.setMail(mail);
        }

        //CUIT
        if(body.get("cuit") != null) {
            String cuit = String.valueOf(body.get("cuit"));
            c.setCUIT(cuit);
        }

        //SERVICIOS
        Set<Servicio> s = new HashSet<Servicio>();
        if(body.get("servicios") != null) {
            for (Integer servicioId : (ArrayList<Integer>) body.get("servicios")) {
                Servicio servicio = servicioService.findServicioById(Long.valueOf(servicioId));
                s.add(servicio);
            }
        }
        c.setServicios(s);
        return clienteService.updateCliente(c, id);
    }

    // Delete
    @DeleteMapping("/clientes/{id}")
    public String deleteClienteById(@PathVariable("id") Long id){
        clienteService.deleteClienteById(id);
        return "Cliente eliminado correctamente";
    }
}
