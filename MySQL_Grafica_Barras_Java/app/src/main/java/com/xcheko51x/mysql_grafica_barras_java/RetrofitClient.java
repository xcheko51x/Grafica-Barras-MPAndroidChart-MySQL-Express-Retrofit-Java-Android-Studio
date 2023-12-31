package com.xcheko51x.mysql_grafica_barras_java;

import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    static final String BASE_URL = "http://192.168.1.8:3000";

    Retrofit retrofit;

    public RetrofitClient() { }

    public Retrofit getRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .build();

        return retrofit;
    }
}
