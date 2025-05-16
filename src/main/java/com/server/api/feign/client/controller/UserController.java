package com.server.api.feign.client.controller;

import com.server.api.feign.client.dto.FilterListDto;
import com.server.api.feign.client.dto.requests.CreateUserRequestDto;
import com.server.api.feign.client.dto.requests.UpdateUserRequestDto;
import com.server.api.feign.client.dto.responses.UserResponseDto;
import com.server.api.feign.client.feigns.UserStoreFeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserStoreFeignClient userStoreFeignClient;

    public UserController(UserStoreFeignClient userStoreFeignClient) {
        this.userStoreFeignClient = userStoreFeignClient;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getUsers(FilterListDto filterListDto){
        return ResponseEntity.ok(this.userStoreFeignClient.getUsers(filterListDto));
    }

    @GetMapping("/{id}")
    public  ResponseEntity<UserResponseDto> getUserById(@PathVariable("id") int id){
        return ResponseEntity.ok(this.userStoreFeignClient.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody CreateUserRequestDto createUserRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userStoreFeignClient.createUser(createUserRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable("id") int id, @RequestBody UpdateUserRequestDto updateUserRequestDto){
        return ResponseEntity.ok(this.userStoreFeignClient.updateUser(id, updateUserRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponseDto> deleteUser(@PathVariable("id") int id){
        return ResponseEntity.ok(this.userStoreFeignClient.deleteUser(id));
    }
}
