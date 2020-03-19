package com.example.snanny.NaniClasses;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.snanny.R;

import java.util.ArrayList;

public class AddFood extends Fragment implements View.OnClickListener {
    Button spinneritem;
    Button specialityButton;
    Spinner allergiesList;
    String[] arrayitems = {"Items 1","Items 2","Items 3","Items 4"};
    String[] allergies = {"Select Allergies","No Allergies","Rashes","Lactose Intolerent","Irritation"};
    ArrayAdapter<String> arrayAdapter,arrayAdapterSpeciality;
    ArrayList<StateAllergies> allergiesarrayList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_food,container,false);
        spinneritem = v.findViewById(R.id.spinnneritem);
        arrayAdapter = new ArrayAdapter<String>(getContext(),R.layout.support_simple_spinner_dropdown_item,arrayitems);
        spinneritem.setOnClickListener(this);
        //LIST AND ADAPTER FOR THE SPECIALITY LIST
        arrayAdapterSpeciality = new ArrayAdapter<>(getContext(),R.layout.support_simple_spinner_dropdown_item,arrayitems);

        findId(v);

        //SETTING ONCLICKLISTENER ON MYSPECIALITY BUTTON
        specialityButton.setOnClickListener(this);
        //ALLERGIES ARRAYLIST AND ADAPTER
        allergiesarrayList = new ArrayList<>();
        addAllergies();
        MyAdapter myAdapter = new MyAdapter(getContext(),0,allergiesarrayList);
        allergiesList.setAdapter(myAdapter);



        return v;
    }

    private void addAllergies() {

        for (int i = 0;i< allergies.length;i++){
            allergiesarrayList.add(new StateAllergies(allergies[i],false));
        }

    }

    private void findId(View v) {
        specialityButton = v.findViewById(R.id.buttonitemspeciality);
        allergiesList = v.findViewById(R.id.spinnerallergies);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.spinnneritem:
                new AlertDialog.Builder(getContext())
                        .setTitle("Select any one").setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(getContext(), ""+ arrayitems[i],Toast.LENGTH_SHORT).show();

                    dialogInterface.dismiss();
                    }
                }).create().show();
                break;
            case R.id.buttonitemspeciality:
                new AlertDialog.Builder(getContext())
                        .setTitle("Select any one").setAdapter(arrayAdapterSpeciality, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(getContext(), ""+ arrayitems[i],Toast.LENGTH_SHORT).show();

                        dialogInterface.dismiss();
                    }
                }).create().show();
                break;
        }
    }
}
