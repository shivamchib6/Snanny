package com.example.snanny.NaniClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.snanny.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ArrayAdapter<StateAllergies> {

    private Context mContext;
    private ArrayList<StateAllergies> listState;
    private MyAdapter myAdapter;
    private boolean isFromView = false;

    public MyAdapter(Context context, int resource, List<StateAllergies> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.listState = (ArrayList<StateAllergies>) objects;
        this.myAdapter = this;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    private View getCustomView(final int position, View convertView, ViewGroup parent){

        final MyViewHolder holder;
        if (convertView == null){

            LayoutInflater layoutInflator = LayoutInflater.from(mContext);
            convertView = layoutInflator.inflate(R.layout.spinner_allergies_item, null);
            holder = new MyViewHolder();
            holder.mtextView = (TextView) convertView
                    .findViewById(R.id.textviewallergies);
            holder.mcheckBox = (CheckBox) convertView
                    .findViewById(R.id.checkboxallergies);
            convertView.setTag(holder);
        }else{
            holder = (MyViewHolder) convertView.getTag();
        }
        holder.mtextView.setText(listState.get(position).getTitle());

        // To check weather checked event fire from getview() or user input
        isFromView = true;
        holder.mcheckBox.setChecked(listState.get(position).isSelected());
        isFromView = false;

        if ((position == 0)) {
            holder.mcheckBox.setVisibility(View.INVISIBLE);
        } else {
            holder.mcheckBox.setVisibility(View.VISIBLE);
        }
        holder.mcheckBox.setTag(position);

        holder.mcheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int getPosition = (Integer) buttonView.getTag();

                if (!isFromView) {
                    listState.get(position).setSelected(isChecked);
                }
            }
        });
        return convertView;

    }
    class MyViewHolder{
        TextView mtextView;
        CheckBox mcheckBox;
    }

}
