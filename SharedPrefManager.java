package com.example.snanny;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {

    public static final String SHARED_PREF_NAME = "my_shared_pref";

    private static SharedPrefManager mInstance;
    private Context mctx;

    public SharedPrefManager(Context context){
        mctx = context;
    }

    public static synchronized SharedPrefManager getmInstance(Context c) {
        if (mInstance == null){
            mInstance = new SharedPrefManager(c);
        }
        return mInstance;
    }

    public RegisterUserModel.Details getUser(){

        SharedPreferences sharedPreferences = mctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        RegisterUserModel.Details details = new RegisterUserModel.Details(
                sharedPreferences.getString("id",null),
                sharedPreferences.getString("name",null),
                sharedPreferences.getString("phone",null),
                sharedPreferences.getString("email",null),
                sharedPreferences.getString("password",null),
                sharedPreferences.getString("social_id",null),
                sharedPreferences.getString("image",null),
                sharedPreferences.getString("martial_status",null),
                sharedPreferences.getString("profession",null),
                sharedPreferences.getString("father_name",null),
                sharedPreferences.getString("mother_name",null),
                sharedPreferences.getString("reg_id",null),
                sharedPreferences.getString("device_type",null),
                sharedPreferences.getString("login_type",null),
                sharedPreferences.getString("created",null),
                sharedPreferences.getString("updated",null)
                );
        return details;
    }


    public void saveUser(RegisterUserModel.Details details){

        SharedPreferences sharedPreferences = mctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //editor.putInt("type",user.getId());
        editor.putString("id",details.getId());
        editor.putString("name",details.getName());
        editor.putString("email",details.getEmail());
        editor.putString("phone",details.getPhone());
        editor.putString("password",details.getPassword());
        editor.putString("image",details.getImage());
        editor.putString("reg_id",details.getRegId());
        editor.apply();
    }

//    public RegisterUserModel.Details getUser(){
//
//
//    }



}
