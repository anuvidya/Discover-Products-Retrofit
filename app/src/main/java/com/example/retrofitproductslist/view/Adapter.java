package com.example.retrofitproductslist.view;

import static androidx.core.content.ContextCompat.startActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.retrofitproductslist.R;
import com.example.retrofitproductslist.model.ProductsItem;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder> {

    Context mCtx;

    List<ProductsItem> productsItemList;

    public Adapter(Context mCtx, List<ProductsItem> productsItemList) {
        this.mCtx = mCtx;
        this.productsItemList = productsItemList;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mCtx).inflate(R.layout.items, parent, false);
        return new viewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        int radius = 40;

        ProductsItem data = productsItemList.get(position);

        Glide.with(mCtx)
                .load(data.getThumbnail())
                .centerCrop()
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(radius)))
                .into(holder.ivThumbnail);

        holder.tvName.setText(String.valueOf(data.getTitle()));

        holder.tvBrand.setText("Brand : "+ data.getBrand());

        holder.tvCategory.setText("Category : "+ data.getCategory());

        holder.tvPrice.setText("Price : $"+ data.getPrice());

        List<String> imageUrls = data.getImages();
        for (String imageUrl : imageUrls) {
            // Process each image URL
            System.out.println(imageUrl);
        }

    }

    @Override
    public int getItemCount() {
        return productsItemList.size();
    }



    public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView ivThumbnail;
        TextView tvName, tvBrand, tvCategory, tvPrice;



        public viewHolder(@NonNull View itemView) {
            super(itemView);

            ivThumbnail = itemView.findViewById(R.id.ivThumbnail);
            tvName = itemView.findViewById(R.id.tvName);
            tvBrand = itemView.findViewById(R.id.tvBrand);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            tvPrice = itemView.findViewById(R.id.tvPrice);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();

            ProductsItem data = productsItemList.get(position);
            List<String> imageUrls = data.getImages();


            if (position != RecyclerView.NO_POSITION) {

                Context context = v.getContext();

                Intent intent = new Intent(context, ProductActivity.class);
                intent.putExtra("productId", productsItemList.get(position).getId());

                // Add more product details to the intent if needed
                intent.putExtra("productName",productsItemList.get(position).getTitle());
                intent.putExtra("productImage",productsItemList.get(position).getThumbnail());
                intent.putExtra("productPrice",productsItemList.get(position).getPrice());
                intent.putExtra("productDescription",productsItemList.get(position).getDescription());
                intent.putStringArrayListExtra("imageUrls", new ArrayList<>(imageUrls));

                context.startActivity(intent);

            }
        }
    }

}
