package com.example.snanny.UserClasses;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.snanny.NaniClasses.NaniLogin;
import com.example.snanny.NaniClasses.NaniOrBuyerActivity;
import com.example.snanny.R;

import java.util.ArrayList;
import java.util.List;

public class User_Profile extends Fragment implements NaniListAdapter.onNaniPersonClicked, View.OnClickListener {
    RecyclerView recyclerViewNaniList;
    List<NaniList> list1;
    TextView textVieweditProfile;
    Button logoutButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.user_profile,container,false);

        findIds(v);
        addPersonInList();
        //UNDERLINING THE TEXTVIEW
        textVieweditProfile.getPaint().setUnderlineText(true);

        //SET THE LAYOUT MANAGER FOR SUBSCRIPTIONS
        recyclerViewNaniList.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        NaniListAdapter np = new NaniListAdapter(getContext(),list1,this);
        recyclerViewNaniList.setAdapter(np);

        textVieweditProfile.setOnClickListener(this);
        logoutButton.setOnClickListener(this);

        return v;
    }

    private void findIds(View v) {

        textVieweditProfile = v.findViewById(R.id.usereditprofiletext);
        recyclerViewNaniList = v.findViewById(R.id.recycler_view_nani_list);
        logoutButton = v.findViewById(R.id.logoutbutton);

    }


    private void addPersonInList() {
        list1 = new ArrayList<>();
        list1.add(new NaniList(R.drawable.ic_person_red_24dp,"Shivam"));
        list1.add(new NaniList(R.drawable.ic_person_red_24dp,"Shivam Thakur 18"));
        list1.add(new NaniList(R.drawable.ic_person_red_24dp,"Shivam"));
        list1.add(new NaniList(R.drawable.ic_person_red_24dp,"Shivam"));
        list1.add(new NaniList(R.drawable.ic_person_red_24dp,"Shivam"));
        list1.add(new NaniList(R.drawable.ic_person_red_24dp,"Shivam Thakur Shivam"));
    }

    @Override
    public void personClicked(int position) {
        Toast.makeText(getContext(), ""+position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id){
            case R.id.usereditprofiletext:

                User_EditProfile us = new User_EditProfile();
                openfragment(us);

                break;
            case R.id.logoutbutton:
                startActivity(new Intent(getContext(), NaniOrBuyerActivity.class));
                break;

        }

    }
    public void openfragment(Fragment f){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.userframelayout,f);
        ft.commit();
    }
}
