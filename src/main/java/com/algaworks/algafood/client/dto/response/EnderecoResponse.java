package com.algaworks.algafood.client.dto.response;

import lombok.Data;

@Data
public class EnderecoResponse {

    private String cep;

    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    private CidadeResponse cidade;

}
