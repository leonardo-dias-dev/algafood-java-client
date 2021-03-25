package com.algaworks.algafood.client;

import com.algaworks.algafood.client.api.RestauranteClient;
import com.algaworks.algafood.client.api.exception.ClientApiException;
import com.algaworks.algafood.client.dto.response.RestauranteResponse;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

public class BuscarRestaurantesMain {

    public static void main(String[] args) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            RestauranteClient restauranteClient = new RestauranteClient(restTemplate, "http://localhost:8080");

            RestauranteResponse restauranteResponse = restauranteClient.buscar(8L);

            System.out.println(restauranteResponse);
        } catch (ClientApiException e) {
            String message = Objects.nonNull(e.getProblemResponse()) ? e.getProblemResponse().getUserMessage() : "Erro desconhecido";
            System.out.println(message);
        }
    }

}
