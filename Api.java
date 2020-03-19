package com.example.snanny;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("checkPhoneNumberAndEmail")
    Call<OTPModel> checkEmail(
        @Field("phoneNumber")String phoneNumber,
        @Field("email")String email
        );
    @FormUrlEncoded
    @POST("userRegister")
    Call<RegisterUserModel> userRegister(
            @Field("name")String name,
            @Field("phone")String phone,
            @Field("email")String email,
            @Field("password")String password,
            @Field("reg_id")String reg_id,
            @Field("device_type")String device_type
            );
    @FormUrlEncoded
    @POST("userLogin")
    Call<ResponseBody> userLogin(
            @Field("email")String email,
            @Field("password")String password,
            @Field("reg_id")String reg_id,
            @Field("device_type")String device_type
    );
}
