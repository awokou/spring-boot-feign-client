package com.server.api.feign.client.feigns;

import com.server.api.feign.client.dto.FilterListDto;
import com.server.api.feign.client.dto.requests.CreateCardRequestDto;
import com.server.api.feign.client.dto.requests.UpdateCardRequestDto;
import com.server.api.feign.client.dto.responses.CardResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "fakestoreapi-cards", url = "${base.url}", path = "/cards")
public interface CardStoreFeignClient {
    @GetMapping
    List<CardResponseDto> getCards(FilterListDto filterListDto);

    @GetMapping("/user/{id}")
    List<CardResponseDto> getCardsByUserId(@PathVariable("id") int id);

    @GetMapping("/{id}")
    CardResponseDto getCardById(@PathVariable("id") int id);

    @PostMapping
    CardResponseDto createCard(@RequestBody CreateCardRequestDto createCardRequestDto);

    @PutMapping("/{id}")
    CardResponseDto updateCard(@PathVariable("id") int id, @RequestBody UpdateCardRequestDto updateCardRequestDto);

    @DeleteMapping("/{id}")
    CardResponseDto deleteCard(@PathVariable("id") int id);
}
