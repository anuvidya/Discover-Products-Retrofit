package com.example.retrofitproductslist.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.retrofitproductslist.R;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvName,tvDescription,tvPrice,tvAdd;
    ImageView ivBack;

    private List<String> images = new ArrayList<>();

    ViewPager2 viewPager2;

    LinearLayout layoutPagination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        Intent intent = getIntent();

        // Retrieve data from the Intent extras
        if (intent != null) {


            String productId = intent.getStringExtra("productId");
            String productName = intent.getStringExtra("productName");
            String productImage = intent.getStringExtra("productImage");
            String productPrice = intent.getStringExtra("productPrice");
            String productDescription = intent.getStringExtra("productDescription");

            List<String> imageUrls = getIntent().getStringArrayListExtra("imageUrls");

            tvName = findViewById(R.id.tvItem);
            tvDescription = findViewById(R.id.tvDescription);
            tvPrice = findViewById(R.id.tvCost);
            tvAdd = findViewById(R.id.tvAdd);
            ivBack = findViewById(R.id.ivBack);
            layoutPagination = findViewById(R.id.layoutPagination);


            tvName.setText(productName);
            tvDescription.setText(productDescription);
            tvPrice.setText("Price : $"+productPrice);

            // Set up ViewPager2
            viewPager2 = findViewById(R.id.viewPager2);

            ImagePagerAdapter adapter = new ImagePagerAdapter(this, imageUrls);
            viewPager2.setAdapter(adapter);

            //Function for getting count and keeping indicators according to the count
            setupPaginationIndicators();


            viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                @Override
                public void onPageSelected(int position) {
                    super.onPageSelected(position);

                    //Function for highlighting indicators
                    updatePaginationIndicator(position);
                }
            });

        }

        ivBack.setOnClickListener(this);
    }

    private void setupPaginationIndicators() {

        int pageCount = viewPager2.getAdapter().getItemCount();
        for (int i = 0; i < pageCount; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.drawable.circle);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            layoutParams.setMargins(8, 0, 8, 0); // Adjust margins as needed
            imageView.setLayoutParams(layoutParams);

            layoutPagination.addView(imageView);
        }

    }

    private void updatePaginationIndicator(int position) {
        for (int i = 0; i < layoutPagination.getChildCount(); i++) {
            ImageView imageView = (ImageView) layoutPagination.getChildAt(i);
            imageView.setImageResource(i == position ? R.drawable.selected_circle : R.drawable.circle);
        }
    }



    @Override
    public void onClick(View view) {

        //method in Android is used to close the current activity and return to the previous activity in the back stack
        finish();
    }
}