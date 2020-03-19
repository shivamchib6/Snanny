package com.example.snanny.NaniClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.snanny.R;

import java.util.List;

class MyOrderHistorydapter extends RecyclerView.Adapter<MyOrderHistorydapter.OrderHistoryViewHolder> {
    Context context;
    List<OrderHistory> list1;

    public MyOrderHistorydapter(Context context, List<OrderHistory> list1) {
        this.context = context;
        this.list1 = list1;
    }

    @NonNull
    @Override
    public OrderHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.my_orders_completed_recyelerview_items,parent,false);

        return new OrderHistoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHistoryViewHolder holder, int position) {
        holder.personImage.setImageResource(list1.get(position).personimage);
        holder.foodimage.setImageResource(list1.get(position).orderimage);
        holder.nameoffood.setText(list1.get(position).foodname);
        holder.nameofperson.setText(list1.get(position).personname);
        holder.deliveryAmount.setText(list1.get(position).deliveryamount);
        holder.compltedornot.setText(list1.get(position).orderCompleted);
        holder.ratings.setRating(list1.get(position).ratings);
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }


    class OrderHistoryViewHolder extends RecyclerView.ViewHolder{

        ImageView personImage,foodimage;
        TextView nameofperson,nameoffood,deliveryAmount,compltedornot;
        RatingBar ratings;
        public OrderHistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            findIds(itemView);
        }

        private void findIds(View itemView) {
            personImage = itemView.findViewById(R.id.imageviewpersoncompleted);
            foodimage = itemView.findViewById(R.id.productimageviewcompleted);
            nameofperson = itemView.findViewById(R.id.nametextviewcompleted);
            nameoffood = itemView.findViewById(R.id.foodnametextviewcompleted);
            deliveryAmount = itemView.findViewById(R.id.deliveryamounttextviewcompleted);
            compltedornot = itemView.findViewById(R.id.completedtextview);
            ratings = itemView.findViewById(R.id.personratingbarcompleted);


        }
    }

}
