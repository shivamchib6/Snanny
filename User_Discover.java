package com.example.snanny.UserClasses;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.snanny.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User_Discover extends Fragment implements ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupExpandListener {
    ExpandableListView expandableListView;
    ExpandableListAdapter listAdapter;
    List<String> listDataHeader;
    HashMap<String,  List<ItemsList>> listDataChild;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.user_discover,container,false);

        findIds(v);
        AddData();
        listAdapter  = new ExpandableListAdapter(getContext(),listDataHeader,listDataChild);
        expandableListView.setAdapter(listAdapter);
        expandableListView.setOnChildClickListener(this);
        expandableListView.setOnGroupExpandListener(this);
        return v;
    }

    private void AddData() {

        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<String, List<ItemsList>>();

        listDataHeader.add("Sweet");
        listDataHeader.add("Salty");
        listDataHeader.add("Fast Food");
        listDataHeader.add("Home dishes");

        List<ItemsList> itemsList = new ArrayList<>();
        itemsList.add(new ItemsList(R.drawable.food1,"Shivam",3.0f,R.drawable.food1,"Donuts","Spicy Donuts","Rs 100"));
        itemsList.add(new ItemsList(R.drawable.food1,"Shivam",3.0f,R.drawable.food1,"Donuts","Spicy Donuts","Rs 100"));
        itemsList.add(new ItemsList(R.drawable.food1,"Shivam",3.0f,R.drawable.food1,"Donuts","Spicy Donuts","Rs 100"));
        itemsList.add(new ItemsList(R.drawable.food1,"Shivam",3.0f,R.drawable.food1,"Donuts","Spicy Donuts","Rs 100"));
        itemsList.add(new ItemsList(R.drawable.food1,"Shivam",3.0f,R.drawable.food1,"Donuts","Spicy Donuts","Rs 100"));
        itemsList.add(new ItemsList(R.drawable.food1,"Shivam",3.0f,R.drawable.food1,"Donuts","Spicy Donuts","Rs 100"));


        List<ItemsList> itemsList1 = new ArrayList<>();
        itemsList1.add(new ItemsList(R.drawable.food1,"Shivam",3.0f,R.drawable.food1,"Donuts","Spicy Donuts","Rs 100"));
        itemsList1.add(new ItemsList(R.drawable.food1,"Shivam",3.0f,R.drawable.food1,"Donuts","Spicy Donuts","Rs 100"));
        itemsList1.add(new ItemsList(R.drawable.food1,"Shivam",3.0f,R.drawable.food1,"Donuts","Spicy Donuts","Rs 100"));
        itemsList1.add(new ItemsList(R.drawable.food1,"Shivam",3.0f,R.drawable.food1,"Donuts","Spicy Donuts","Rs 100"));
        itemsList1.add(new ItemsList(R.drawable.food1,"Shivam",3.0f,R.drawable.food1,"Donuts","Spicy Donuts","Rs 100"));
        itemsList1.add(new ItemsList(R.drawable.food1,"Shivam",3.0f,R.drawable.food1,"Donuts","Spicy Donuts","Rs 100"));


        List<ItemsList> itemsList2 = new ArrayList<>();
        itemsList2.add(new ItemsList(R.drawable.food1,"Shivam",3.0f,R.drawable.food1,"Donuts","Spicy Donuts","Rs 100"));
        itemsList2.add(new ItemsList(R.drawable.food1,"Shivam",3.0f,R.drawable.food1,"Donuts","Spicy Donuts","Rs 100"));
        itemsList2.add(new ItemsList(R.drawable.food1,"Shivam",3.0f,R.drawable.food1,"Donuts","Spicy Donuts","Rs 100"));
        itemsList2.add(new ItemsList(R.drawable.food1,"Shivam",3.0f,R.drawable.food1,"Donuts","Spicy Donuts","Rs 100"));
        itemsList2.add(new ItemsList(R.drawable.food1,"Shivam",3.0f,R.drawable.food1,"Donuts","Spicy Donuts","Rs 100"));
        itemsList2.add(new ItemsList(R.drawable.food1,"Shivam",3.0f,R.drawable.food1,"Donuts","Spicy Donuts","Rs 100"));


        List<ItemsList> itemsList4 = new ArrayList<>();
        itemsList4.add(new ItemsList(R.drawable.food1,"Shivam",3.0f,R.drawable.food1,"Donuts","Spicy Donuts","Rs 100"));
        itemsList4.add(new ItemsList(R.drawable.food1,"Shivam",3.0f,R.drawable.food1,"Donuts","Spicy Donuts","Rs 100"));
        itemsList4.add(new ItemsList(R.drawable.food1,"Shivam",3.0f,R.drawable.food1,"Donuts","Spicy Donuts","Rs 100"));
        itemsList4.add(new ItemsList(R.drawable.food1,"Shivam",3.0f,R.drawable.food1,"Donuts","Spicy Donuts","Rs 100"));
        itemsList4.add(new ItemsList(R.drawable.food1,"Shivam",3.0f,R.drawable.food1,"Donuts","Spicy Donuts","Rs 100"));
        itemsList4.add(new ItemsList(R.drawable.food1,"Shivam",3.0f,R.drawable.food1,"Donuts","Spicy Donuts","Rs 100"));


        listDataChild.put(listDataHeader.get(0),itemsList);
        listDataChild.put(listDataHeader.get(1),itemsList1);
        listDataChild.put(listDataHeader.get(2),itemsList2);
        listDataChild.put(listDataHeader.get(3),itemsList4);



    }

    private void findIds(View v) {

        expandableListView = v.findViewById(R.id.expandableListView);

    }

    @Override
    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

        Toast.makeText(getContext(), ""+listDataHeader.get(i)+" : "+listDataChild.get(listDataHeader.get(i)).get(i1), Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onGroupExpand(int i) {

    }
}
