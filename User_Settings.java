package com.example.snanny.UserClasses;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.snanny.R;

public class User_Settings extends Fragment  {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.user_settings,container,false);


        return v;
    }


    private void openFragment(Fragment hm) {
        FragmentTransaction fm = getFragmentManager().beginTransaction();
        fm.replace(R.id.framelayout1,hm);
        fm.commit();
    }
}
