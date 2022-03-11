package com.generation.GameStore.security;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.generation.GameStore.model.Usuarios;
import com.generation.GameStore.repository.UsuariosRepository;

@Service
public class UserDetailsServiceimpl implements UserDetailsService {
	@Autowired
	private UsuariosRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<Usuarios> usuario = userRepository.findByUsuario(userName);
		  
		usuario.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));

		return usuario.map(UserDetailslmpl::new).get();
	}
	
}
