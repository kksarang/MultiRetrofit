package com.example.tech;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class myadapter extends RecyclerView.Adapter<myadapter.ViewHolder> {


     Model data[];

    public myadapter(Model[] data) {
        this.data = data;
    }



    @NonNull
    @Override
    public myadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.iteams,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull myadapter.ViewHolder holder, int position) {

        holder.title.setText(data[position].getTitle());
        holder.rate.setText(data[position].getPrice());
        Glide.with(holder.image.getContext()).load(data[position].getThumbnail()).into(holder.image);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent intent= new Intent(myadapter.,Course.class);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView rate;
        ImageView image;
        CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.category_txt);
            rate=itemView.findViewById(R.id.course_prize);
            image=itemView.findViewById(R.id.category_img);
            cardView=itemView.findViewById(R.id.card_view_id);

        }
    }
}
