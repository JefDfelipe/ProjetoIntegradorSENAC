package com.jovemprogramador.aproveitamais.models;

import java.util.Collection;
import java.util.UUID;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return this.senha;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;    
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

}
