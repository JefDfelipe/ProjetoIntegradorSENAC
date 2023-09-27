package com.jovemprogramador.aproveitamais.models;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.UUID;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotBlank;


@Entity
public class PessoaFisica implements UserDetails {


    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID clientId;

	@NotBlank
	@Column(nullable = false, unique = false)
	private String nomeCliente;

	@NotBlank
	@Column(nullable = false, unique = true)
	private long CPF;

	@NotBlank
	@Column(nullable = false, unique = true)
	private String login;

	@NotBlank
	@Column(nullable = false, unique = false)
	private String senha;

	@NotBlank
	@Column(nullable = false, unique = false)
	private String telefone;

	@NotBlank
	@Column(nullable = false, unique = true)
	private UUID codigoEndereço;

  //----------------------------------------------------------------------\\

	public UUID getCodigoEndereço() {

		return codigoEndereço;

	}

	public void setCodigoEndereço(UUID codigoEndereço) {

		this.codigoEndereço = codigoEndereço;

	}


	public UUID getClientId() {

		return clientId;

	}


	public void setClientId(UUID clientId) {

		this.clientId = clientId;

	}


	public String getNomeCliente() {

		return nomeCliente;

	}


	public void setNomeCliente(String nomeCliente) {

		this.nomeCliente = nomeCliente;

	}

	public long getCPF() {

		return CPF;

	}


	public void setCPF(long cPF) {

		this.CPF = cPF;

	}


	public String getLogin() {

		return login;

	}


	public void setLogin(String login) {

		this.login = login;

	}


	public String getSenha() {

		return senha;

	}


	public void setSenha(String senha) {

		this.senha = senha;

	}

	public String getTelefone() {

		return telefone;

	}

	public void setTelefone(String telefone) {

		this.telefone = telefone;

	}


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
            
        throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
    }

    @Override
    public String getPassword() {
            
        return this.getPassword();
    }

    @Override
    public String getUsername() {
            
        return this.getUsername();
	}
    public boolean isAccountNonExpired() {
            
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
            
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
          
        return true;
    }

    @Override
    public boolean isEnabled() {
            
        return true;
    }
     
}
