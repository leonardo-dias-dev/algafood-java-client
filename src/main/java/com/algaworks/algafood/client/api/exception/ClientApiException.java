package com.algaworks.algafood.client.api.exception;

import com.algaworks.algafood.client.dto.response.ProblemResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestClientResponseException;

@Slf4j
public class ClientApiException extends RuntimeException {

    @Getter
    private ProblemResponse problemResponse;

    public ClientApiException(String message, RestClientResponseException cause) {
        super(message, cause);

        deserializedProblem(cause);
    }

    private void deserializedProblem(RestClientResponseException cause) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.findAndRegisterModules();

            this.problemResponse = objectMapper.readValue(cause.getResponseBodyAsString(), ProblemResponse.class);
        } catch (JsonProcessingException e) {
            log.warn("Não foi possível deserializar a resposta em um problema.");
        }
    }

}
