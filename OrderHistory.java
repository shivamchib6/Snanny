package com.example.snanny.NaniClasses;

class OrderHistory {
    int personimage;
    int orderimage;
    String personname;
    String foodname;
    float ratings;
    String location;
    String deliveryamount;
    String orderCompleted;

    public OrderHistory(int personimage, int orderimage, String personname, String foodname, float ratings, String location, String deliveryamount, String  orderCompleted) {
        this.personimage = personimage;
        this.orderimage = orderimage;
        this.personname = personname;
        this.foodname = foodname;
        this.ratings = ratings;
        this.location = location;
        this.deliveryamount = deliveryamount;
        this.orderCompleted = orderCompleted;
    }

    public int getPersonimage() {
        return personimage;
    }

    public void setPersonimage(int personimage) {
        this.personimage = personimage;
    }

    public int getOrderimage() {
        return orderimage;
    }

    public void setOrderimage(int orderimage) {
        this.orderimage = orderimage;
    }

    public String getPersonname() {
        return personname;
    }

    public void setPersonname(String personname) {
        this.personname = personname;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public float getRatings() {
        return ratings;
    }

    public void setRatings(float ratings) {
        this.ratings = ratings;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDeliveryamount() {
        return deliveryamount;
    }

    public void setDeliveryamount(String deliveryamount) {
        this.deliveryamount = deliveryamount;
    }

    public String getOrderCompleted() {
        return orderCompleted;
    }

    public void setOrderCompleted(String  orderCompleted) {
        this.orderCompleted = orderCompleted;
    }
}
