package com.server.api.feign.client.dto.requests;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthRequestDto implements Serializable {
    private String username;
    private String password;
}
