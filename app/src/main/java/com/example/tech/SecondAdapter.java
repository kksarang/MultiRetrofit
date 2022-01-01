package com.example.tech;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.ViewHolder> {

    ModelCategory categorydata[];

    public SecondAdapter(ModelCategory[] categorydata) {
        this.categorydata = categorydata;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.second_iteam,parent,false);
        return new SecondAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(categorydata[position].getName());
        holder.size.setText("Courses "+categorydata [position].getNumber_of_courses());
        Glide.with(holder.img.getContext()).load(categorydata[position].getThumbnail()).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return categorydata.length;
    }




    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name,size;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            name=itemView.findViewById(R.id.category_txt);
            size=itemView.findViewById(R.id.category_size);

            img=itemView.findViewById(R.id.category_img);
        }
    }
}
