package com.example.snanny.NaniClasses;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.snanny.NaniClasses.BankDetails;
import com.example.snanny.OTPModel;
import com.example.snanny.R;
import com.example.snanny.RegisterUserModel;
import com.example.snanny.RetrofitClient;

import java.util.regex.Matcher;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    Button nextpageButton;
    String reg_id ;
    EditText editTextfullname;
    EditText editTextemail;
    EditText phoneedittext;
    EditText passwordedittext;
    EditText connfirmpasswordedittext;
    boolean check = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        reg_id = getIntent().getStringExtra("reg_id");
        Toast.makeText(this, "reg_id is "+ reg_id, Toast.LENGTH_SHORT).show();
        findids();
        //SETTING ON CLICK LISTENER 
        nextpageButton.setOnClickListener(this);
    }

    private void findids() {
        nextpageButton = findViewById(R.id.signupgetdetailsbutton);
        editTextfullname = findViewById(R.id.nameofperson);
        editTextemail = findViewById(R.id.emailedittext);
        phoneedittext = findViewById(R.id.phonenumberedittext);
        passwordedittext = findViewById(R.id.passwordedittext);
        connfirmpasswordedittext  = findViewById(R.id.confirmpasswordedittext);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.signupgetdetailsbutton:
                Toast.makeText(this, "Next Step", Toast.LENGTH_SHORT).show();
                final String finalName = editTextfullname.getText().toString().trim();
                if (finalName.length()<6){
                    editTextfullname.setError("Name is too short(Min 6 letters)");
                    check = false;
                }
                final String finalEmail = editTextemail.getText().toString().trim();
                if (finalEmail.isEmpty()){
                    editTextemail.setError("Email is too short");
                    check = false;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(finalEmail).matches()){
                    editTextemail.setError("Email is not matching");
                    check = false;
                }
                final String phoneNumber = phoneedittext.getText().toString().trim();

//                    if (!(phoneNumber.length() == 10)){
//                        phoneedittext.setError("Phone number length must be 10 digits exact");
//                        check = false;
//                    }

                final String finalPassword = passwordedittext.getText().toString().trim();
                if (finalPassword.length()<6){
                    passwordedittext.setError("Password is too short");
                    check = false;
                }
                String confirmPassword = connfirmpasswordedittext.getText().toString().trim();
                if (confirmPassword.length()<6){
                    connfirmpasswordedittext.setError("Password is too short");
                    check = false;
                }
                if (!confirmPassword.equals(finalPassword)){
                    connfirmpasswordedittext.setError("Password and confirm Password  does not match.");
                    check = false;
                }
                if (check == false){
                    Log.d("check","In checker");
                    return;
                }

                if (Integer.parseInt(reg_id)== 1){
                    Log.d("one","In one");
                    Call<OTPModel> call1  = RetrofitClient.getmInstance().getApi().checkEmail(finalEmail,phoneNumber);
                    call1.enqueue(new Callback<OTPModel>() {
                        @Override
                        public void onResponse(Call<OTPModel> call, Response<OTPModel> response) {
                            Toast.makeText(SignUpActivity.this, "Api hitted.", Toast.LENGTH_SHORT).show();

                            Intent i = new Intent(getApplicationContext(),OTPActivity.class);
                            PendingIntent pi = PendingIntent.getActivity(getApplicationContext(),0,i,0);
                            SmsManager smsManager =  SmsManager.getDefault();
                            smsManager.sendTextMessage(phoneNumber+"",null,"Secret OTP is "+ response.body().getOtp(),pi,null);
                            i.putExtra("otp",response.body().getOtp());
                            i.putExtra("reg_id",reg_id);
                        }

                        @Override
                        public void onFailure(Call<OTPModel> call, Throwable t) {
                            Toast.makeText(SignUpActivity.this, "NGU", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
                else if (Integer.parseInt(reg_id)== 2){
                    Log.d("two","In two");
                    Log.d("called","called");
                    Call<OTPModel> call1  = RetrofitClient.getmInstance().getApi().checkEmail(finalEmail,phoneNumber);
                    call1.enqueue(new Callback<OTPModel>() {
                        @Override
                        public void onResponse(Call<OTPModel> call, Response<OTPModel> response) {
                            Toast.makeText(SignUpActivity.this, "Api hitted.", Toast.LENGTH_SHORT).show();
                            Intent i2 = new Intent(getApplicationContext(),OTPActivity.class);
                            PendingIntent pi2 = PendingIntent.getActivity(getApplicationContext(),0,i2,0);
                           // pi2.putExtra("otp",response.body().getOtp());
                           // i2.putExtra("reg_id",reg_id);
                            SharedPreferences sp = getSharedPreferences("shivam", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sp.edit();
                            editor.putString("otp",response.body().getOtp());
                            editor.putString("name",finalName);
                            editor.putString("phonenumber",phoneNumber);
                            editor.putString("email",finalEmail);
                            editor.putString("password",finalPassword);
                            editor.putString("reg_id",reg_id);
                            editor.commit();

                            SmsManager smsManager =  SmsManager.getDefault();
                            smsManager.sendTextMessage(phoneNumber+"",null,"Secret OTP is "+ response.body().getOtp(),pi2,null);

                            //Making the register call of the user



                        }
                        @Override
                        public void onFailure(Call<OTPModel> call, Throwable t) {
                            Toast.makeText(SignUpActivity.this, "NGU", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
        }
    }
}
