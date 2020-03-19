package com.example.snanny.NaniClasses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.snanny.NaniClasses.NaniHome;
import com.example.snanny.R;
import com.example.snanny.RegisterUserModel;
import com.example.snanny.RetrofitClient;
import com.example.snanny.SharedPrefManager;
import com.example.snanny.UserClasses.UserHome;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OTPActivity extends AppCompatActivity implements View.OnClickListener {
    //VARIABLES OF THE CLASS
    Button verifyOTP;
    String otptext;
    String reg_id;
    EditText one,two,three,four,five,six;
    String finalName,finalPhoneNumber,email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nani_specialities);
        verifyOTP = findViewById(R.id.veriyotpbutton);
        verifyOTP.setOnClickListener(this);
        findIds();
        setLayout();
        reg_id = getIntent().getStringExtra("reg_id");
        Toast.makeText(this, "Otp is "+otptext, Toast.LENGTH_SHORT).show();
        SharedPreferences sp = getSharedPreferences("shivam", Context.MODE_PRIVATE);
        otptext = sp.getString("otp",null);
        finalName = sp.getString("name",null);
        finalPhoneNumber = sp.getString("phonenumber",null);
        email = sp.getString("email",null);
        password = sp.getString("password",null);
        reg_id = sp.getString("reg_id",null);


        }

    private void setLayout() {
        one.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (one.getText().length() == 1){
                    one.setFocusable(false);
                    two.setFocusable(true);
                    two.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        two.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (two.getText().length() == 1){
                    three.setFocusable(true);
                    three.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        three.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (three.getText().length() == 1){
                    four.setFocusable(true);
                    four.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        four.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (four.getText().length() == 1){
                    five.setFocusable(true);
                    five.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        five.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (five.getText().length() == 1){
                    six.setFocusable(true);
                    six.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });









    }

    @Override
    public void onClick(View view) {


        int id = view.getId();
        switch (id){
            case R.id.veriyotpbutton:

                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(one.getText().toString());
                stringBuffer.append(two.getText().toString());
                stringBuffer.append(three.getText().toString());
                stringBuffer.append(four.getText().toString());
                stringBuffer.append(five.getText().toString());
                stringBuffer.append(six.getText().toString());
                if (stringBuffer.toString().length() != 6){
                    Toast.makeText(this, "Enter otp properly "+stringBuffer.toString().length(), Toast.LENGTH_SHORT).show();
                    return;

                }
                if (stringBuffer.toString().equals(otptext)){
                    Toast.makeText(this, "OTP registration successfully ", Toast.LENGTH_SHORT).show();

                    Call<RegisterUserModel> registerUser = RetrofitClient.getmInstance().getApi().userRegister(finalName,finalPhoneNumber,email,password,reg_id,"Android");
                    registerUser.enqueue(new Callback<RegisterUserModel>() {
                        @Override
                        public void onResponse(Call<RegisterUserModel> call, Response<RegisterUserModel> response) {

//                            SharedPreferences sp= getSharedPreferences("userregister",Context.MODE_PRIVATE);
//                            SharedPreferences.Editor editor = sp.edit();
//                         //   editor.putStringSet("userregister",response.body().getDetails());
                            SharedPrefManager.getmInstance(getApplicationContext()).saveUser(response.body().getDetails());
                            if (Integer.parseInt(reg_id) == 1 ){
                                startActivity(new Intent(getApplicationContext(), NaniHome.class));

                            }else if (Integer.parseInt(reg_id) == 2){
                                Intent intent = new Intent(getApplicationContext(),UserHome.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);

                            }

                        }

                        @Override
                        public void onFailure(Call<RegisterUserModel> call, Throwable t) {

                        }
                    });


                }else {
                    Toast.makeText(this, "NGU", Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, "Enter otp properly "+stringBuffer.toString().length(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, "Otp is "+ otptext, Toast.LENGTH_SHORT).show();

                }


        }
    }

    private void findIds() {
        one = findViewById(R.id.edittextone);
        two = findViewById(R.id.edittexttwo);
        three = findViewById(R.id.edittextthree);
        four = findViewById(R.id.edittextfour);
        five = findViewById(R.id.edittextfive);
        six = findViewById(R.id.edittextsix);
    }



}
