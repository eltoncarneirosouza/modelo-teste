package com.teste.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.dto.PautaDTO;
import com.teste.model.Pauta;
import com.teste.repository.PautaRepository;
import com.teste.service.PautaService;

@RestController
@RequestMapping("pauta/v1")
public class PautaResource {
	@Autowired
	private PautaService pautaService;
	@Autowired
	private PautaRepository pautaRepository;

	@GetMapping("lista")
	public List<Pauta> lista() {
		return pautaRepository.findAll();
	}

	@GetMapping("lista/{pauta}")
	public Optional<Pauta> listaPauta(@PathVariable("pauta") String pauta) {
		return pautaRepository.findByChave(pauta);
	}

	@PostMapping("cadastro")
	public Pauta cadastrar(@RequestBody PautaDTO pauta) {
		Pauta pautas = pauta.converter();
		return pautaService.cadastrar(pautas);
	}
}
