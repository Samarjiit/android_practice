package com.example.practice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.ArrayList;

public class ContactListAdapter extends BaseAdapter {
    ArrayList<Contact> arrayList;
    LayoutInflater layoutInflater;

    public ContactListAdapter(Context context, ArrayList<Contact> arrayList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder  holder;
        if(view==null){
            view = layoutInflater.inflate(R.layout.contact_list_item,null);
            holder = new ViewHolder();
            holder.tvId = view.findViewById(R.id.tvId);
            holder.tvName = view.findViewById(R.id.tvName);
            holder.tvNumber = view.findViewById(R.id.tvNumber);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tvId.setText(""+arrayList.get(i).getID());
        holder.tvName.setText(""+arrayList.get(i).getName());
        holder.tvNumber.setText(""+arrayList.get(i).getPhoneNumber());

        return view;
    }
    static class ViewHolder{
        TextView tvId;
        TextView tvName;
        TextView tvNumber;
    }
}
