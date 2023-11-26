package com.example.tpspringboot.service;

import com.example.tpspringboot.entity.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClienteService {

    // Create
    Cliente saveCliente(Cliente c);

    // Read
    List<Cliente> getAllClientes();

    // Update
    Cliente updateCliente(Cliente c, Long id);

    // Delete
    void deleteClienteById(Long id);
}
