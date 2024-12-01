package com.fullstackassignment.project.dto;

import com.fullstackassignment.project.model.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Map;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String name;
    private BigDecimal price;
    private double popularityScore;
    private double weight;
    private Map<Color, String> images;

}
