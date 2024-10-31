package com.professorangoti.cantinhodocerrado.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Coordenadas {
	private Double latitude;
	private Double longitude;

}
