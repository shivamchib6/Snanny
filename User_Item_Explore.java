package com.example.snanny.UserClasses;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.snanny.R;

public class User_Item_Explore extends Fragment implements View.OnClickListener {
    Button chooseAddressButton;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.user_item_explore,container,false);

        findIds(v);

        chooseAddressButton.setOnClickListener(this);

        return v;
    }

    private void findIds(View v) {
        chooseAddressButton = v.findViewById(R.id.chooseaddressbutton);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){

            case R.id.chooseaddressbutton:
                Intent i = new Intent(getContext(),UserLocation.class);
                startActivity(i);

                break;



        }
    }
    public void openfragment(Fragment f){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.userframelayout,f);
        ft.commit();
    }
}
