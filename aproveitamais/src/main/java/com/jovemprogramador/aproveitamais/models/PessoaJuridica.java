package com.jovemprogramador.aproveitamais.models;

// import java.util.Collection;
import java.util.UUID;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "pessoa_juridica")
// public class PessoaJuridica implements UserDetails {
public class PessoaJuridica {

  private static final long serialVersionUID = 1L;

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

  // ----------------------------------------------------------------------\\

  // @Override
  // public Collection<? extends GrantedAuthority> getAuthorities() {

  // throw new UnsupportedOperationException("Unimplemented method
  // 'getAuthorities'");
  // }

  // @Override
  // public String getPassword() {

  // return this.senha;
  // }

  // @Override
  // public String getUsername() {

  // return this.login;
  // }

  // @Override
  // public boolean isAccountNonExpired() {

  // return true;
  // }

  // @Override
  // public boolean isAccountNonLocked() {

  // return true;
  // }

  // @Override
  // public boolean isCredentialsNonExpired() {

  // return true;
  // }

  // @Override
  // public boolean isEnabled() {

  // return true;
  // }

}
