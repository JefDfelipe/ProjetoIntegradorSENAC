package com.jovemprogramador.aproveitamais.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Sucos extends Bebidas {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID sucoId;

    @NotBlank
    @Column(nullable = false, unique = false)
    private String itens;

    // ----------------------------------------------------------------------\\

    public UUID getSucoId() {
        return sucoId;
    }

    public void setSucoId(UUID sucoId) {
        this.sucoId = sucoId;
    }

    public String getItens() {
        return itens;
    }

    public void setItens(String itens) {
        this.itens = itens;
    }

}