package com.example.snanny.NaniClasses;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import com.example.snanny.R;

import java.util.ArrayList;

public class SlidingPagerAdapter extends PagerAdapter {
    //VARIABLES OF THE ADAPTER
    private int[] images;
    private String[] headingtext;
    private String[] descriptiontext;
    LayoutInflater inflater;
    Context context;
    //CONSTRUCTOR OF THE ADAPTER
    public SlidingPagerAdapter(int[] images, Context context, String[] textheading,String[] descrptionheading) {
        this.images = images;
        this.context = context;
        this.headingtext = textheading;
        this.descriptiontext = descrptionheading;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {
       //RETURN THE COUNT OF IMAGES
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {


        return view.equals(object);
    }

    @Override
    public void restoreState(@Nullable Parcelable state, @Nullable ClassLoader loader) {
        super.restoreState(state,loader);
    }

    @Nullable
    @Override
    public Parcelable saveState() {
        return null;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //TO ADD DIFFERENT VIEWS IN THE FILE
        View v = inflater.inflate(R.layout.sliding_images,container,false);
        // ADD IMAGEVIEW BY FINDING ITS ID
        ImageView imageView = v.findViewById(R.id.slidingimage);
        //SET IMAGE TO  THE IMAGE IN THE ARRAY
        imageView.setImageResource(images[position]);
        // FINDING THE TEXTVIEW IN THE CONTAINER
        TextView textViewheadiing = v.findViewById(R.id.textviewheading);
        //ADD THE TEXT TO THE TEXTVIEW IN THE HEADER
        textViewheadiing.setText(headingtext[position]);
        // ADD THE TEXTVIEW FOR THE DESCRIPTION OF THE NANNY
        TextView viewdescription = v.findViewById(R.id.textviewdescription);
        //ADD THE TEXT TO THE DESCRIPTION TEXTVIEW
        viewdescription = v.findViewById(R.id.textviewdescription);
        viewdescription.setText(descriptiontext[position]);

        //ADD THE WHOLE VIEW TO THE CONTAINER
        container.addView(v);

        return v;
    }
}
