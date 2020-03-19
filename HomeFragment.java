package com.example.snanny.NaniClasses;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.snanny.R;
import com.example.snanny.UserClasses.UserHome;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener, HorizontalDishAdapter.onClickOnFood
{
    //VARIABLES OF THE CLASS
    DrawerLayout drawerLayout;
    ImageView imageViewNavigationDrawer,profileImageView,notificationbell;
    NavigationView navigationView;
    List<FoodDetailsModel> personListWithFood;
    RecyclerView recyclerViewHorzontalView,recyclerViewVeritical;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.home_layout,container,false);
        //FINDING THE IDS OF ALL THE VIEWS IN THiE SCREEN
        findIds(v);
        //ADDING ONCLICKLISTENER ON BUTTON
        imageViewNavigationDrawer.setOnClickListener(this);
        navigationView.setNavigationItemSelectedListener(this);
        //ADDING ONCLICKLISTENER ON THE IMAGEVIEW OF THE PROFILE ON THE TOP NAVIGATIONVIEW
        profileImageView.setOnClickListener(this);
        //ADDING THE PERSON  TO THE LIST
        addPerson();


        //ADDING ADAPTER TO HORIZONTAL RECYCLERVIEW IN THE LIST
        HorizontalDishAdapter horizontalDishAdapter =  new HorizontalDishAdapter(getContext(),personListWithFood,this);
        recyclerViewHorzontalView.setAdapter(horizontalDishAdapter);
        recyclerViewHorzontalView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        //ADDING ADAPTER TO THE VERTICAL RECYLERVIEW IN TH LIST
        VerticalDishAdapter DishAdapter =  new VerticalDishAdapter(getContext(),personListWithFood);
        recyclerViewVeritical .setAdapter(DishAdapter);
        recyclerViewVeritical.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        //ADDING ONCLCIKLISTENER ON THE NOTIFICATION BELL ICON
        notificationbell.setOnClickListener(this);

        return v;
    }

    private void findIds(View v) {
        //FINDING THE IDS OF THE VARIOUS VIEWS OF THE FRAGMENT
        recyclerViewVeritical = v.findViewById(R.id.recycler_view_two);
        recyclerViewHorzontalView = v.findViewById(R.id.recycler_view_one);
        imageViewNavigationDrawer = v.findViewById(R.id.navigationdrawerbutton);
        drawerLayout = v.findViewById(R.id.drawerlayout1);
        navigationView = v.findViewById(R.id.navigation_view);
        notificationbell = v.findViewById(R.id.notificationbellicon);
        //FINDING THE VIEW OF THE NAVIGATION HEADER
        View navHeader = navigationView.getHeaderView(0);
        profileImageView = navHeader.findViewById(R.id.profileimageview);
    }
    private void addPerson() {
        personListWithFood = new ArrayList<>();
        personListWithFood.add(new FoodDetailsModel(R.drawable.food1,"Shivam","Amritsar",2,R.drawable.food1,"Donuts",
                "Nice..food","Today","Payment : Cash"));
        personListWithFood.add(new FoodDetailsModel(R.drawable.food1,"Shivam","Amritsar",2,R.drawable.food1,"Donuts",
                "Nice..food","Today","Payment : Cash"));

        Log.d("abcd",personListWithFood.get(0).comments);
    }
    //ADDING OnClickListener ON VARIOUS BUTTONS PRESENT ON THE HOME SCREEN
    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.navigationdrawerbutton:
                Toast.makeText(getContext(), "Button Clicked", Toast.LENGTH_SHORT).show();
                drawerLayout.openDrawer(Gravity.LEFT);
                break;
            case R.id.profileimageview:
                Toast.makeText(getContext(), "Profile is clicked", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(Gravity.LEFT);
                break;
            case R.id.notificationbellicon:
                Toast.makeText(getContext(), "Notification Icon Clicked ", Toast.LENGTH_SHORT).show();
                Notificationfragement nf = new Notificationfragement();
                openFragment(nf);
                break;
        }
    }
    //ADDING OnClickListener ON THE ITEMS IN THE NAVIGATION DRAWER
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id){
            case R.id.one:
                Toast.makeText(getContext(), "One is clicked", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(Gravity.LEFT);
                return true;
            case R.id.two:
                Toast.makeText(getContext(), "two is clicked", Toast.LENGTH_SHORT).show();
                MyOrders my = new MyOrders();
                openFragment(my);
                drawerLayout.closeDrawer(Gravity.LEFT);
                return true;
            case R.id.three:
                Payment payment= new Payment();
                openFragment(payment);
                Toast.makeText(getContext(), "three is clicked", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(Gravity.LEFT);
                return true;
            case R.id.four:
                Toast.makeText(getContext(), "four is clicked", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(Gravity.LEFT);
                startActivity(new Intent(getContext(), UserHome.class));
                return true;
        }
        return false;
    }
    //TO OPEN A NEW FRAGMET IN LAYOUT
    private void openFragment(Fragment hm) {
        FragmentTransaction fm = getFragmentManager().beginTransaction();
        fm.replace(R.id.framelayout1,hm);
        fm.commit();
    }
    //TO CLICK ON ITEM IN THE FIRST HORIZONTALVIEW IN THE LIST
    @Override
    public void foodItem(int position) {
        Toast.makeText(getContext(), ""+personListWithFood.get(position), Toast.LENGTH_SHORT).show();;
        GetItemDetails gs = new GetItemDetails();
        //PASS DATA FROM ONE FRAGEMNT TO ANOTHER
        Bundle bundle = new Bundle();
        FoodDetailsModel arrayList = personListWithFood.get(position);

        bundle.putString("test","this is for testing");
        bundle.putSerializable("Testing2",  arrayList);
        gs.setArguments(bundle);


        openFragment(gs);
     }
}
