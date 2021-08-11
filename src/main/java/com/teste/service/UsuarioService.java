package com.teste.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.model.Usuario;
import com.teste.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario cadastrar(Usuario user) {
		try {
			Usuario usuario = usuarioRepository.save(user);
			return usuario;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
