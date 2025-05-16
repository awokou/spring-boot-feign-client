package com.server.api.feign.client.feigns;

import com.server.api.feign.client.dto.FilterListDto;
import com.server.api.feign.client.dto.requests.CreateProductRequestDto;
import com.server.api.feign.client.dto.requests.UpdateProductRequestDto;
import com.server.api.feign.client.dto.responses.ProductResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "fakestoreapi-products", url = "${base.url}", path = "/products")
public interface ProductStoreFeignClient {
    @GetMapping
    List<ProductResponseDto> getProducts(FilterListDto filterListDto);

    @GetMapping("/{id}")
    ProductResponseDto getProductById(@PathVariable("id") Long id);

    @GetMapping("/categories")
    List<String> getCategories();

    @GetMapping("/categories/{name}")
    String getCategoryByName(@PathVariable("name") String name);

    @PostMapping
    ProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto);

    @PutMapping("/{id}")
    ProductResponseDto updateProduct(@PathVariable("id") Long id, @RequestBody UpdateProductRequestDto updateProductRequestDto);

    @DeleteMapping("/{id}")
    ProductResponseDto deleteProduct(@PathVariable("id") Long id);
}
