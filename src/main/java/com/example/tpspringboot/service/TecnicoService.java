package com.example.tpspringboot.service;

import com.example.tpspringboot.entity.Tecnico;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TecnicoService {
    Tecnico saveTecnico(Tecnico tecnico);
    List<Tecnico> getAllTecnico();
    Tecnico updateTecnico (Tecnico tecnico, Long id);
    void deleteTecnicoById(Long id);
    Tecnico findTecnicoById(Long id);
    int getCantidadResueltosByTecnicoId (Long id);
}
