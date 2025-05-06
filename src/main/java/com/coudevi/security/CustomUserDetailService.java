package com.coudevi.security;

import com.coudevi.domain.entity.Usuario;
import com.coudevi.domain.repository.IUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final IUsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        Usuario user = repository.findByNombre(nombre)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no registrado"));
        return new User(
                user.getNombre(),
                user.getContrasena(),
                user.getRoles().stream()
                        .map(r -> new SimpleGrantedAuthority(r))
                        .toList()
        );


    }
}
