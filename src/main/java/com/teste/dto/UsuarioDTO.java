package com.teste.dto;

import java.util.Date;
import java.util.UUID;

import com.teste.model.Usuario;

public class UsuarioDTO {
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario coverter() {
		UUID randomico = UUID.randomUUID();
		String codigo = randomico.toString();
		return new Usuario(this.nome, new Date(), codigo.substring(0, 6));
	}

}
