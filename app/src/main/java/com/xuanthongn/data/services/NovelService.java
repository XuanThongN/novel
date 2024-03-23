package com.xuanthongn.data.services;

import com.xuanthongn.data.model.Novel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public class NovelService implements IGenericService<Novel> {
    private static final String ENDPOINT = "/novels";


    @Override
    @GET(ENDPOINT)
    public Call<List<Novel>> getList(String token) {
        return null;
    }

    @Override
    @POST(ENDPOINT)
    public Call<Novel> create(String token, Novel item) {
        return null;
    }

    @Override
    @POST(ENDPOINT)
    public Call<Novel> update(String token, Novel item) {
        return null;
    }

    @Override
    @POST(ENDPOINT)
    public Call<Void> delete(String token, Novel item) {
        return null;
    }
}
