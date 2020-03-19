package com.example.snanny.NaniClasses;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.snanny.NaniClasses.FoodDetailsModel;
import com.example.snanny.R;

public class GetItemDetails extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.get_items_details,container,false);
        //GETTING THE DATA FROM THE BUNDLE
        String val = getArguments().getString("test");
        Toast.makeText(getContext(), ""+ val, Toast.LENGTH_SHORT).show();
        //TESTING DATA AGAIN
        FoodDetailsModel fd =(FoodDetailsModel) getArguments().getSerializable("Testing2");
        Toast.makeText(getContext(), ""+fd.foodName, Toast.LENGTH_SHORT).show();

        return v;
    }
}
