package com.algaworks.algafood.client.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RestauranteResumoResponse {

    private Long id;

    private String nome;

    private BigDecimal taxaFrete;

    private CozinhaResponse cozinha;

}
