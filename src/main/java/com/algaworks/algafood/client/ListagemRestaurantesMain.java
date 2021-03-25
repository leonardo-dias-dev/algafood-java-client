package com.algaworks.algafood.client;

import com.algaworks.algafood.client.api.exception.ClientApiException;
import com.algaworks.algafood.client.api.RestauranteClient;
import com.algaworks.algafood.client.dto.response.RestauranteResumoResponse;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

public class ListagemRestaurantesMain {

    public static void main(String[] args) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            RestauranteClient restauranteClient = new RestauranteClient(restTemplate, "http://localhost:8080");

            List<RestauranteResumoResponse> restaurantes = restauranteClient.listar();

            restaurantes.forEach(System.out::println);
        } catch (ClientApiException e) {
            String message = Objects.nonNull(e.getProblemResponse()) ? e.getProblemResponse().getUserMessage() : "Erro desconhecido";
            System.out.println(message);
        }
    }

}
