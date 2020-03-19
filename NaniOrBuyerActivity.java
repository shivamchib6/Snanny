package com.example.snanny.NaniClasses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.snanny.R;

public class NaniOrBuyerActivity extends AppCompatActivity implements View.OnClickListener {
    //VARIABLES OF THE CLASS
    ViewPager slidingImagesViewPager;
    LinearLayout layoutSliderDots;
    Button nanibutton,userButton;
    int dotsCount = 0;
    private ImageView[] dots ;
    //INPUT OF THE ADAPTER
    int[] images = {R.drawable.icon,R.drawable.food} ;
    String[] textheading = {"Become a Nanny or find your nearest Nanny","Pick up from store or get delivered to your door"};
    String[] descriptiontext = {"Come and get the best offers from the app and earn rewards","Come and get the best offers from the app and earn rewards"};

    //VARIABLES FOR THE API TO HIT
    String reg_id ;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nani_or_buyer);

        findID();
        //SET ADAPTER TO ViewPager
        SlidingPagerAdapter slidingPagerAdapter = new SlidingPagerAdapter(images,getApplicationContext(),textheading,descriptiontext);
        slidingImagesViewPager.setAdapter(slidingPagerAdapter);
        //ADDING TabLayout TO ViewPager
        //   tabLayout.setupWithViewPager(slidingImagesViewPager);
        dotsCount = slidingPagerAdapter.getCount();
        //ADD ImageView TO THE LinearLayout
        dots = new ImageView[dotsCount];

        //ADDING DOTS TO THE ViewPager AND CHANGElISTERNER
        addDots();
        onClickOnViewPager();
        // ADDING BUTTON CLICKS
        userButton.setOnClickListener(this);
        nanibutton.setOnClickListener(this);

    }

    private void onClickOnViewPager() {
        //ADD ON PAGE CHANGE LISTENER ON THE VIEWPAGER
        slidingImagesViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i = 0; i< dotsCount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.tab_indicator_default));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.tab_indicator_selected));



            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void addDots() {

        for (int i = 0;i< dotsCount;i++){
            //ADDING A NEW IMAGEVIEW FOR EVERY ELEMENT IN THE IAMGEVIEW
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.tab_indicator_default));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(15,0,15,0);
            layoutSliderDots.addView(dots[i],params);

            dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.tab_indicator_selected));

        }


    }

    private void findID() {
        slidingImagesViewPager = findViewById(R.id.viewpagershowimages);
        layoutSliderDots = findViewById(R.id.sliderdots);
        nanibutton = findViewById(R.id.nanibutton);
        userButton = findViewById(R.id.userbutton);
    }
    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.nanibutton:
                reg_id = "1";
                //Toast.makeText(this, "Nani button clicked", Toast.LENGTH_SHORT).show();
                nanibutton.setBackground(getDrawable(R.drawable.button_clicked));
                nanibutton.setTextColor(Color.WHITE);
                userButton.setBackground(getDrawable(R.drawable.button_background));
                userButton.setTextColor(Color.RED);
                Intent i = new Intent(getApplicationContext(),NaniLogin.class);
                i.putExtra("reg_id",reg_id);
                startActivity(i);

                break;
            case R.id.userbutton:
                reg_id = "2";
                //Toast.makeText(this, "User button clicked", Toast.LENGTH_SHORT).show();
                userButton.setBackground(getDrawable(R.drawable.button_clicked));
                userButton.setTextColor(Color.WHITE);
                nanibutton.setBackground(getDrawable(R.drawable.button_background));
                nanibutton.setTextColor(Color.RED);
                Intent i1 = new Intent(getApplicationContext(),NaniLogin.class);
                i1.putExtra("reg_id",reg_id);
                startActivity(i1);

                break;


        }


    }
}
