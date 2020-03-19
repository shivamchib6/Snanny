package com.example.snanny.NaniClasses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.snanny.R;

public class BankDetails extends AppCompatActivity implements View.OnClickListener {
    Button nextpageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_details);

        //GETTING ALL THE IDS OF THE VIEWS
        findids();
        //ADDING ONCLICKlISTENER ON THE VIEW
        nextpageButton.setOnClickListener(this);
    }

    private void findids() {
        nextpageButton = findViewById(R.id.nextstepbutton);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){

            case R.id.nextstepbutton :
                Toast.makeText(this, "Next Page", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), OTPActivity.class));

        }
    }
}
