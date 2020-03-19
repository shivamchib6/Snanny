package com.example.snanny.UserClasses;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.snanny.NaniClasses.ChangePasswordFragment;
import com.example.snanny.R;

public class User_EditProfile extends Fragment implements View.OnClickListener {
    LinearLayout chnagePassword;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.user_editprofile,container,false);
        chnagePassword = v.findViewById(R.id.linearlayoutchangepassword);
        chnagePassword.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id){

            case R.id.linearlayoutchangepassword:

                UserChangePasswordFragment ch = new UserChangePasswordFragment();
                openfragment(ch);
                break;



        }

    }
    public void openfragment(Fragment f){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.userframelayout,f);
        ft.commit();
    }
}
