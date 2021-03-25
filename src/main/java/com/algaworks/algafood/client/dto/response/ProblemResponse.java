package com.algaworks.algafood.client.dto.response;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class ProblemResponse {

    private Integer status;

    private OffsetDateTime timestamp;

    private String userMessage;

}
