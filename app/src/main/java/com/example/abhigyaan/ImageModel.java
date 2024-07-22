package com.example.abhigyaan;

public class ImageModel {
    private String imageUrl;

    // Default constructor required for Firebase
    public ImageModel() {
        // No-argument constructor
    }

    // Parameterized constructor for creating new instances
    public ImageModel(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // Getter for imageUrl
    public String getImageUrl() {
        return imageUrl;
    }

    // Setter for imageUrl
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
