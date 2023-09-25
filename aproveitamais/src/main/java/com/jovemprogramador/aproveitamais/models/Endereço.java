package com.jovemprogramador.aproveitamais.models;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Endereço {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID codigoEndereço;
	
	@NotBlank
	@Column(nullable = false, unique = false)
	private long CEP;
	
	@Column(nullable = true, unique = false)
	private String número;
	
	@Column(nullable = true, unique = false)
	private String complemento;
	
}
