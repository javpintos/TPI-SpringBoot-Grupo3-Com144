package com.example.tpspringboot.repository;

import com.example.tpspringboot.entity.TipoProblema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProblemaRepository extends JpaRepository<TipoProblema, Long> {
}
