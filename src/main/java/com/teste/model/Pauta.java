package com.teste.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pauta")
public class Pauta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String pauta;
	private boolean ativo;
	private Date cadastro;
	private String chave;

	public Pauta() {

	}

	public Pauta(String pauta, boolean ativo, Date cadastro, String chave) {
		this.pauta = pauta;
		this.ativo = ativo;
		this.cadastro = cadastro;
		this.chave = chave;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ativo, cadastro, chave, id, pauta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pauta other = (Pauta) obj;
		return ativo == other.ativo && Objects.equals(cadastro, other.cadastro) && Objects.equals(chave, other.chave)
				&& id == other.id && Objects.equals(pauta, other.pauta);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public Date getCadastro() {
		return cadastro;
	}

	public void setCadastro(Date cadastro) {
		this.cadastro = cadastro;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

}
