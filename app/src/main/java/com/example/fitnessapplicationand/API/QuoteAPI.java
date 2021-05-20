package com.example.fitnessapplicationand.API;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface QuoteAPI {
    @POST("?method=getQuote&key=457553&format=json&lang=en")
    Call<Quote> getQuote();
}
