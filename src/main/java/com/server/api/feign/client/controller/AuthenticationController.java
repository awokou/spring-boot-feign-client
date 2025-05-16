package com.server.api.feign.client.controller;

import com.server.api.feign.client.dto.requests.AuthRequestDto;
import com.server.api.feign.client.dto.responses.AuthResponseDto;
import com.server.api.feign.client.feigns.UserLoginStoreFeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final UserLoginStoreFeignClient userLoginStoreFeignClient;

    public AuthenticationController(UserLoginStoreFeignClient userLoginStoreFeignClient) {
        this.userLoginStoreFeignClient = userLoginStoreFeignClient;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody AuthRequestDto authRequestDto){
        return ResponseEntity.ok(this.userLoginStoreFeignClient.login(authRequestDto));
    }
}