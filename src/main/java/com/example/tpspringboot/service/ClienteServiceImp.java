package com.example.tpspringboot.service;

import com.example.tpspringboot.entity.Cliente;
import com.example.tpspringboot.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImp implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente saveCliente(Cliente c) {
        return clienteRepository.save(c);
    }

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente updateCliente(Cliente cliente, Long id) {
        Cliente clienteDB = clienteRepository.getReferenceById(id);
        if(!cliente.getRazonSocial().trim().isEmpty()){
            clienteDB.setRazonSocial(cliente.getRazonSocial());
        }
        if(!cliente.getCUIT().trim().isEmpty()){
            clienteDB.setCUIT(cliente.getCUIT());
        }
        if(!cliente.getMail().trim().isEmpty()){
            clienteDB.setMail(cliente.getMail());
        }
        clienteDB.setServicios(cliente.getServicios());
        return clienteRepository.save(clienteDB);
    }

    @Override
    public void deleteClienteById(Long id) {
        clienteRepository.deleteById(id);
    }
}
