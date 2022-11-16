package com.example.a20221114_jaemincho_nycschools.model.presentation;

import com.example.a20221114_jaemincho_nycschools.model.Schools;

import java.util.List;

public class Success<T> extends PresentationData<T>{
    private List<Schools> dataSet;

    public List<Schools> getDataSet() {
        return dataSet;
    }

   public Success(List<Schools> dataSet){
        this.dataSet = dataSet;
   }
}
