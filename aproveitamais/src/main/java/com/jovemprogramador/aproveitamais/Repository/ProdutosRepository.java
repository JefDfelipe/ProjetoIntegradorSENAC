package com.jovemprogramador.aproveitamais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jovemprogramador.aproveitamais.models.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos,String> {

    Produtos findBycodigoDeBarras(long codigoDeBarras);
    
}
