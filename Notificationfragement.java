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

public class Notificationfragement extends Fragment {
    RecyclerView recyclerViewnotification;
    List<NotificationPerson> list;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.notification_fragment,container,false);
        recyclerViewnotification = v.findViewById(R.id.recyclerviewnotification);
        addNotification();
        NotificationAdapter na = new NotificationAdapter(getContext(),list);
        recyclerViewnotification.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        recyclerViewnotification.setAdapter(na);

        return v;
    }

    private void addNotification() {
        list = new ArrayList<>();
        list.add(new NotificationPerson(R.drawable.ic_person_red_24dp,"Shivam commented on your food","5 months ago"));
        list.add(new NotificationPerson(R.drawable.ic_person_red_24dp,"Shivam commented on your food","5 months ago"));
        list.add(new NotificationPerson(R.drawable.ic_person_red_24dp,"Shivam commented on your food","5 months ago"));
        list.add(new NotificationPerson(R.drawable.ic_person_red_24dp,"Shivam commented on your food","5 months ago"));
    }
}
