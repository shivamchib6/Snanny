package com.example.snanny.NaniClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.snanny.R;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotifiactionViewHolder> {
    //VARIABLES OF THE CLASS
    Context  context;
    List<NotificationPerson> listofnotification;

    public NotificationAdapter(Context context, List<NotificationPerson> listofnotification) {
        this.context = context;
        this.listofnotification = listofnotification;
    }

    @NonNull
    @Override
    public NotifiactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //SETTING THE LAYOUT FILE THE INFLATER IN THE RECYLERVIEW
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.recyelr_view_notification,parent,false);
        return new NotifiactionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NotifiactionViewHolder holder, int position) {
        holder.personImageviewNotification.setImageResource(listofnotification.get(position).image);
        holder.personcomments.setText(listofnotification.get(position).comments);
        holder.timeoftheComments.setText(listofnotification.get(position).timeofComments);
    }

    @Override
    public int getItemCount() {
        return listofnotification.size();
    }

    class NotifiactionViewHolder extends RecyclerView.ViewHolder{
        ImageView personImageviewNotification;
        TextView personcomments,timeoftheComments;


        public NotifiactionViewHolder(@NonNull View itemView) {
            super(itemView);
            findIds(itemView);

        }

        private void findIds(View itemView) {
            // FIND THE IDS OF THE VIEWS
            personImageviewNotification = itemView.findViewById(R.id.notificationimageview);
            personcomments = itemView.findViewById(R.id.notificationfromperson);
            timeoftheComments = itemView.findViewById(R.id.notificationtime);
        }

    }

}
