package com.example.tpspringboot.repository;

import com.example.tpspringboot.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("SELECT c FROM Cliente c where c.razonSocial= :razon_social AND c.CUIT = :cuit")
    Cliente getClienteByRazonSocialAndCUIT(@Param("razon_social") String rs, @Param("cuit") String cuit);
}
