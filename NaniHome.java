package com.example.snanny.NaniClasses;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.snanny.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NaniHome extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    //VARIABLES OF THE CLASS
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nani_home);
        //FINDING THE IDS
        findids();
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        //MAKING THE FIRST LAYOUT COME AUTOMATICALLY WITHOUT THE CLICKING OF ANY BUTTON
        HomeFragment hm = new HomeFragment();
        openFragment(hm);

    }

    private void findids() {
        bottomNavigationView = findViewById(R.id.bottomnavigation);
    }
    //FOR THE SELECTION OF DIFFERENT ITEMS IN THE BAR
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id){
            case R.id.first :
                Toast.makeText(this, "One", Toast.LENGTH_SHORT).show();
                HomeFragment hm = new HomeFragment();
                openFragment(hm);
                return true;
            case R.id.second :
                Toast.makeText(this, "Second", Toast.LENGTH_SHORT).show();
                SearchFragment sf1 = new SearchFragment();
                openFragment(sf1);
                return true;
            case R.id.third :
                Toast.makeText(this, "Third", Toast.LENGTH_SHORT).show();
                PersonFragment pf = new PersonFragment();
                openFragment(pf);

                return true;
            case R.id.fourth :
                Toast.makeText(this, "Fourth", Toast.LENGTH_SHORT).show();
                SettingsFragment sf = new SettingsFragment();
                openFragment(sf);
                return true;
            case R.id.addfood :
                Toast.makeText(this, "Food is clicked", Toast.LENGTH_SHORT).show();
                AddFood ad = new AddFood();
                openFragment(ad);
                return true;

        }
        return false;
    }

    private void openFragment(Fragment hm) {
        FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
        fm.replace(R.id.framelayout1,hm);
        fm.commit();
    }
}
