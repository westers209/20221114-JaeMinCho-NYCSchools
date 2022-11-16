package com.example.a20221114_jaemincho_nycschools.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.a20221114_jaemincho_nycschools.model.Repository;
import com.example.a20221114_jaemincho_nycschools.model.presentation.PresentationData;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class SchoolsViewModel extends ViewModel {


    private Repository repository;
    public LiveData<PresentationData> data;

    @Inject
    public SchoolsViewModel(Repository repository){
        this.repository = repository;
        data = repository.getCaseGetSchools();
        init();
    }

    private void init(){
        repository.useCaseGetSchools();
    }
}
