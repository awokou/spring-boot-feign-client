package com.server.api.feign.client.dto.responses;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthResponseDto implements Serializable {
    private String token;
}
