package com.example.tpspringboot.service;

import com.example.tpspringboot.entity.TipoProblema;
import com.example.tpspringboot.repository.TipoProblemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoProblemaServiceImp implements TipoProblemaService{
    @Autowired
    private TipoProblemaRepository tipoProblemaRepository;

    @Override
    public TipoProblema saveTipoProblema(TipoProblema tipoProblema){
        return tipoProblemaRepository.save(tipoProblema);
    }

    @Override
    public List<TipoProblema> getAllTipoProblemas(){
        return tipoProblemaRepository.findAll();
    }

    @Override
    public TipoProblema updateTipoProblema(TipoProblema tipoProblema, long id){
        TipoProblema tipoProblemaBD = tipoProblemaRepository.findById(id).get();
        if(!tipoProblema.getTipo().trim().isEmpty()){
            tipoProblemaBD.setTipo(tipoProblema.getTipo());
        }
        if(tipoProblema.getTiempo() > 0){
            tipoProblemaBD.setTiempo(tipoProblema.getTiempo());
        }
        tipoProblemaBD.setEspecialidades(tipoProblema.getEspecialidades());
        tipoProblemaBD.setRegistros(tipoProblema.getRegistros());
        return tipoProblemaRepository.save(tipoProblemaBD);
    }

    @Override
    public void deleteTipoProblema(Long id){
        tipoProblemaRepository.deleteById(id);
    }

    @Override
    public TipoProblema findTipoProblemaById(Long id) {
        return tipoProblemaRepository.getReferenceById(id);
    }
}
