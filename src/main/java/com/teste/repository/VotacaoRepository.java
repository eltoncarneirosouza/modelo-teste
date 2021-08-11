package com.teste.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.teste.model.Votacao;

@Repository
public interface VotacaoRepository extends JpaRepository<Votacao, Long> {
	@Query(value = "SELECT v FROM Votacao v WHERE v.usuario = ?1 AND v.pauta = ?2")
	Optional<Votacao> findByVotacao(String usuario, String pauta);
}
