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

class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.PaymentViewHolder> {
    Context context;
    List<PaymentDetails>  list;

    public PaymentAdapter(Context context, List<PaymentDetails> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public PaymentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.recyelr_view_payment_items,parent,false);
        return new PaymentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).image);
        holder.name.setText(list.get(position).name);
        holder.location.setText(list.get(position).location);
        holder.amount.setText(list.get(position).amount);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class PaymentViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name,location,amount;

        public PaymentViewHolder(@NonNull View itemView) {
            super(itemView);
            findids(itemView);
        }

        private void findids(View itemView) {
            imageView = itemView.findViewById(R.id.imageviewpayment);
            name = itemView.findViewById(R.id.nameid);
            location = itemView.findViewById(R.id.locationid);
            amount = itemView.findViewById(R.id.amountid);

        }


    }
}
