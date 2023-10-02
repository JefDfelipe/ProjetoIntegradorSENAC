package com.jovemprogramador.aproveitamais.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Mercearia extends Produtos {
    
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID merceariaId;

    @NotBlank
    @Column(nullable = false, unique = false)
    private String subCategoria;
    
  //----------------------------------------------------------------------\\


    public UUID getMerceariaId() {
        return merceariaId;
    }

    public void setMerceariaId(UUID merceariaId) {
        this.merceariaId = merceariaId;
    }

    public String getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(String subCategoria) {
        this.subCategoria = subCategoria;
    }

}
