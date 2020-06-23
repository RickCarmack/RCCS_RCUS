package com.rccs.android.rcusnet;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    ArrayList<String> church;
    ArrayList<String> city;
    ArrayList<String> state;
    ArrayList<String> classis;
    ArrayList<String> address;
    ArrayList<String> phone;
    ArrayList<String> pastor;
    ArrayList<String> email;
    ArrayList<String> web;
    Context context;

    public CustomAdapter(Context context,
                         ArrayList<String> church,
                         ArrayList<String> city,
                         ArrayList<String> state,
                         ArrayList<String> classis,
                         ArrayList<String> address,
                         ArrayList<String> phone,
                         ArrayList<String> pastor,
                         ArrayList<String> email,
                         ArrayList<String> web) {
        this.context = context;
        this.church = church;
        this.city = city;
        this.state = state;
        this.classis = classis;
        this.address = address;
        this.phone = phone;
        this.pastor = pastor;
        this.email = email;
        this.web = web;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflate the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.church_row, parent, false);
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // set the data in items
        holder.church.setText(church.get(position));
        holder.city.setText(city.get(position));
        holder.state.setText(state.get(position));
        holder.classis.setText(classis.get(position));
        holder.address.setText(address.get(position));
        holder.phone.setText(phone.get(position));
        holder.pastor.setText(pastor.get(position));
        holder.email.setText(email.get(position));
        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display a toast with person name on item click
                Toast.makeText(context, church.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return church.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView church, city, state, classis, address, phone, pastor, email, web;// init the item view's

        public MyViewHolder(View itemView) {
            super(itemView);

            // get the reference of item view's
            church = (TextView) itemView.findViewById(R.id.tvChurch);
            classis = (TextView) itemView.findViewById(R.id.tvClassis);
            address = (TextView) itemView.findViewById(R.id.tvAddress);
            phone = (TextView) itemView.findViewById(R.id.tvPhone);
            pastor = (TextView) itemView.findViewById(R.id.tvContact);
            web = (TextView) itemView.findViewById(R.id.tvWebsite);
        }
    }
}