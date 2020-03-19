package com.example.snanny.NaniClasses;

class NotificationPerson {
    int image;
    String comments;
    String timeofComments;

    public NotificationPerson(int image, String comments, String timeofComments) {
        this.image = image;
        this.comments = comments;
        this.timeofComments = timeofComments;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getTimeofComments() {
        return timeofComments;
    }

    public void setTimeofComments(String timeofComments) {
        this.timeofComments = timeofComments;
    }
}
