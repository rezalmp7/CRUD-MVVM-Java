package com.rezalwp.training.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {
    public static ApiService getApiService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.6/ApiRezal/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService service =retrofit.create(ApiService.class);
        return service;
    }
}
