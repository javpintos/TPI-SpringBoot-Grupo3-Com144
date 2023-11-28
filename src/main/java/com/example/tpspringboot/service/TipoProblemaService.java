package com.example.tpspringboot.service;

import com.example.tpspringboot.entity.TipoProblema;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TipoProblemaService {
    TipoProblema saveTipoProblema(TipoProblema tipoProblema);

    List<TipoProblema> getAllTipoProblemas();

    TipoProblema updateTipoProblema(TipoProblema tipoProblema, long id);

    void deleteTipoProblema(Long id);

    TipoProblema findTipoProblemaById(Long id);

}
