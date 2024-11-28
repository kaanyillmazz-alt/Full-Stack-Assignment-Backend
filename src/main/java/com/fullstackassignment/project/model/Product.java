package com.fullstackassignment.project.model;

import java.util.List;

public class Product {
    private int id;
    private String name;
    private double popularityScore;
    private double weight;
    private List<String> images;


    public Product(int id, String name, double popularityScore, double weight, List<String> images) {
        super();
        this.id = id;
        this.name = name;
        this.popularityScore = popularityScore;
        this.weight = weight;
        this.images = images;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPopularityScore() {
        return popularityScore;
    }
    public void setPopularityScore(double popularityScore) {
        this.popularityScore = popularityScore;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public List<String> getImages() {
        return images;
    }
    public void setImages(List<String> images) {
        this.images = images;
    }

}
