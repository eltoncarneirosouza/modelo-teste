package com.teste.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.model.Pauta;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long> {

	Optional<Pauta> findByChave(String chave);
}
