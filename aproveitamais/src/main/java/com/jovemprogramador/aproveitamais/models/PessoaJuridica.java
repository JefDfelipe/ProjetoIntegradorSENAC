package com.jovemprogramador.aproveitamais.models;

import java.util.Collection;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class PessoaJuridica implements UserDetails {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID empresaId;
    
    @NotBlank
    @Column(nullable = false, unique = true)
    private String login;
	
    @NotBlank
    @Column(nullable = false, unique = true)
	private String nomeEmpresa;
	
    @NotBlank
    @Column(nullable = false, unique = false)
	private String senha;

    @NotBlank
    @Column(nullable = false, unique = true)
    private long CNPJ;

    @NotBlank
	@Column(nullable = false, unique = true)
	private UUID codigoEndereco;

	@Column(nullable = true, unique = true)
	private String inscricaoEstadual;

	@Column(nullable = false, unique = false)
	private String nomeFantasia;

    @NotBlank
	@Column(nullable = false, unique = true)
	private String razaoSocial;

    public UUID getempresaId(){
        return empresaId;
    }

    public String getlogin(){
        return login;
    }

    public String getnomeEmpresa(){
        return nomeEmpresa;
    }

    public String getsenha(){
        return senha;
    }

    public long getCNPJ(){
        return CNPJ;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
    }

    @Override
    public String getPassword() {
        
        return this.senha;
    }

    @Override
    public String getUsername() {
        
        return this.login;
    }

    @Override
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
