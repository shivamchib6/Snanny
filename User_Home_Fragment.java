package com.example.snanny.UserClasses;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.snanny.R;

import java.util.ArrayList;
import java.util.List;

public class User_Home_Fragment extends Fragment implements NaniListAdapter.onNaniPersonClicked, ItemsAdapter.FoodItemClicked {
    RecyclerView recyclerViewNaniList;
    List<NaniList> list1;
    RecyclerView recyclerViewItems;
    List<ItemsList> itemsList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.user_home_fragment,container,false);
        findIds(v);
        addPersonInList();
        //SETTING ADAPTER AND LAYOUT MANAGER TO THE RECYCLERVIEW
        recyclerViewNaniList.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        NaniListAdapter np = new NaniListAdapter(getContext(),list1,this);
        recyclerViewNaniList.setAdapter(np);
        fillItemList();
        //SETTING THE ITEMS RECYLERVIEW AND ADAPTER
        recyclerViewItems.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        ItemsAdapter id = new ItemsAdapter(getContext(),itemsList,this);
        recyclerViewItems.setAdapter(id);

        return v;

    }

    private void fillItemList() {
        itemsList = new ArrayList<>();
        itemsList.add(new ItemsList(R.drawable.food1,"Shivam",3.0f,R.drawable.food1,"Donuts","Spicy Donuts","Rs 100"));
        itemsList.add(new ItemsList(R.drawable.food1,"Shivam",3.0f,R.drawable.food1,"Donuts","Spicy Donuts","Rs 100"));
        itemsList.add(new ItemsList(R.drawable.food1,"Shivam",3.0f,R.drawable.food1,"Donuts","Spicy Donuts","Rs 100"));
        itemsList.add(new ItemsList(R.drawable.food1,"Shivam",3.0f,R.drawable.food1,"Donuts","Spicy Donuts","Rs 100"));
        itemsList.add(new ItemsList(R.drawable.food1,"Shivam",3.0f,R.drawable.food1,"Donuts","Spicy Donuts","Rs 100"));
        itemsList.add(new ItemsList(R.drawable.food1,"Shivam",3.0f,R.drawable.food1,"Donuts","Spicy Donuts","Rs 100"));


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

    private void findIds(View v) {
        recyclerViewNaniList = v.findViewById(R.id.recycler_view_nani_list);
        recyclerViewItems = v.findViewById(R.id.recycler_view_item_list);
    }

    @Override
    public void personClicked(int position) {
        Toast.makeText(getContext(), "Position is "+ position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void DoAction(int position) {
        User_Item_Explore us = new User_Item_Explore();
        openfragment(us);
    }
    public void openfragment(Fragment f){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.userframelayout,f);
        ft.commit();
    }
}
