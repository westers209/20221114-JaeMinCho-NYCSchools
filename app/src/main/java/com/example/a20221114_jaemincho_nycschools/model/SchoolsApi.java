package com.example.a20221114_jaemincho_nycschools.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SchoolsApi {
    @GET("/resource/f9bf-2cp4.json")
    Call<List<Schools>> getSchool();
}
