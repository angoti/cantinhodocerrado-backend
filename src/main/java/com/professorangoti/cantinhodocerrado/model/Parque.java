package com.professorangoti.cantinhodocerrado.model;

import java.util.List;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.Data;

@Data
@Entity
public class Parque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(length = 600)
    private String descricao;

    @Embedded
    private Coordenadas localizacao;

    @Enumerated(EnumType.STRING)
    private EstadoConservacao estadoConservacao;

    private Double tamanhoArea;

    @Embedded
    private HorarioVisitacao horarioVisitacao;

    private String atrativosTuristicos;

    private boolean educacaoAmbiental;

    @Enumerated(EnumType.STRING)
    private DificuldadeTrilhas dificuldadeTrilhas;

    private boolean banheiros;

    private boolean bebedouro;

    private String acessibilidade;

    private boolean estacionamento;

    private String contato;

    private String redesSociais;

    private String referenciasInformacoes;

    @ElementCollection
    private List<String> fotos;

}
