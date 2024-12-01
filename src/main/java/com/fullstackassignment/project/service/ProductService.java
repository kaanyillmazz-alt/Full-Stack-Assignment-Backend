package com.fullstackassignment.project.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fullstackassignment.project.dto.ProductDTO;
import com.fullstackassignment.project.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ObjectMapper objectMapper;
    private final CurrencyService currencyService;

    @Value("${json.import.filename}")
    private String jsonImportFilename;


    public List<ProductDTO> getProducts(BigDecimal priceMin, BigDecimal priceMax, Double popularityMin) throws IOException {
        List<Product> productList = getProductsFromJson();

        return productList.stream()
                .map(this::convertToProductDTO)
                .filter(productDTO -> filterByPrice(productDTO, priceMin, priceMax))
                .filter(productDTO -> filterByPopularityScore(productDTO, popularityMin))
                .toList();
    }


    private boolean filterByPrice(ProductDTO productDTO, BigDecimal priceMin, BigDecimal priceMax) {
        BigDecimal price = productDTO.getPrice();
        boolean priceInRange = true;

        if (priceMin != null) {
            priceInRange = price.compareTo(priceMin) >= 0;
        }

        if (priceMax != null && priceInRange) {
            priceInRange = price.compareTo(priceMax) <= 0;
        }

        return priceInRange;
    }

    private boolean filterByPopularityScore(ProductDTO productDTO, Double popularityMin) {
        boolean popularityInRange = true;
        if (popularityMin != null) {
            popularityInRange = productDTO.getPopularityScore() >= popularityMin;
        }
        return popularityInRange;
    }


    private ProductDTO convertToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setWeight(product.getWeight());
        productDTO.setImages(product.getImages());
        productDTO.setPopularityScore(product.getPopularityScore());
        productDTO.setPrice(calculateProductPrice(product));

        return productDTO;
    }


    private BigDecimal calculateProductPrice(Product product) {
        BigDecimal goldPrice = currencyService.getGoldPrice();
        BigDecimal goldPriceGrams = goldPrice.multiply(BigDecimal.valueOf(1 / 31.1034768));
        BigDecimal productWeight = BigDecimal.valueOf(product.getWeight());
        double popularityScore = product.getPopularityScore();
        popularityScore =((popularityScore/100) + 1);
        BigDecimal productPrice = goldPriceGrams.multiply(productWeight).multiply(BigDecimal.valueOf(popularityScore));

        return productPrice.setScale(2, RoundingMode.HALF_UP);

    }


    private List<Product> getProductsFromJson() throws IOException {
        Resource resource = new ClassPathResource(jsonImportFilename);

        return objectMapper.readValue(resource.getInputStream(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
    }

}