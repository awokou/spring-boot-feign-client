package com.server.api.feign.client.controller;

import com.server.api.feign.client.dto.FilterListDto;
import com.server.api.feign.client.dto.requests.CreateProductRequestDto;
import com.server.api.feign.client.dto.requests.UpdateProductRequestDto;
import com.server.api.feign.client.dto.responses.ProductResponseDto;
import com.server.api.feign.client.feigns.ProductStoreFeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductStoreFeignClient productStoreFeignClient;

    public ProductController(ProductStoreFeignClient productStoreFeignClient) {
        this.productStoreFeignClient = productStoreFeignClient;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getProducts(FilterListDto filterListDto){
        return ResponseEntity.ok(this.productStoreFeignClient.getProducts(filterListDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable("id") Long id){
        return ResponseEntity.ok(this.productStoreFeignClient.getProductById(id));
    }

    @GetMapping("/categories")
    public ResponseEntity<List<String>> getCategories(){
        return ResponseEntity.ok(this.productStoreFeignClient.getCategories());
    }

    @GetMapping("/categories/{name}")
    public ResponseEntity<String> getCategoryByName(@PathVariable("name") String name){
        return ResponseEntity.ok(this.productStoreFeignClient.getCategoryByName(name));
    }
    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.productStoreFeignClient.createProduct(createProductRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable("id") Long id, @RequestBody UpdateProductRequestDto updateProductRequestDto){
        return ResponseEntity.ok(this.productStoreFeignClient.updateProduct(id, updateProductRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductResponseDto> deleteProduct(@PathVariable("id") Long id){
        return ResponseEntity.ok(this.productStoreFeignClient.deleteProduct(id));
    }
}
