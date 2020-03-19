package com.example.snanny.NaniClasses;

import android.widget.ImageView;

import java.io.Serializable;

public class FoodDetailsModel implements Serializable {
    //VARIABLE OF THE CLASS AND THE MODEL IN THE APP
    int personimage;
    String name;
    String Location;
    float stars;
    int foodimage;
    String foodName;
    String comments;
    String deliverydate;
    String deliveryTime;
    //CONSTRUCTOR CALLED IN THE CLASS
    public FoodDetailsModel(int personimage, String name, String location, float stars, int foodimage, String foodName, String comments, String deliverydate, String deliveryTime) {
        this.personimage = personimage;
        this.name = name;
        Location = location;
        this.stars = stars;
        this.foodimage = foodimage;
        this.foodName = foodName;
        this.comments = comments;
        this.deliverydate = deliverydate;
        this.deliveryTime = deliveryTime;
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

    public void setStars(int stars) {
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(String deliverydate) {
        this.deliverydate = deliverydate;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
}
