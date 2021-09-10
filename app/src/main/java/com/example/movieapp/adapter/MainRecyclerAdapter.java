package com.example.movieapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movieapp.ui.MovieDetails;
import com.example.movieapp.R;
import com.example.movieapp.pojo.Video;

import java.util.ArrayList;
import java.util.List;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder> {

    Context context;
    List<Video> mList;
    private static final String TAG = "MainRecyclerAdapter";

    public MainRecyclerAdapter(Context context, List<Video> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(context).inflate(R.layout.category_recycler_row_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {

        holder.itemTv.setText(mList.get(position).getTitle());
        Glide.with(context).load(mList.get(position).getThumb()).into(holder.itemImage);

        holder.itemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   Toast.makeText(context, ""+mList.get(position).getTitle(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, MovieDetails.class);

                intent.putExtra("description",mList.get(position).getDescription());
                intent.putStringArrayListExtra("sources",(ArrayList<String>) mList.get(position).getSources());
                Log.d(TAG, "onClick: "+mList.get(position).getSources());
                intent.putExtra("postion",position);
                intent.putExtra("subTitle",mList.get(position).getSubtitle());
                intent.putExtra("thumb",mList.get(position).getThumb());
                intent.putExtra("title",mList.get(position).getTitle());

                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static final class MainViewHolder extends RecyclerView.ViewHolder {
        TextView itemTv;
        ImageView itemImage;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            itemTv = itemView.findViewById(R.id.item_tv);

        }
    }

}
