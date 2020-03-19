package com.example.snanny.UserClasses;

public class ItemsList {

    int image;
    String username;
    Float rating;
    int imageofFood;
    String nameofDish;
    String description;
    String price;

    public ItemsList(int image, String username, Float rating, int imageofFood, String nameofDish, String description, String price) {
        this.image = image;
        this.username = username;
        this.rating = rating;
        this.imageofFood = imageofFood;
        this.nameofDish = nameofDish;
        this.description = description;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public int getImageofFood() {
        return imageofFood;
    }

    public void setImageofFood(int imageofFood) {
        this.imageofFood = imageofFood;
    }

    public String getNameofDish() {
        return nameofDish;
    }

    public void setNameofDish(String nameofDish) {
        this.nameofDish = nameofDish;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
