package com.example.retrofitproductslist.view;

import com.example.retrofitproductslist.model.ResponseItem;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    String base_url = "https://dummyjson.com/";

    //Retrofit annotation that indicates that the method will perform an HTTP GET request.
    //"products" -  endpoint,represents the path to the resource you want to access on the server.
    @GET("products")
    Call<ResponseItem> getList();







}
