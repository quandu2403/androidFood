package com.example.anfood.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anfood.Model.Store;
import com.example.anfood.R;

import java.util.ArrayList;

public class ListStoreAdapter extends RecyclerView.Adapter<ListStoreAdapter.ViewHolder> {
    public ArrayList<Store> dsstore;
    private View.OnClickListener mOnItemClickListener;
    public ListStoreAdapter(ArrayList<Store> dsstore){this.dsstore=dsstore;}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_liststore, parent, false);

        // Return a new holder instance
        ListStoreAdapter.ViewHolder viewHolder = new ListStoreAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Store store = dsstore.get(position);
        TextView tv_title = holder.tv_title;
        TextView tv_rating = holder.tv_rating;
        TextView tv_vitri = holder.tv_vitri;
        ImageView tv_img = holder.tv_img;

        tv_title.setText(store.getTitle());
        tv_rating.setText(store.getRating()+"");
        tv_vitri.setText(store.getVitri());
        tv_img.setImageResource(store.getImg());
    }
    public void setOnItemClickListener(View.OnClickListener itemClickListener) {
        mOnItemClickListener = itemClickListener;
    }
    @Override
    public int getItemCount() {
        return dsstore.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_title;
        public TextView tv_rating;
        public TextView tv_vitri;
        public ImageView tv_img ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_store_title);
            tv_rating=itemView.findViewById(R.id.tv_store_rating);
            tv_vitri= itemView.findViewById(R.id.tv_store_vitri);
            tv_img = itemView.findViewById(R.id.tv_store_img);
            itemView.setTag(this);
            itemView.setOnClickListener(mOnItemClickListener);
        }
    }
}
