package com.jovemprogramador.aproveitamais.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jovemprogramador.aproveitamais.models.PessoaJuridica;
import com.jovemprogramador.aproveitamais.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ImplementsUserDetailService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        
        PessoaJuridica empresa = usuarioRepository.findByLogin(login);

        if(empresa == null){
            throw new UsernameNotFoundException("Usuario não Encontrado!!");
        }

        return new User(empresa.getUsername(), empresa.getPassword(), true, true, true, true, empresa.getAuthorities());
    }
    
}
