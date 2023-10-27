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
@Table(name = "alimentos")
public class Alimentos {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID alimentosId;

  @NotBlank
  @Column(nullable = false, unique = true)
  private long codigoDeBarras;

  @NotBlank
  @Column(nullable = false, unique = false)
  private String marca;

  @NotBlank
  @Column(nullable = false, unique = true)
  @Enumerated(EnumType.STRING)
  private Categoria categoria;

  @NotBlank
  @Column(nullable = false, unique = false)
  private String mercadoDeOrigem;

  @NotBlank
  @Column(nullable = false, unique = false)
  private float preco;

  // ----------------------------------------------------------------------\\


}
