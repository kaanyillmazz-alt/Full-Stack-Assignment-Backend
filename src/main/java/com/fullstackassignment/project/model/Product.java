package com.fullstackassignment.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String name;
    private int popularityScore;
    private double weight;
    private Map<Color, String> images;
}