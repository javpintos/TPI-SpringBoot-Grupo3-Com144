package com.example.tpspringboot.repository;

import com.example.tpspringboot.entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRespository extends JpaRepository<Tecnico, Long> {
    //JPQL
    @Query("SELECT COUNT (*) from RegistroIncidente ri where ri.tecnico.id = :id")
        //@Query("SELECT t from Tecnico t where t.id = :id")
    int getCantidadResueltosByTecnicoId (@Param("id") Long id);
}