package com.example.snanny.NaniClasses;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.snanny.NaniClasses.BottomSheetFragment;
import com.example.snanny.NaniClasses.ChangePasswordFragment;
import com.example.snanny.R;

import java.util.ArrayList;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileSettings  extends Fragment implements View.OnClickListener {

    // VARIABLES OF THE CLASS
    Button specialitiesSpinner;
    ArrayList<String> listofSpecialities ;
    ArrayAdapter<String> arrayAdapter;
    LinearLayout linearLayout1 ;
    int val = 0;
    HashMap<Integer,String> list ;
    LinearLayout linearlayoutchangePassword;
    CircleImageView circleImageView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vv= inflater.inflate(R.layout.profile_settings_fragment,container,false);

        listofSpecialities = new ArrayList<>();
        listofSpecialities.add("Cake");
        listofSpecialities.add("Donuts");
        listofSpecialities.add("Pizza");
        listofSpecialities.add("Veg");


        specialitiesSpinner = vv.findViewById(R.id.spinnerspecialities);
        arrayAdapter = new ArrayAdapter<String >(getContext(),android.R.layout.simple_spinner_dropdown_item,listofSpecialities);
        specialitiesSpinner.setOnClickListener(this);
        linearLayout1 = vv.findViewById(R.id.edittextprofilesettings3);
        linearlayoutchangePassword = vv.findViewById(R.id.edittextprofilesettings4);
        linearlayoutchangePassword.setOnClickListener(this);

        //FINDING THE ID OF THE CIRCULARIMAGEVIEW
        circleImageView = vv.findViewById(R.id.profileimagecheck);
        circleImageView.setOnClickListener(this);

        list = new HashMap<>();
        return vv;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){

            case R.id.spinnerspecialities:
                Toast.makeText(getContext(), "Clicked!", Toast.LENGTH_SHORT).show();
                new AlertDialog.Builder(getContext()).setTitle("Specialities List")
                        .setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getContext(), ""+listofSpecialities.get(i), Toast.LENGTH_SHORT).show();
                                dialogInterface.dismiss();
                                list.put(val,listofSpecialities.get(i));

                                val++;

                                addEdittext(i,list,val);
                                listofSpecialities.remove(i);
                            }

                        }).create().show();
                break;

            case R.id.edittextprofilesettings4:

                ChangePasswordFragment sp = new ChangePasswordFragment();
                openFragment(sp);

                break;
            case R.id.profileimagecheck:

                BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();
                bottomSheetFragment.show(getFragmentManager(),"exampleBottomSheet");


                break;


        }
    }

    private void addEdittext(final int position, final HashMap<Integer, String> list, int val) {

        final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0,10,0,0);
        final LinearLayout linearLayoutinside = new LinearLayout(getContext());
        //linearLayoutinside.removeAllViews();


        final TextView tv = new TextView(getContext());
        tv.setPadding(5,0,5,0);
        final ImageView imageView = new ImageView(getContext());
        linearLayoutinside.setBackgroundResource(R.drawable.textview_background_dynamic);
        linearLayoutinside.addView(tv);
        linearLayoutinside.addView(imageView);

        linearLayout1.addView(linearLayoutinside);


        for (int p = 0;p<val;p++) {

            linearLayoutinside.setOrientation(LinearLayout.HORIZONTAL);
            linearLayoutinside.setLayoutParams(layoutParams);
            tv.setLayoutParams(layoutParams);
            imageView.setLayoutParams(layoutParams);
            tv.setText(list.get(p));
            imageView.setImageResource(R.drawable.ic_close_black_24dp);

            }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Adding click listener on the button
//                Toast.makeText(getContext(), "The item is "+ listofSpecialities.get(position), Toast.LENGTH_SHORT).show();
                Log.d("Position is ", position+"");
                linearLayoutinside.removeView(tv);
                linearLayoutinside.removeView(imageView);
                list.remove(list.get(tv.getText()));
                if (listofSpecialities.size() == 0){
                    listofSpecialities.add(0,tv.getText()+"");
                }else {
                    listofSpecialities.add(position,tv.getText()+"");
                }
                Log.d("List is ",list.toString());
              //  linearLayoutinside.removeAllViews();
               // addEdittext(i,list,list.size());
            }
        });

    }

    private void openFragment(Fragment hm) {
        FragmentTransaction fm = getFragmentManager().beginTransaction();
        fm.replace(R.id.framelayout1,hm);
        fm.commit();
    }


}
