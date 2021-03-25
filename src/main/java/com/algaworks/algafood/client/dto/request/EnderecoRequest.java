package com.algaworks.algafood.client.dto.request;

import lombok.Data;

@Data
public class EnderecoRequest {

    private String cep;

    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    private CidadeRequest cidade;

}
