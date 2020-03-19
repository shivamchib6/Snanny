package com.example.snanny.NaniClasses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.snanny.R;
import com.example.snanny.RetrofitClient;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NaniLogin extends AppCompatActivity implements View.OnClickListener {
    //VARIABLES OF THE CLASS
    EditText emailedittext,passwordedittext;
    TextView textViewregister;
    String reg_id;
    Button loginButton;
    boolean check = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nani_login);
        //GET THE INTENT HERE
        reg_id = getIntent().getStringExtra("reg_id");
        Toast.makeText(this, "reg_id is "+ reg_id, Toast.LENGTH_SHORT).show();
        //FIND THE ID'S OF THE VIEWS
        findids();
        //UNDERLINE THE SIGNUP TEXTVIEW
        textViewregister.getPaint().setUnderlineText(true);
        textViewregister.setOnClickListener(this);
        loginButton.setOnClickListener(this);
    }

    private void findids() {

        textViewregister = findViewById(R.id.signuptextview2);
        loginButton = findViewById(R.id.loginbutton);
        emailedittext = findViewById(R.id.emailedittext);
        passwordedittext = findViewById(R.id.passwordloginedittext);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){

            case R.id.signuptextview2:
                //THIS TEXTVIEW WILL REGISTER NEW USERS INTO THE APP.

                Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();

                if (Integer.parseInt(reg_id) == 1){
                    Intent i = new Intent(getApplicationContext(),SignUpActivity.class);
                    i.putExtra("reg_id",reg_id);
                    startActivity(i);
                }else if (Integer.parseInt(reg_id) == 2){
                    Intent i1 = new Intent(getApplicationContext(),SignUpActivity.class);
                    i1.putExtra("reg_id",reg_id);
                    startActivity(i1);
                }
                break;
            case R.id.loginbutton:
                String finalEmail = emailedittext.getText().toString().trim();
                if (finalEmail.isEmpty()){
                    emailedittext.setError("Email is too short");
                    check = false;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(finalEmail).matches()){
                    emailedittext.setError("Email is not entered properly");
                    check = false;
                }
                final String finalPassword = passwordedittext.getText().toString().trim();
                if (finalPassword.length()<6){
                    passwordedittext.setError("Password is too short");
                    check = false;
                }
                //Call<>
                //check the reg_id parameter in the Login to dod the correct signup and Login


                Call<ResponseBody>  call = RetrofitClient.getmInstance().getApi().userLogin(finalEmail,finalPassword,reg_id,"Android");
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        //we will get the response here in the


                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });



                break;


        }
    }
}
