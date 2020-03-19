package com.example.snanny.UserClasses;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.snanny.NaniClasses.MainActivity;
import com.example.snanny.NaniClasses.NaniHome;
import com.example.snanny.R;
import com.example.snanny.SharedPrefManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class UserHome extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    BottomNavigationView bottomNavigationView;
    TextView textViewTitle;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_user_home);
        //SETTING THE TITLE TO THE CENTER OF ACTIONBAR
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar_title);
        textViewTitle = getSupportActionBar().getCustomView().findViewById(R.id.title_action_bar);
        textViewTitle.setText("Home");

        //Getting the shared pref data here
        SharedPrefManager sharedPrefManager = SharedPrefManager.getmInstance(getApplicationContext());
        String getName = sharedPrefManager.getUser().getName();
        String getEmail = sharedPrefManager.getUser().getEmail();
        findID();


        //SHOW THE ACTIONBARDRAWABLETOGGLE IN THE ACTIONBAR
        showDrawableToggle();
        //ADD TOOGLE
        AddToggle();
        //ADDING ONCLICK LISTENER ON THE BOTTOMNAVIGATIONVIEW
        bottomNavigationView.setOnNavigationItemSelectedListener(this);


        drawerLayout = findViewById(R.id.drawerlayouttoogle);
        navigationView = findViewById(R.id.navigation_view_user);
        navigationView.setNavigationItemSelectedListener(this);
        //ADD IMAGE AND NAME TO USER
        View navigationHeader = navigationView.getHeaderView(0);
        TextView textViewname = (TextView) navigationHeader.findViewById(R.id.textviewnameofuser);
        textViewname.setText(getName);
        TextView textViewEmail = (TextView) navigationHeader.findViewById(R.id.textviewemailofuser);
        textViewname.setText(getEmail);

        //OPEN HOMEFRAGMENT BY DEFAULT
        User_Home_Fragment us = new User_Home_Fragment();
        openfragment(us);
    }

    private void showDrawableToggle() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.RED));
        getSupportActionBar().setTitle("Home");
    }

    private void AddToggle() {

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }

    private void findID() {
        drawerLayout = findViewById(R.id.drawerlayouttoogle);
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openfragment(Fragment f){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.userframelayout,f);
        ft.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id){
            case R.id.home:
                textViewTitle.setText("Home");
                User_Home_Fragment us = new User_Home_Fragment();
                openfragment(us);
                return true;
            case R.id.discover:
                textViewTitle.setText("Discover");
                User_Discover ud = new User_Discover();
                openfragment(ud);
                return true;
            case R.id.profile:
                textViewTitle.setText("Profile");
                User_Profile up = new User_Profile();
                openfragment(up);
                return true;
            case R.id.settings:
                textViewTitle.setText("Settings");
                User_Settings us1 = new User_Settings();
                openfragment(us1);
                return true;
            case R.id.userone:
                User_Home_Fragment us2 = new User_Home_Fragment();
                openfragment(us2);
                drawerLayout.closeDrawer(Gravity.LEFT);
                return true;
            case R.id.usertwo:
                Toast.makeText(getApplicationContext(), "Two", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.userthree:
                Toast.makeText(getApplicationContext(), "Three", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.userfour:
                startActivity(new Intent(UserHome.this, NaniHome.class));
                drawerLayout.closeDrawer(Gravity.LEFT);
                return true;
           }
        return false;
    }
}
