package com.example.snanny.UserClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.snanny.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

class NaniListAdapter extends RecyclerView.Adapter<NaniListAdapter.NaniListViewHolder> {
    Context context;
    List<NaniList> naniLists;
    onNaniPersonClicked onnaniPersonClicked;

    public NaniListAdapter(Context context, List<NaniList> naniLists, onNaniPersonClicked onnaniPersonClicked) {
        this.context = context;
        this.naniLists = naniLists;
        this.onnaniPersonClicked = onnaniPersonClicked;
    }

    @NonNull
    @Override
    public NaniListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.nani_list_items,parent,false);
        return new NaniListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NaniListViewHolder holder, int position) {
        holder.circleImageViewNaniItems.setImageResource(naniLists.get(position).imageid);
        holder.textViewNaniName.setText(naniLists.get(position).naniname);
    }

    @Override
    public int getItemCount() {
        return naniLists.size();
    }

    class NaniListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CircleImageView circleImageViewNaniItems;
        TextView textViewNaniName;

        public NaniListViewHolder(@NonNull View itemView) {
            super(itemView);
            circleImageViewNaniItems = itemView.findViewById(R.id.circular_image_view_nani_items);
            textViewNaniName = itemView.findViewById(R.id.textviiew_nani_list_names);

            circleImageViewNaniItems.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int id  = view.getId();
            switch (id){

                case R.id.circular_image_view_nani_items:
                    onnaniPersonClicked.personClicked(getAdapterPosition());
                    break;
            }


        }
    }
    public interface onNaniPersonClicked{

        public void personClicked(int position);

    }

}
