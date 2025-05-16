package com.server.api.feign.client.feigns;

import com.server.api.feign.client.dto.FilterListDto;
import com.server.api.feign.client.dto.requests.CreateUserRequestDto;
import com.server.api.feign.client.dto.requests.UpdateUserRequestDto;
import com.server.api.feign.client.dto.responses.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FeignClient(name = "fakestoreapi-users", url = "${base.url}", path = "/users")
public interface UserStoreFeignClient {
    @GetMapping
    List<UserResponseDto> getUsers(FilterListDto filterListDto);

    @GetMapping("/{id}")
    UserResponseDto getUserById(@PathVariable("id") int id);

    @PostMapping
    UserResponseDto createUser(@RequestBody CreateUserRequestDto createUserRequestDto);

    @PutMapping("/{id}")
    UserResponseDto updateUser(@PathVariable("id") int id, @RequestBody UpdateUserRequestDto updateUserRequestDto);

    @DeleteMapping("/{id}")
    UserResponseDto deleteUser(@PathVariable("id") int id);
}