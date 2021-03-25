package com.algaworks.algafood.client.api;

import com.algaworks.algafood.client.api.exception.ClientApiException;
import com.algaworks.algafood.client.dto.request.RestauranteRequest;
import com.algaworks.algafood.client.dto.response.RestauranteResponse;
import com.algaworks.algafood.client.dto.response.RestauranteResumoResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class RestauranteClient {

    private static final String RESOURCE_PATH = "/restaurantes";

    private final RestTemplate restTemplate;

    private final String url;

    public List<RestauranteResumoResponse> listar() {
        try {
            URI uri = URI.create(url + RESOURCE_PATH);

            RestauranteResumoResponse[] restaurantes = restTemplate.getForObject(uri, RestauranteResumoResponse[].class);

            return Arrays.asList(restaurantes);
        } catch (RestClientResponseException e) {
            throw new ClientApiException(e.getMessage(), e);
        }
    }

    public RestauranteResponse adicionar(RestauranteRequest restauranteRequest) {
        try {
            URI uri = URI.create(url + RESOURCE_PATH);

            RestauranteResponse restauranteResponse = restTemplate.postForObject(uri, restauranteRequest, RestauranteResponse.class);

            return restauranteResponse;
        } catch (RestClientResponseException e) {
            throw new ClientApiException(e.getMessage(), e);
        }
    }

    public RestauranteResponse buscar(Long id) {
        try {
            URI uri = URI.create(url + RESOURCE_PATH + "/" + id);

            RestauranteResponse restauranteResponse = restTemplate.getForObject(uri, RestauranteResponse.class);

            return restauranteResponse;
        } catch (RestClientResponseException e) {
            throw new ClientApiException(e.getMessage(), e);
        }
    }

}
