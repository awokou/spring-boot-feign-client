package com.server.api.feign.client.dto.responses;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductResponseDto implements Serializable {
    private Long id;
    private String title;
    private String description;
    private String category;
    private Double price;
    private String image;
}