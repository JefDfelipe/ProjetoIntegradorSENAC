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

<<<<<<< HEAD:aproveitamais/src/main/java/com/jovemprogramador/aproveitamais/models/Alimentos.java
=======
  public UUID getProdutoId() {
    return produtoId;
  }

  public void setProdutoId(UUID produtoId) {
    this.produtoId = produtoId;
  }

  public long getCodigoDeBarras() {
    return codigoDeBarras;
  }

  public void setCodigoDeBarras(long codigoDeBarras) {
    this.codigoDeBarras = codigoDeBarras;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getMercadoDeOrigem() {
    return mercadoDeOrigem;
  }

  public void setMercadoDeOrigem(String mercadoDeOrigem) {
    this.mercadoDeOrigem = mercadoDeOrigem;
  }

  public float getPreco() {
    return preco;
  }

  public void setPreco(float preco) {
    this.preco = preco;
  }
>>>>>>> 87d2dc1aef0593b0ded63b6eb1fc0094049d04c7:aproveitamais/src/main/java/com/jovemprogramador/aproveitamais/models/Produtos.java

}
