package com.example.a20221114_jaemincho_nycschools.di.modules;

import com.example.a20221114_jaemincho_nycschools.model.ApiClient;
import com.example.a20221114_jaemincho_nycschools.model.Repository;
import com.example.a20221114_jaemincho_nycschools.model.RepositoryImpl;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RepositoryModule {
    @Provides
    public Repository providesRepository(ApiClient client){
        return new RepositoryImpl(client);
    }
}
