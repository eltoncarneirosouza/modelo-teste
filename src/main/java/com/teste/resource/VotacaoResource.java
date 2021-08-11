package com.teste.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.dto.VotacaoDTO;
import com.teste.model.Votacao;
import com.teste.service.VotacaoService;

@RestController
@RequestMapping("votacao/v1")
public class VotacaoResource {
	@Autowired
	private VotacaoService votacaoService;

	@PostMapping("votacao")
	public Votacao votacao(@RequestBody VotacaoDTO votacaoDTO) {
		return votacaoService.cadastrar(votacaoDTO);

	}
}
