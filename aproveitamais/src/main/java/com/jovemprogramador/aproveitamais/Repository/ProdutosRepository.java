package com.jovemprogramador.aproveitamais.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jovemprogramador.aproveitamais.models.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, UUID> {

    Optional<Produtos> findById(UUID produtoId);
    
}
