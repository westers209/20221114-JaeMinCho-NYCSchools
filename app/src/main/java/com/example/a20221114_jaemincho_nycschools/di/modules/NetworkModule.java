package com.example.a20221114_jaemincho_nycschools.di.modules;

import com.example.a20221114_jaemincho_nycschools.model.ApiClient;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class NetworkModule {
    @Provides
    public ApiClient providesClient(){
        return new ApiClient();
    }
}
