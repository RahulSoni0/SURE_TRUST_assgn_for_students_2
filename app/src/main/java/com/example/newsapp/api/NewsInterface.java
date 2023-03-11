package com.example.newsapp.api;

import com.example.newsapp.ModelResponseInJava.ModelResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsInterface {


    // india
    @GET("everything")
    Call<ModelResponse> getNews(
            @Query("q") String q, // all the parameters....
            @Query("apiKey") String apikey

    );


//    @GET("everything")
//    Call<ModelResponse> getSports(
//            @Query("q") String q,
//            @Query("apiKey") String apikey
//
//    );
//
//    @GET("everything")
//    Call<ModelResponse> getTechnology(
//            @Query("q") String q,
//            @Query("apiKey") String apikey
//
//    );
//
//    @GET("everything")
//    Call<ModelResponse> getScience(
//            @Query("q") String q,
//            @Query("apiKey") String apikey
//
//    );
//
//    @GET("everything")
//    Call<ModelResponse> getPolitics(
//            @Query("q") String q,
//            @Query("apiKey") String apikey
//
//    );
//
//    @GET("everything")
//    Call<ModelResponse> getAp(
//            @Query("q") String q,
//            @Query("apiKey") String apikey
//
//    );


}
