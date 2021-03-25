package com.algaworks.algafood.client;

import com.algaworks.algafood.client.api.RestauranteClient;
import com.algaworks.algafood.client.api.exception.ClientApiException;
import com.algaworks.algafood.client.dto.request.CidadeRequest;
import com.algaworks.algafood.client.dto.request.CozinhaRequest;
import com.algaworks.algafood.client.dto.request.EnderecoRequest;
import com.algaworks.algafood.client.dto.request.RestauranteRequest;
import com.algaworks.algafood.client.dto.response.RestauranteResponse;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Objects;

public class InclusaoRestaurantesMain {

    public static void main(String[] args) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            RestauranteClient restauranteClient = new RestauranteClient(restTemplate, "http://localhost:8080");

            RestauranteRequest restauranteRequest = montarRestaurante();

            RestauranteResponse restauranteResponse = restauranteClient.adicionar(restauranteRequest);

            System.out.println(restauranteResponse);
        } catch (ClientApiException e) {
            String message = Objects.nonNull(e.getProblemResponse()) ? e.getProblemResponse().getUserMessage() : "Erro desconhecido";
            System.out.println(message);
        }
    }

    private static RestauranteRequest montarRestaurante() {
        CozinhaRequest cozinhaRequest = new CozinhaRequest();
        cozinhaRequest.setId(1L);

        CidadeRequest cidadeRequest = new CidadeRequest();
        cidadeRequest.setId(1L);

        EnderecoRequest enderecoRequest = new EnderecoRequest();
        enderecoRequest.setCep("38400-999");
        enderecoRequest.setLogradouro("Rua João Pinheiro");
        enderecoRequest.setNumero("1000");
        enderecoRequest.setBairro("Centro");
        enderecoRequest.setCidade(cidadeRequest);

        RestauranteRequest restauranteRequest = new RestauranteRequest();
        restauranteRequest.setNome("Peixaria Okada");
        restauranteRequest.setTaxaFrete(new BigDecimal(10));
        restauranteRequest.setCozinha(cozinhaRequest);
        restauranteRequest.setEndereco(enderecoRequest);

        return restauranteRequest;
    }

}
