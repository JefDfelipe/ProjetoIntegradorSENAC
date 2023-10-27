package com.jovemprogramador.aproveitamais.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jovemprogramador.aproveitamais.models.Bebidas;


public interface BebidasRepository extends JpaRepository<Bebidas, UUID> {
    
}
