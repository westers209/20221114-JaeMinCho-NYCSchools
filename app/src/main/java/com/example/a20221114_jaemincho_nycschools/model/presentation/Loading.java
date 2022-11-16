package com.example.a20221114_jaemincho_nycschools.model.presentation;

public class Loading<T> extends PresentationData<T> {
    private Boolean isLoading;

    public Boolean getLoading() {
        return isLoading;
    }

    public void setLoading(Boolean loading) {
        isLoading = loading;
    }
}
