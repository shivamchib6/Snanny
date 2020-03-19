package com.example.snanny.NaniClasses;

class MyOrderList {
    int personimage;
    String name;
    String Location;
    float stars;
    int foodimage;
    String foodName;
    String deliverydate;
    //CONSTRUCTOR CALLED IN THE CLASS


    public MyOrderList(int personimage, String name, String location, float stars, int foodimage, String foodName, String deliverydate) {
        this.personimage = personimage;
        this.name = name;
        Location = location;
        this.stars = stars;
        this.foodimage = foodimage;
        this.foodName = foodName;
        this.deliverydate = deliverydate;
    }

    public int getPersonimage() {
        return personimage;
    }

    public void setPersonimage(int personimage) {
        this.personimage = personimage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public float getStars() {
        return stars;
    }

    public void setStars(float stars) {
        this.stars = stars;
    }

    public int getFoodimage() {
        return foodimage;
    }

    public void setFoodimage(int foodimage) {
        this.foodimage = foodimage;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(String deliverydate) {
        this.deliverydate = deliverydate;
    }
}
