package com.server.api.feign.client.dto.requests;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductQuantityRequestDto implements Serializable {
    private int productId;
    private int quantity;
}
