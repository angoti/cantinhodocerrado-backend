package com.professorangoti.cantinhodocerrado.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    
    private String endereco;
    
    @Column(length = 600)
    private String estadoConservacao;
    
    private Double tamanhoArea;
    
    @Embedded
    private HorarioVisitacao horarioVisitacao;
    
    @Column(length = 600)
    private String atrativosTuristicos;
    
    @Column(length = 600)
    private String educacaoAmbiental;
    
    @Column(length = 600)
    private String dificuldadeTrilhas;
    
    @Column(length = 600)
    private String descricaoTrilhas;
    
    private boolean banheiros;
    
    private boolean bebedouro;
    
    private boolean estacionamento;
    
    @Column(length = 600)
    private String acessibilidade;
    
    private String contato;
    
    private String redesSociais;
        
    @Column(length = 600)
    private String demaisInformacoes;

    @ElementCollection
    private List<String> fotos;

}
