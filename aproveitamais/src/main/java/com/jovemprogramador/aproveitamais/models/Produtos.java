package com.jovemprogramador.aproveitamais.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Produtos {



    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID produtoId;

    @NotBlank
    @Column(nullable = false, unique = true)
    private long codigoDeBarras;

    @NotBlank
    @Column(nullable = false, unique = false)
    private String marca;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String categoria;

    @NotBlank
    @Column(nullable = false, unique = false)
    private String mercadoDeOrigem;

  //----------------------------------------------------------------------\\

    public UUID getprodutoId() {

        return produtoId;

    }

    public void setprodutoId(UUID produtoId) {

        this.produtoId = produtoId;

    }

    public long getcodigoDeBarras() {

        return codigoDeBarras;

    }


    public void setcodigoDeBarras(long codigoDeBarras) {

        this.codigoDeBarras = codigoDeBarras;

    }

    public String getmarca() {

        return marca;

    }

    public void setmarca(String marca) {

        this.marca = marca;

    }

    public String getcategoria() {

        return categoria;

    }

    public void setcategoria(String categoria) {

        this.categoria = categoria;

    }

    public String getmercadoDeOrigem() {

        return mercadoDeOrigem;

    }

    public void setmercadoDeOrigem(String mercadoDeOrigem) {

        this.mercadoDeOrigem = mercadoDeOrigem;

    }
}
