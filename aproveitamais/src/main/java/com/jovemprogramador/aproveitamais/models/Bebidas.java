package com.jovemprogramador.aproveitamais.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Bebidas extends Produtos{
    

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID bebidaId;

    @NotBlank
    @Column(nullable = false, unique = false)
    private String subCategoriaB;
    
  //----------------------------------------------------------------------\\

    public UUID getBebidaId() {
        return bebidaId;
    }

    public void setBebidaId(UUID bebidaId) {
        this.bebidaId = bebidaId;
    }

    public String getSubCategoriaB() {
        return subCategoriaB;
    }

    public void setSubCategoriaB(String subCategoriaB) {
        this.subCategoriaB = subCategoriaB;
    }
  
}
