package com.jovemprogramador.aproveitamais.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Item extends Produtos {

    
    private static final long serialVersionUID = 1L;

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID itemId;

    @NotBlank
    @Column(nullable = false, unique = true)
    private long tipo;

    @NotBlank
    @Column(nullable = false, unique = false)
    private String nome;
    

  //----------------------------------------------------------------------\\

  
}