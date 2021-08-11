package com.teste.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "votacao")
public class Votacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String usuario;
	private String pauta;
	private String voto;
	private Date cadastro;

	public Votacao() {
	}

	public Votacao(String usuario, String pauta, String voto, Date cadastro) {
		this.usuario = usuario;
		this.pauta = pauta;
		this.voto = voto;
		this.cadastro = cadastro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cadastro, id, pauta, usuario, voto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Votacao other = (Votacao) obj;
		return Objects.equals(cadastro, other.cadastro) && id == other.id && Objects.equals(pauta, other.pauta)
				&& Objects.equals(usuario, other.usuario) && Objects.equals(voto, other.voto);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPauta() {
		return pauta;
	}

	public void setPauta(String pauta) {
		this.pauta = pauta;
	}

	public String getVoto() {
		return voto;
	}

	public void setVoto(String voto) {
		this.voto = voto;
	}

	public Date getCadastro() {
		return cadastro;
	}

	public void setCadastro(Date cadastro) {
		this.cadastro = cadastro;
	}

}
