package com.teste.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.model.Pauta;
import com.teste.repository.PautaRepository;

@Service
public class PautaService {
	@Autowired
	private PautaRepository pautaRepository;

	public Pauta cadastrar(Pauta pautas) {
	
		try {
			return pautaRepository.save(pautas);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
