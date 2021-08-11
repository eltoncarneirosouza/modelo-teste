package com.teste.dto;

import java.util.Date;
import com.teste.model.Votacao;

public class VotacaoDTO {
	private String pauta;
	private String codUsuario;
	private String voto;

	public String getPauta() {
		return pauta;
	}

	public void setPauta(String pauta) {
		this.pauta = pauta;
	}

	public String getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getVoto() {
		return voto;
	}

	public void setVoto(String voto) {
		this.voto = voto;
	}

	public Votacao converter() {
		return new Votacao(this.codUsuario, this.pauta, this.voto, new Date());
	}

}
