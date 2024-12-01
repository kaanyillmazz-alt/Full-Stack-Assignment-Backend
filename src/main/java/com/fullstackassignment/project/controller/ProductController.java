package com.fullstackassignment.project.controller;

import com.fullstackassignment.project.dto.ProductDTO;
import com.fullstackassignment.project.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/v1/products")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<ProductDTO> getProducts(
            @RequestParam(required = false) BigDecimal priceMin,
            @RequestParam(required = false) BigDecimal priceMax,
            @RequestParam(required = false) Double popularityMin) throws IOException {

        return productService.getProducts(priceMin, priceMax, popularityMin);
    }
}