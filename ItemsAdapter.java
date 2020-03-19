package com.example.snanny.UserClasses;

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

import de.hdodenhof.circleimageview.CircleImageView;

class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ListViewHolder> {
    Context context;
    List<ItemsList> itemsLists;
    FoodItemClicked foodItemClicked;

    public ItemsAdapter(Context context, List<ItemsList> itemsLists, FoodItemClicked foodItemClicked) {
        this.context = context;
        this.itemsLists = itemsLists;
        this.foodItemClicked = foodItemClicked;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.list_items,parent,false);
        return new ListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.userImage.setImageResource(itemsLists.get(position).image);
        holder.nameofUser.setText(itemsLists.get(position).username);
        holder.ratingBaritem.setRating(itemsLists.get(position).rating);
        holder.imageofFood.setImageResource(itemsLists.get(position).imageofFood);
        holder.nameofFood.setText(itemsLists.get(position).nameofDish);
        holder.priceofFood.setText(itemsLists.get(position).price);
        holder.descriptionofFood.setText(itemsLists.get(position).description);
    }

    @Override
    public int getItemCount() {
        return itemsLists.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CircleImageView userImage;
        TextView nameofUser;
        RatingBar ratingBaritem;
        ImageView imageofFood;
        TextView nameofFood,priceofFood,descriptionofFood;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            findIds(itemView);
            imageofFood.setOnClickListener(this);

        }
        private void findIds(View itemView) {
            userImage = itemView.findViewById(R.id.circleimageview_items);
            nameofUser = itemView.findViewById(R.id.textviewname_items);
            ratingBaritem = itemView.findViewById(R.id.ratingbaritem);
            imageofFood = itemView.findViewById(R.id.imageviewfood);
            nameofFood = itemView.findViewById(R.id.textviewnameofdish_items);
            priceofFood = itemView.findViewById(R.id.textviewpriceofdish_items);
            descriptionofFood =itemView.findViewById(R.id.textviewdescriptionofdish_items);
        }

        @Override
        public void onClick(View view) {
            int id = view.getId();
            switch (id){
                case R.id.imageviewfood:
                    foodItemClicked.DoAction(getAdapterPosition());
                    break;
            }



        }
    }
    public interface FoodItemClicked{
        public void DoAction(int position);
    }


}
