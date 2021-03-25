package com.algaworks.algafood.client.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RestauranteRequest {

    private String nome;

    private BigDecimal taxaFrete;

    private CozinhaRequest cozinha;

    private EnderecoRequest endereco;

}
