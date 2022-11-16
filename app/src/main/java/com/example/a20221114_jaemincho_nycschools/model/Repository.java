package com.example.a20221114_jaemincho_nycschools.model;

import androidx.lifecycle.LiveData;

import com.example.a20221114_jaemincho_nycschools.model.presentation.PresentationData;


public interface Repository {
    LiveData<PresentationData> getCaseGetSchools();
    void  useCaseGetSchools();
}
