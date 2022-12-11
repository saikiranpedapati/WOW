package com.example.wow1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;

    ArrayList<User> list;

    public MyAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View v= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
       return new MyViewHolder(v);



    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        User user=list.get(position);
        holder.Descriptioninfo.setText(user.getUser());
        holder.Pictureinfo.setText(user.getPic());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Descriptioninfo, Pictureinfo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Descriptioninfo=itemView.findViewById(R.id.descriptiondisplaychey);
            Pictureinfo=itemView.findViewById(R.id.pictureinfodisplaychey);


        }
    }
}
