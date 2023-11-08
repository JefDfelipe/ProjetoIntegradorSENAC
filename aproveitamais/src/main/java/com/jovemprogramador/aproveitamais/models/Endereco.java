package com.jovemprogramador.aproveitamais.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "Endereco")
public class Endereco {
    

  private static final long serialVersionUID = 1L;


  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID codigoEndereco;

  @NotBlank
  @Column(nullable = false, unique = false)
  private long CEP;

  @NotBlank
  @Column(nullable = false, unique = false)
  private String numero;

  @Column(nullable = true, unique = false)
  @Enumerated(EnumType.STRING)
  private Complemento complemento;
}
