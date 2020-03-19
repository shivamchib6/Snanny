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

public class Payment extends Fragment {
    //VARIABLES OF THE CLASS
    RecyclerView recyclerViewpayment;
    List<PaymentDetails> listofpayment;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.payment,container,false);

        addPayment();

        recyclerViewpayment = v.findViewById(R.id.recycler_view_payments);
        recyclerViewpayment.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        recyclerViewpayment.setAdapter(new PaymentAdapter(getContext(),listofpayment));

        return v;
    }

    private void addPayment() {
        listofpayment = new ArrayList<>();
        listofpayment.add(new PaymentDetails(R.drawable.ic_person_red_24dp,"shivam","Amritsar","$10"));
        listofpayment.add(new PaymentDetails(R.drawable.ic_person_red_24dp,"shivam","Amritsar","$10"));
    }
}
