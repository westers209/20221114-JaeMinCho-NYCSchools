package com.example.a20221114_jaemincho_nycschools.model.presentation;

public class Error<T> extends PresentationData<T>{
    private T errorMessage;

    public Error(T errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getErrorMessage() {
        return errorMessage;
    }
}
