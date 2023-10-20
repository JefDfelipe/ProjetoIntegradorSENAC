package com.jovemprogramador.aproveitamais.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

  @Bean
  public DefaultSecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http

        .csrf((csrf) -> csrf.disable())

        .authorizeHttpRequests((authz) -> authz
            .requestMatchers(HttpMethod.GET, "/").permitAll()
            .requestMatchers(HttpMethod.GET, "/cadastrarProdutos")
            .hasRole("EMPRESA")
            .requestMatchers(HttpMethod.POST, "/cadastrarProdutos")
            .hasRole("EMPRESA")
            .anyRequest().authenticated())

        .formLogin((formLogin) -> formLogin

            .loginPage("/login")
            .defaultSuccessUrl("/minhaConta", true)
            .permitAll())

        .logout((logout) -> logout

            .logoutSuccessUrl("/")
            .permitAll());

    return http.build();
  }

}
