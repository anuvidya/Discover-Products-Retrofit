package com.example.retrofitproductslist.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.retrofitproductslist.R;
import com.example.retrofitproductslist.databinding.ActivityMainBinding;
import com.example.retrofitproductslist.model.ProductsItem;
import com.example.retrofitproductslist.model.ResponseItem;
import com.example.retrofitproductslist.viewmodel.viewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity  {

   ActivityMainBinding activityMainBinding;

    Adapter adapter;

    LinearLayoutManager layoutManager;

    ResponseItem responseItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        activityMainBinding.recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);

        activityMainBinding.recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        //viewModel instantiation
        viewModel model = new ViewModelProvider(this).get(viewModel.class);

        //observing a LiveData object in viewModel and ensures that whenever the data held by the LiveData object model.getItems() changes, the RecyclerView adapter is updated with the new data, and the UI is refreshed accordingly
        model.getItems().observe(this, new Observer<List<ProductsItem>>() {
            @Override
            public void onChanged(List<ProductsItem> productsItems) {

                adapter = new Adapter(MainActivity.this, productsItems);
                activityMainBinding.recyclerView.setAdapter(adapter);

            }

        });

    }
}