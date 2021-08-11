package com.teste.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.dto.UsuarioDTO;
import com.teste.model.Usuario;
import com.teste.repository.UsuarioRepository;
import com.teste.service.UsuarioService;

@RestController
@RequestMapping("usuario/v1")
public class UsuarioResource {
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("lista")
	public List<Usuario> usuario() {
		return usuarioRepository.findAll();
	}

	@PostMapping("cadastro")
	public Usuario cadastro(@RequestBody UsuarioDTO usuario) {
		Usuario user = usuario.coverter();
		return usuarioService.cadastrar(user);
	}
}
