package com.server.api.feign.client.feigns;

import com.server.api.feign.client.dto.requests.AuthRequestDto;
import com.server.api.feign.client.dto.responses.AuthResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "fakestoreapi-auths", url = "${base.url}", path = "/auth")
public interface UserLoginStoreFeignClient {
    @PostMapping("/login")
    AuthResponseDto login(@RequestBody AuthRequestDto authRequestDto);
}