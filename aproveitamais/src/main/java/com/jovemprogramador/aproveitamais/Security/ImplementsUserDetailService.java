package com.jovemprogramador.aproveitamais.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import com.jovemprogramador.aproveitamais.models.PessoaFisica;
import com.jovemprogramador.aproveitamais.models.PessoaJuridica;
import com.jovemprogramador.aproveitamais.repository.PessoaFisicaRepository;
import com.jovemprogramador.aproveitamais.repository.PessoaJuridicaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ImplementsUserDetailService implements UserDetailsService {

    @Autowired
    PessoaJuridicaRepository pessoaJuridicaRepository;
    PessoaFisicaRepository pessoaFisicaRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        PessoaJuridica empresa = pessoaJuridicaRepository.findByLogin(login);

        PessoaFisica cliente = pessoaFisicaRepository.findByLogin(login);

        if (empresa == null && cliente == null) {
            throw new UsernameNotFoundException("Usuario não Encontrado!!");
        }

        // Objeto genérico com o usuário            comparação if      se verdadeiro      senão   se comparação for falsa
        UserDetails userDetails = new User(login, (empresa != null) ? empresa.getPassword() : cliente.getPassword(), true, true, true, true, (empresa != null) ? empresa.getAuthorities() : cliente.getAuthorities());

        return userDetails;
    }
}