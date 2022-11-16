package com.example.a20221114_jaemincho_nycschools.model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public final String BASE_URL = "https://data.cityofnewyork.us";
    private Retrofit retrofit = null;

    public SchoolsApi getClient(){
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(SchoolsApi.class);
    }
}
