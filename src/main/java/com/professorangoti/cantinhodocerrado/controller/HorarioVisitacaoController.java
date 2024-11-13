package com.professorangoti.cantinhodocerrado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.professorangoti.cantinhodocerrado.repository.HorarioVisitacao;

@RestController
@RequestMapping("/horarios")
public class HorarioVisitacaoController {

	@Autowired
	HorarioVisitacao horarioVisitacao;

	@GetMapping
	public List<HorarioVisitacao> getMethodName() {
		return horarioVisitacao.findAll();
	}

	@DeleteMapping("/todos")
	public void deleteAll() {
		horarioVisitacao.deleteAll();
	}

}
