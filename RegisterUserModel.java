package com.example.snanny;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterUserModel {

    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("details")
    @Expose
    private Details details;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }
    public static class Details {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("phone")
        @Expose
        private String phone;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("password")
        @Expose
        private String password;
        @SerializedName("social_id")
        @Expose
        private String socialId;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("martial_status")
        @Expose
        private String martialStatus;
        @SerializedName("profession")
        @Expose
        private String profession;
        @SerializedName("father_name")
        @Expose
        private String fatherName;
        @SerializedName("mother_name")
        @Expose
        private String motherName;
        @SerializedName("reg_id")
        @Expose
        private String regId;
        @SerializedName("device_type")
        @Expose
        private String deviceType;
        @SerializedName("login_type")
        @Expose
        private String loginType;
        @SerializedName("created")
        @Expose
        private String created;
        @SerializedName("updated")
        @Expose
        private String updated;

        public Details(String id, String name, String phone, String email, String password, String socialId, String image, String martialStatus, String profession, String fatherName, String motherName, String regId, String deviceType, String loginType, String created, String updated) {
            this.id = id;
            this.name = name;
            this.phone = phone;
            this.email = email;
            this.password = password;
            this.socialId = socialId;
            this.image = image;
            this.martialStatus = martialStatus;
            this.profession = profession;
            this.fatherName = fatherName;
            this.motherName = motherName;
            this.regId = regId;
            this.deviceType = deviceType;
            this.loginType = loginType;
            this.created = created;
            this.updated = updated;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getSocialId() {
            return socialId;
        }

        public void setSocialId(String socialId) {
            this.socialId = socialId;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getMartialStatus() {
            return martialStatus;
        }

        public void setMartialStatus(String martialStatus) {
            this.martialStatus = martialStatus;
        }

        public String getProfession() {
            return profession;
        }

        public void setProfession(String profession) {
            this.profession = profession;
        }

        public String getFatherName() {
            return fatherName;
        }

        public void setFatherName(String fatherName) {
            this.fatherName = fatherName;
        }

        public String getMotherName() {
            return motherName;
        }

        public void setMotherName(String motherName) {
            this.motherName = motherName;
        }

        public String getRegId() {
            return regId;
        }

        public void setRegId(String regId) {
            this.regId = regId;
        }

        public String getDeviceType() {
            return deviceType;
        }

        public void setDeviceType(String deviceType) {
            this.deviceType = deviceType;
        }

        public String getLoginType() {
            return loginType;
        }

        public void setLoginType(String loginType) {
            this.loginType = loginType;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }

    }

}