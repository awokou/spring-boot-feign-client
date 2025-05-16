package com.server.api.feign.client.controller;


import com.server.api.feign.client.dto.FilterListDto;
import com.server.api.feign.client.dto.requests.CreateCardRequestDto;
import com.server.api.feign.client.dto.requests.UpdateCardRequestDto;
import com.server.api.feign.client.dto.responses.CardResponseDto;
import com.server.api.feign.client.feigns.CardStoreFeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cards")
public class CardController {
    private final CardStoreFeignClient cardStoreFeignClient;

    public CardController(CardStoreFeignClient cardStoreFeignClient) {
        this.cardStoreFeignClient = cardStoreFeignClient;
    }

    @GetMapping
    public ResponseEntity<List<CardResponseDto>> getCards(FilterListDto filterListDto){
        return ResponseEntity.ok(this.cardStoreFeignClient.getCards(filterListDto));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<CardResponseDto>> getCardsByUserId(@PathVariable("id") int id){
        return ResponseEntity.ok(this.cardStoreFeignClient.getCardsByUserId(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardResponseDto> getCardById(@PathVariable("id") int id){
        return ResponseEntity.ok(this.cardStoreFeignClient.getCardById(id));
    }

    @PostMapping
    public ResponseEntity<CardResponseDto> createCard(@RequestBody CreateCardRequestDto createCardRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.cardStoreFeignClient.createCard(createCardRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardResponseDto> updateCard(@PathVariable("id") int id, @RequestBody UpdateCardRequestDto updateCardRequestDto){
        return ResponseEntity.ok(this.cardStoreFeignClient.updateCard(id, updateCardRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CardResponseDto> deleteCard(@PathVariable("id") int id){
        return ResponseEntity.ok(this.cardStoreFeignClient.deleteCard(id));
    }
}