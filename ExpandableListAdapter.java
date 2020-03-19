package com.example.snanny.UserClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.snanny.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    Context context;
    List<String> listDataHeader;
    HashMap<String,List<ItemsList>> listdataChild;

    public ExpandableListAdapter(Context context, List<String> listDataHeader, HashMap<String, List<ItemsList>> listdataChild) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listdataChild = listdataChild;
    }
    @Override
    public int getGroupCount() {
        return listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return listdataChild.get(listDataHeader.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return listDataHeader.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return listdataChild.get(listDataHeader.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String header = (String) getGroup(i);
        if (view == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.expandable_header,null);

        }
        TextView textView = view.findViewById(R.id.textviewheadingexpandable);
        textView.setText(header);


        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
//        String childText = (String) getChild(i,i1);
        String getGroupOfList =(String) getGroup(i);
        List<ItemsList> listofItems = listdataChild.get(getGroupOfList);
        if (view == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.expandable_item,null);
        }

        CircleImageView circleImageView = view.findViewById(R.id.expandablecircleimageview_items);
        circleImageView.setImageResource(listofItems.get(i1).image);
        TextView textViewnameofuser = view.findViewById(R.id.expandabletextviewname_items);
       // textViewnameofuser.setText("Name");
        textViewnameofuser.setText(listofItems.get(i1).username);
        RatingBar ratingBarfooodrating = view.findViewById(R.id.expandableratingbaritem);
        //ratingBarfooodrating.setRating(2.0f);
        ratingBarfooodrating.setRating(listofItems.get(i1).rating);
        ImageView imageViewfoodimage = view.findViewById(R.id.expandableimageviewfood);
        //imageViewfoodimage.setImageResource(R.drawable.food1);
        imageViewfoodimage.setImageResource(listofItems.get(i1).imageofFood);
        TextView textViewfoodname = view.findViewById(R.id.expandabletextviewnameofdish_items);
        //textViewfoodname.setText("Food Name");
         textViewfoodname.setText(listofItems.get(i1).nameofDish);
        TextView textviewPrice = view.findViewById(R.id.expandabletextviewpriceofdish_items);
        //textviewPrice.setText("Price");
        textviewPrice.setText(listofItems.get(i1).price);
        TextView textView = view.findViewById(R.id.expandabletextviewdescriptionofdish);
        //textView.setText("Description");
        textView.setText(listofItems.get(i1).description);

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
