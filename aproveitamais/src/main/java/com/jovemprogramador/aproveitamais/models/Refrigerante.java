package com.jovemprogramador.aproveitamais.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Refrigerante extends Bebidas {
    

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID refrigeranteId;
    
    @NotBlank
    @Column(nullable = false, unique = true)
    private String itens;
 
  //----------------------------------------------------------------------\\


    public UUID getRefrigeranteId() {
        return refrigeranteId;
    }

    public void setRefrigeranteId(UUID refrigeranteId) {
        this.refrigeranteId = refrigeranteId;
    }

    public String getItens() {
        return itens;
    }

    public void setItens(String itens) {
        this.itens = itens;
    }

}
