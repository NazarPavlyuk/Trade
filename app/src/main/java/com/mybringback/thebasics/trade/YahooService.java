package com.mybringback.thebasics.trade;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ALLO on 25.06.2016.
 */
public interface YahooService {
    @GET("/rss/headline")
    Call<List<Headline>> symbolHeadlines(
            @Query("s") String headline);
}
