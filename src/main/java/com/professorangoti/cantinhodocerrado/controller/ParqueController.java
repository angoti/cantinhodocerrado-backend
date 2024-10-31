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
	public ResponseEntity<Parque> updateParque(@PathVariable Long id, @RequestBody Parque parqueDetails) {
		return parqueRepository.findById(id)
				.map(parque -> {
					parque.setNome(parqueDetails.getNome());
					parque.setLocalizacao(parqueDetails.getLocalizacao());
					parque.setEstadoConservacao(parqueDetails.getEstadoConservacao());
					parque.setTamanhoArea(parqueDetails.getTamanhoArea());
					parque.setHorarioVisitacao(parqueDetails.getHorarioVisitacao());
					parque.setAtrativosTuristicos(parqueDetails.getAtrativosTuristicos());
					parque.setEducacaoAmbiental(parqueDetails.isEducacaoAmbiental());
					parque.setDificuldadeTrilhas(parqueDetails.getDificuldadeTrilhas());
					parque.setBanheiros(parqueDetails.isBanheiros());
					parque.setBebedouro(parqueDetails.isBebedouro());
					parque.setAcessibilidade(parqueDetails.getAcessibilidade());
					parque.setEstacionamento(parqueDetails.isEstacionamento());
					parque.setContato(parqueDetails.getContato());
					parque.setRedesSociais(parqueDetails.getRedesSociais());
					parque.setReferenciasInformacoes(parqueDetails.getReferenciasInformacoes());
					parque.setFotos(parqueDetails.getFotos());
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
