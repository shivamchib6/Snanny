package com.example.snanny.NaniClasses;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.snanny.R;

import java.util.ArrayList;
import java.util.List;

public class MyOrders extends Fragment {
    // VARIABLES OF THE CLASS
    RecyclerView  myorder;
    List<MyOrderList>  myOrderLists;
    MyOrdersAdapter ma;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.my_orders,container,false);
        //GETTING THE ID OF RECYCLERVIEW AND ADDING THE LAYOUT MANAGER AND ADAPTER
        myorder = v.findViewById(R.id.recyclerviewmyorder);
        myorder.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

        addOrder();

        ma = new MyOrdersAdapter(getContext(), myOrderLists, new MyOrdersAdapter.ButtonClicked() {
            @Override
            public void onButtonClicked(View v, int position) {
                if (v.getId() == R.id.confirmbutton){
                    Toast.makeText(getContext(), "Recycler view is "+ position + "Button Clicked is Confirm" , Toast.LENGTH_SHORT).show();
                    // TO GET DETAIL OF EVERY ITEM IN RECYLERVIEW
                    myOrderLists.get(position);

                }
                 else if (v.getId() == R.id.cancelorderbutton){
                    Toast.makeText(getContext(), "Recycler view is "+ position + "Button Clicked is Cancel" , Toast.LENGTH_SHORT).show();
                }
            }
        });
        myorder.setAdapter(ma);
        return v;
    }

    private void addOrder() {
        myOrderLists = new ArrayList<>();
        myOrderLists.add(new MyOrderList(R.drawable.food1,"Shivam","Amritsar",2,R.drawable.food1,"Donuts"
                ,"Today"));
        myOrderLists.add(new MyOrderList(R.drawable.food1,"Shivam Thakur","Mohali",2,R.drawable.food1,"Donuts"
               ,"Today"));


    }
}
