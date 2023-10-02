package com.jovemprogramador.aproveitamais.models;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Endereco {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID codigoEndereco;
	
	@NotBlank
	@Column(nullable = false, unique = false)
	private long CEP;
	
	@Column(nullable = true, unique = false)
	private String número;
	
	@Column(nullable = true, unique = false)
	private String complemento;

  //----------------------------------------------------------------------\\

	public UUID getCodigoEndereco() {
		return codigoEndereco;
	}

	public void setCodigoEndereco(UUID codigoEndereco) {
		this.codigoEndereco = codigoEndereco;
	}

	public long getCEP() {
		return CEP;
	}

	public void setCEP(long cEP) {
		CEP = cEP;
	}

	public String getNúmero() {
		return número;
	}

	public void setNúmero(String número) {
		this.número = número;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
  
}
