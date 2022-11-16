package com.example.a20221114_jaemincho_nycschools.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.a20221114_jaemincho_nycschools.model.presentation.Error;
import com.example.a20221114_jaemincho_nycschools.model.presentation.PresentationData;
import com.example.a20221114_jaemincho_nycschools.model.presentation.Success;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoryImpl implements Repository{
    private SchoolsApi service;
    private MutableLiveData<PresentationData> domainData;

    @Inject
    public RepositoryImpl(ApiClient client){
        service = client.getClient();
        domainData = new MutableLiveData<>();
    }

    @Override
    public LiveData<PresentationData> getCaseGetSchools() {
        return domainData;
    }

    @Override
    public void useCaseGetSchools() {
        getUseCase();
    }

    private void getUseCase(){
        service.getSchool().enqueue(
                new Callback<List<Schools>>() {
                    @Override
                    public void onResponse(Call<List<Schools>> call, Response<List<Schools>> response) {
                        updateResponse(response);
                    }

                    @Override
                    public void onFailure(Call<List<Schools>> call, Throwable t) {
                        updateError(t.getMessage());
                    }
                }
        );
    }

    private void updateError(String message) {
        domainData.setValue(new Error<String>(message));
    }

    private void updateResponse(Response<List<Schools>> response) {
        if (response.isSuccessful() && response.body() != null){
            domainData.setValue(new Success<List<Schools>>(response.body()));
        }else
            updateError(response.message());
    }
}
