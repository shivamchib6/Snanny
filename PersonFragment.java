package com.example.snanny.NaniClasses;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.snanny.R;

import java.util.ArrayList;
import java.util.List;

public class PersonFragment extends Fragment implements View.OnClickListener {
    //VARIABLES OF THE CLASS
    TextView editProfiletextview;
    RecyclerView recyclerVieworderHisoty;
    List<FoodDetailsModel> personListWithFood;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.person_fragment,container,false);
        editProfiletextview = v.findViewById(R.id.editprofiletext);
        editProfiletextview.getPaint().setUnderlineText(true);
        addPerson();
        //FINDING ID OF THE RECYLERVIEW AND THEN ADDDING ADAPTER TO IT
        HorizontalPersonOrderAdapter hp = new HorizontalPersonOrderAdapter(getContext(),personListWithFood);
        recyclerVieworderHisoty = v.findViewById(R.id.recyelerviewprofile);
        recyclerVieworderHisoty.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recyclerVieworderHisoty.setAdapter(hp);
        //HANDING ONCLICK ON EDITPROFILE
        editProfiletextview.setOnClickListener(this);
        return v;
    }
    private void addPerson() {
        personListWithFood = new ArrayList<>();
        personListWithFood.add(new FoodDetailsModel(R.drawable.food1,"Shivam","Amritsar",2,R.drawable.food1,"Donuts",
                "Nice..food","Today","Payment : Cash"));
        personListWithFood.add(new FoodDetailsModel(R.drawable.food1,"Shivam","Amritsar",2,R.drawable.food1,"Donuts",
                "Nice..food","Today","Payment : Cash"));

        Log.d("abcd",personListWithFood.get(0).comments);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.editprofiletext:
                ProfileSettings ps = new ProfileSettings();
                openFragment(ps);
            break;
        }
    }
    private void openFragment(Fragment hm) {
        FragmentTransaction fm = getFragmentManager().beginTransaction();
        fm.replace(R.id.framelayout1,hm);
        fm.commit();
    }

}
