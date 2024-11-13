package com.professorangoti.cantinhodocerrado.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.Map;

@Data
@Embeddable
public class HorarioVisitacao {

	@ElementCollection
	private Map<String, String> horarioPorDia;

	// Exemplo de Map: {"Segunda-feira": "08:00-18:00", "Terça-feira":
	// "08:00-18:00"}
}
