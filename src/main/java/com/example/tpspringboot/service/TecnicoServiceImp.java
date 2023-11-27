package com.example.tpspringboot.service;

import com.example.tpspringboot.entity.Tecnico;
import com.example.tpspringboot.repository.TecnicoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TecnicoServiceImp implements TecnicoService{
    @Autowired
    private TecnicoRespository tecnicoRepository;

    @Override
    public Tecnico saveTecnico(Tecnico tecnico) {
        return tecnicoRepository.save(tecnico);
    }

    @Override
    public List<Tecnico> getAllTecnico() {
        return tecnicoRepository.findAll();
    }

    @Override
    public Tecnico updateTecnico(Tecnico tecnico, Long id) {
        Tecnico tecnicoDB = tecnicoRepository.findById(id).get();
        if(!tecnico.getNombre().trim().isEmpty())
            tecnicoDB.setNombre(tecnico.getNombre());
        if(!tecnico.getMail().trim().isEmpty())
            tecnicoDB.setMail(tecnico.getMail());
        if(!tecnico.getTelefono().trim().isEmpty())
            tecnicoDB.setTelefono(tecnico.getTelefono());
        tecnicoDB.setEspecialidades(tecnico.getEspecialidades());

        return tecnicoRepository.save(tecnicoDB);
    }

    @Override
    public void deleteTecnicoById(Long id) {
        tecnicoRepository.deleteById(id);
    }

    @Override
    public Tecnico findTecnicoById(Long id) {
        return tecnicoRepository.getReferenceById(id);
    }


    @Override
    public int getCantidadResueltosByTecnicoId(Long id) {
        return tecnicoRepository.getCantidadResueltosByTecnicoId(id);
    }

}
