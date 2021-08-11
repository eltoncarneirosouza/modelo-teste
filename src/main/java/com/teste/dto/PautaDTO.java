package com.teste.dto;

import java.util.Date;
import java.util.UUID;

import com.teste.model.Pauta;

public class PautaDTO {
	private String pauta;
	private boolean ativo;

	public String getPauta() {
		return pauta;
	}

	public void setPauta(String pauta) {
		this.pauta = pauta;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Pauta converter() {
		UUID randomico = UUID.randomUUID();
		String codigo = randomico.toString();
		return new Pauta(this.pauta, this.ativo, new Date(), codigo);
	}

}
