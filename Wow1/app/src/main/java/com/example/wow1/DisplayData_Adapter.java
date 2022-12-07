package com.example.wow1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DisplayData_Adapter extends RecyclerView.Adapter<DisplayData_Adapter.ViewHolder> {

    Context context;
    List<productUpload2> productUpload2List;

    public DisplayData_Adapter(Context context, List<productUpload2> productUpload2List) {
        this.context = context;
        this.productUpload2List = productUpload2List;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.design_layout_for_display_data,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        productUpload2 productUpload2=productUpload2List.get(position);
//        holder.description.setText();

    }

    @Override
    public int getItemCount() {
        return productUpload2List.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            description=itemView.findViewById(R.id.discription);

        }
    }
}
