package com.jovemprogramador.aproveitamais.models;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
  @Enumerated(EnumType.STRING)
  private Categoria categoria;

  @NotBlank
  @Column(nullable = false, unique = false)
  private String mercadoDeOrigem;

  @NotBlank
  @Column(nullable = false, unique = false)
  private float preco;

  // ----------------------------------------------------------------------\\

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

}
