package com.example.wow1;

public class ProductUpload {
    String selectedImage,description;

    public ProductUpload() {
    }

    public ProductUpload(String selectedImage, String description) {
        this.selectedImage = selectedImage;
        this.description = description;
    }

    public String getSelectedImage() {
        return selectedImage;
    }

    public void setSelectedImage(String selectedImage) {
        this.selectedImage = selectedImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
