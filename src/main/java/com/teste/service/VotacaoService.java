package com.teste.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.dto.VotacaoDTO;
import com.teste.model.Pauta;
import com.teste.model.Usuario;
import com.teste.model.Votacao;
import com.teste.repository.PautaRepository;
import com.teste.repository.UsuarioRepository;
import com.teste.repository.VotacaoRepository;

@Service
public class VotacaoService {
	@Autowired
	private PautaRepository pautaRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private VotacaoRepository votacaoRepository;
	@Autowired
	private VotacaoService votacaoService;

	public Votacao cadastrar(VotacaoDTO votacaoDTO) {
		String usuario = votacaoDTO.getCodUsuario();
		Usuario user = extraindoUsuario(usuario);
		String pauta = votacaoDTO.getPauta();
		Pauta pautas = extraindoPauta(pauta);
		return votacaoService.salvar(user, pautas, votacaoDTO);
	}

	private Votacao salvar(Usuario user, Pauta pautas, VotacaoDTO dto) {
		Votacao votacao = new Votacao();
		if (pautas.isAtivo()) {
			Optional<Votacao> findVotacao = votacaoRepository.findByVotacao(dto.getCodUsuario(), dto.getPauta());

			if (findVotacao.isPresent()) {
				return null;
			} else {
				Votacao voto = dto.converter();
				votacaoRepository.save(voto);
				Optional<Votacao> votacoes = votacaoRepository.findByVotacao(voto.getUsuario(), voto.getPauta());
				votacao = votacoes.get();
			}
		}

		return votacao;
	}

	private Pauta extraindoPauta(String pauta) {
		Pauta pautas = new Pauta();
		Optional<Pauta> findPauta = pautaRepository.findByChave(pauta);
		if (findPauta.isPresent()) {
			pautas = findPauta.get();
		}
		return pautas;
	}

	private Usuario extraindoUsuario(String usuario) {
		Optional<Usuario> findCodigo = usuarioRepository.findByUsuario(usuario);
		Usuario user = new Usuario();
		if (findCodigo.isPresent()) {
			user = findCodigo.get();
		}
		return user;
	}

}
