package com.jovemprogramador.aproveitamais.models;

import java.util.Collection;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PessoaJuridica implements UserDetails {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID empresaId;

    private String login;
	
	private String nomeEmpresa;
	
	private String senha;

    private long CNPJ;

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
