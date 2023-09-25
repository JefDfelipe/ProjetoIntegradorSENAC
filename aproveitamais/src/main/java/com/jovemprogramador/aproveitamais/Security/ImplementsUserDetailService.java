package com.jovemprogramador.aproveitamais.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.security.core.userdetails.UserDetailsService;
=======
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
>>>>>>> 45319b08c57ae2ba6e51deb3299819f445adc56f
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
        
        PessoaJuridica empresa = usuarioRepository.findByLoginPJ(login);

        if(empresa == null){
            throw new UsernameNotFoundException("Usuario não Encontrado!!");
        }

        return new User(empresa.getUsername(), empresa.getPassword(), true, true, true, true, empresa.getAuthorities());
    }
    
}
