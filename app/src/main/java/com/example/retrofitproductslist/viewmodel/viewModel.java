package com.example.retrofitproductslist.viewmodel;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrofitproductslist.model.ProductsItem;
import com.example.retrofitproductslist.model.ResponseItem;
import com.example.retrofitproductslist.view.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class viewModel extends ViewModel {

    private MutableLiveData<List<ProductsItem>> list;

    private int skip = 0;

    public LiveData<List<ProductsItem>> getItems(){

        if(list == null)
        {
            list = new MutableLiveData<List<ProductsItem>>();
            loadItems();
        }

        return  list;
    }

    private void loadItems() {

        //creating retrofit instance,using gsonconverter json response is converted to java objects
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.base_url).addConverterFactory(GsonConverterFactory.create()).build();

        Api api = retrofit.create(Api.class);

        Call<ResponseItem> call = api.getList();


        //asynctask success or error
        call.enqueue(new Callback<ResponseItem>() {
            @Override
            public void onResponse(Call<ResponseItem> call, Response<ResponseItem> response) {

                list.setValue(response.body().getProducts());

            }

            @Override
            public void onFailure(Call<ResponseItem> call, Throwable t) {

                Log.i(TAG,"failure"+t);

            }
        });
    }
}
