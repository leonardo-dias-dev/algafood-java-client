package com.algaworks.algafood.client.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RestauranteResponse {

    private Long id;

    private String nome;

    private BigDecimal taxaFrete;

    private Boolean ativo;

    private Boolean aberto;

    private CozinhaResponse cozinha;

    private EnderecoResponse endereco;

}
