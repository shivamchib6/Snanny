package com.example.snanny.NaniClasses;

class PaymentDetails {
    int image;
    String name;
    String location;
    String amount;

    public PaymentDetails(int image, String name, String location, String amount) {
        this.image = image;
        this.name = name;
        this.location = location;
        this.amount = amount;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
