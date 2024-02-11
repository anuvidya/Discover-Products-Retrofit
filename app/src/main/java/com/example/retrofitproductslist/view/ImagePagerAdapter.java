package com.example.retrofitproductslist.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.retrofitproductslist.R;

import java.util.List;

public class ImagePagerAdapter extends RecyclerView.Adapter<ImagePagerAdapter.ImageViewHolder> {

    private List<String> images;

    private Context context;
    public ImagePagerAdapter(Context context, List<String> images) {

        this.images = images;
        this.context = context;

    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View itemView = LayoutInflater.from(context).inflate(R.layout.item_images, parent, false);
        return new ImageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {

        //Glide is a popular image loading framework
        Glide.with(context)
                .load(images.get(position))
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
