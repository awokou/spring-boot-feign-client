package com.server.api.feign.client.dto.responses;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductQuantityResponseDto implements Serializable {
    private int productId;
    private int quantity;
}