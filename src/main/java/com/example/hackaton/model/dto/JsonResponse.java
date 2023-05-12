package com.example.hackaton.model.dto;

import java.io.Serializable;

public class JsonResponse<T> implements Serializable {

    private T response;

    public JsonResponse(T s) {
        this.response = s;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
