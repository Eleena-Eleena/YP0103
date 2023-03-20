package com.example.yp01;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context mContext;
    private List<model_Block> mData;
    RequestOptions options;

    public RecyclerViewAdapter(Context mContext, List<model_Block> mData)
    {
        this.mContext = mContext;
        this.mData = mData;
        options = new RequestOptions().centerCrop().placeholder(R.color.background).error(R.color.background);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.block_row,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, HomePage.class);
                i.putExtra("title",mData.get(viewHolder.getAdapterPosition()).getTitle());
                i.putExtra("description",mData.get(viewHolder.getAdapterPosition()).getDescription());
                i.putExtra("img",mData.get(viewHolder.getAdapterPosition()).getmImage());
                mContext.startActivity(i);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_name.setText(mData.get(position).getTitle());
        holder.tv_desc.setText(mData.get(position).getDescription());
        Glide.with(mContext).load(mData.get(position).getmImage()).apply(options).into(holder.tv_img);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        TextView tv_desc;
        ImageView tv_img;
        LinearLayout view_container;

        public MyViewHolder(View itemview1) {
            super(itemview1);
            tv_name = itemview1.findViewById(R.id.block_name);
            tv_desc = itemview1.findViewById(R.id.block_desc);
            tv_img = itemview1.findViewById(R.id.thumbnail);
            view_container = itemview1.findViewById(R.id.container);
        }
    }







}
