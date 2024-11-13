package com.professorangoti.cantinhodocerrado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.professorangoti.cantinhodocerrado.model.Parque;
import com.professorangoti.cantinhodocerrado.repository.ParqueRepository;

@RestController
@RequestMapping("/parques")
public class ParqueController {

	@Autowired
	private ParqueRepository parqueRepository;

	@GetMapping
	public List<Parque> getAllParques() {
		return parqueRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Parque> getParqueById(@PathVariable Long id) {
		return parqueRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Parque createParque(@RequestBody Parque parque) {
		return parqueRepository.save(parque);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Parque> updateParque(@PathVariable Long id, @RequestBody Parque p) {
		return parqueRepository.findById(id)
				.map(parque -> {
					if (p.getDescricao() != null) {
						parque.setDescricao(p.getDescricao());
					}
					if (p.getNome() != null) {
						parque.setNome(p.getNome());
					}
					if (p.getLocalizacao() != null) {
						parque.setLocalizacao(p.getLocalizacao());
					}
					if (p.getEstadoConservacao() != null) {
						parque.setEstadoConservacao(p.getEstadoConservacao());
					}
					if (p.getTamanhoArea() != null) {
						parque.setTamanhoArea(p.getTamanhoArea());
					}
					if (p.getHorarioVisitacao() != null) {
						parque.setHorarioVisitacao(p.getHorarioVisitacao());
					}
					if (p.getAtrativosTuristicos() != null) {
						parque.setAtrativosTuristicos(p.getAtrativosTuristicos());
					}
					if (p.getEducacaoAmbiental() != null) {
						parque.setEducacaoAmbiental(p.getEducacaoAmbiental());
					}
					if (p.getDificuldadeTrilhas() != null) {
						parque.setDificuldadeTrilhas(p.getDificuldadeTrilhas());
					}
					if (p.getDescricaoTrilhas() != null) {
						parque.setDescricaoTrilhas(p.getDescricaoTrilhas());
					}
					if (p.isBanheiros() != parque.isBanheiros()) {
						parque.setBanheiros(p.isBanheiros());
					}
					if (p.isBebedouro() != parque.isBebedouro()) {
						parque.setBebedouro(p.isBebedouro());
					}
					if (p.getAcessibilidade() != null) {
						parque.setAcessibilidade(p.getAcessibilidade());
					}
					if (p.isEstacionamento() != parque.isEstacionamento()) {
						parque.setEstacionamento(p.isEstacionamento());
					}
					if (p.getContato() != null) {
						parque.setContato(p.getContato());
					}
					if (p.getRedesSociais() != null) {
						parque.setRedesSociais(p.getRedesSociais());
					}
					if (p.getDemaisInformacoes() != null) {
						parque.setDemaisInformacoes(p.getDemaisInformacoes());
					}
					if (p.getFotos() != null) {
						parque.setFotos(p.getFotos());
					}
					if (p.getEndereco() != null) {
						parque.setEndereco(p.getEndereco());
					}
					if (p.getEstrutura() != null) {
						parque.setEstrutura(p.getEstrutura());
					}
					return ResponseEntity.ok(parqueRepository.save(parque));
				})
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteParque(@PathVariable Long id) {
		return parqueRepository.findById(id)
				.map(parque -> {
					parqueRepository.delete(parque);
					return ResponseEntity.ok().<Void>build();
				})
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
}
