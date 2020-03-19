package com.example.snanny.NaniClasses;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.snanny.R;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {
    RecyclerView recyclerViewmyorders;
    List<OrderHistory> list1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v  = inflater.inflate(R.layout.search_fragment,container,false);
        //Adding all items to list
        addListItems();

        //FINDING ALL THE IMPORTANT THINGS OF THE RECYELRVIEW
        recyclerViewmyorders = v.findViewById(R.id.recyelerview_myorders);
        recyclerViewmyorders.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        recyclerViewmyorders.setAdapter(new MyOrderHistorydapter(getContext(),list1));



        return v;
    }

    private void addListItems() {
        list1 = new ArrayList<>();
        list1.add(new OrderHistory(R.drawable.ic_person_red_24dp,R.drawable.food1,"Shivam","Donuts",3,"Mohali","$10","Completed(2 days ago)"));
        list1.add(new OrderHistory(R.drawable.ic_person_red_24dp,R.drawable.food1,"Shivam","Donuts",3,"Mohali","$10","Completed(2 days ago)"));

    }
}
