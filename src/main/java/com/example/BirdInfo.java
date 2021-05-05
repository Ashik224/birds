package com.example;

import java.io.InputStream;

public class BirdInfo {
    private String name;
    private String scientificName;
    private String category;
    private String region;
    private String description;
    private String realImage;

    public BirdInfo(String name, String scientificName, String category, String region, String description, String realImage) {
        this.name = name;
        this.scientificName = scientificName;
        this.category = category;
        this.region = region;
        this.description = description;
        this.realImage = realImage;
    }

    public BirdInfo() {

    }

    public String getName() {
        return name;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public String getCategory() {
        return category;
    }

    public String getRegion() {
        return region;
    }

    public String getDescription() {
        return description;
    }

    public String getRealImage() { return realImage; }
}
