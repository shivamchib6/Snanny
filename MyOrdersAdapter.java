package com.example.snanny.NaniClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.snanny.R;

import java.util.List;

public class MyOrdersAdapter extends RecyclerView.Adapter<MyOrdersAdapter.MyOderViewHolder> {
    Context context;
    List<MyOrderList> persorOrderList;
    ButtonClicked  buttonClicked;
    boolean open = false;


    public MyOrdersAdapter(Context context, List<MyOrderList> persorOrderList, ButtonClicked buttonClicked) {
        this.context = context;
        this.persorOrderList = persorOrderList;
        this.buttonClicked = buttonClicked;
    }

    @NonNull
    @Override
    public MyOderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.recyler_view_oder_items,parent,false);

        return new MyOderViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOderViewHolder holder, int position) {
        holder.profileimageview.setImageResource(persorOrderList.get(position).personimage);
        holder.nameofperson.setText(persorOrderList.get(position).name);
        holder.locationofperson.setText(persorOrderList.get(position).Location);
        holder.ratingBarfood.setRating(persorOrderList.get(position).stars);
        holder.foodimageview.setImageResource(persorOrderList.get(position).foodimage);
        holder.nameoffood.setText(persorOrderList.get(position).foodName);
        holder.timeofdelivery.setText(persorOrderList.get(position).deliverydate);
        //holder.commentsonfood.setText(personListWithFood.get(position).comments);
        //holder.paymentmethod.setText(personListWithFood.get(position).deliveryTime);
    }

    @Override
    public int getItemCount() {

        return persorOrderList.size();
    }

    //MAKING THE VIEWHOLDER CLASS FOR THE MYORDERS
    class MyOderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView profileimageview,foodimageview,toggleImageview;
        TextView nameofperson,locationofperson,nameoffood,timeofdelivery;
        Button confirmOrder,cancelOrder;
        RatingBar ratingBarfood;
        RelativeLayout relativeLayout1,relativeLayout2;

        public MyOderViewHolder(@NonNull View itemView) {
            super(itemView);
            findIds();
            confirmOrder.setOnClickListener(this);
            cancelOrder.setOnClickListener(this);
            toggleImageview.setOnClickListener(this);
        }

        private void findIds() {
            relativeLayout1 = itemView.findViewById(R.id.relativelayout1);
            relativeLayout2 = itemView.findViewById(R.id.relativelayout2);
            toggleImageview = itemView.findViewById(R.id.opencloseimageview);
            profileimageview = itemView.findViewById(R.id.imageviewperson);
            foodimageview = itemView.findViewById(R.id.productimageview);
            nameofperson = itemView.findViewById(R.id.nametextview);
            locationofperson = itemView.findViewById(R.id.locationtextview);
            nameoffood = itemView.findViewById(R.id.foodnametextview);
            timeofdelivery = itemView.findViewById(R.id.deliverymonthtextview);
            confirmOrder = itemView.findViewById(R.id.confirmbutton);
            cancelOrder = itemView.findViewById(R.id.cancelorderbutton);
            ratingBarfood = itemView.findViewById(R.id.personratingbar);


        }

        @Override
        public void onClick(View view) {

            int id = view.getId();
            switch (id){

                case R.id.confirmbutton:
                    buttonClicked.onButtonClicked(view,getAdapterPosition());
                    toggleImageview.setVisibility(View.VISIBLE);



                    break;
                case R.id.cancelorderbutton:
                    buttonClicked.onButtonClicked(view,getAdapterPosition());
                    break;
                case R.id.opencloseimageview:

                    if (!open){
                        toggleImageview.setImageResource(R.drawable.ic_arrow_drop_up_black_24dp);
                        relativeLayout1.setVisibility(View.VISIBLE);
                        relativeLayout2.setVisibility(View.VISIBLE);
                        open = true;
                    }else {
                        toggleImageview.setImageResource(R.drawable.ic_arrow_drop_down_black_24dp);
                        relativeLayout1.setVisibility(View.GONE);
                        relativeLayout2.setVisibility(View.GONE);
                        open = false;
                    }

                    break;
            }



        }
    }


    public interface ButtonClicked{

        public void onButtonClicked(View v,int listposition);

    }
}
