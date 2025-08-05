package com.example.stubdemo.dto;

import java.util.List;

public class ResponseWrapper {
    private List<ResponseItem> data;

    public ResponseWrapper(List<ResponseItem> data) {
        this.data = data;
    }

    public List<ResponseItem> getData() { return data; }
    public void setData(List<ResponseItem> data) { this.data = data; }
}