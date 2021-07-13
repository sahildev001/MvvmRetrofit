package com.example.mvvmretrofit.Retrofit;

import com.example.mvvmretrofit.Response.ArticleResponse;

import retrofit2.Call;
import retrofit2.http.GET;

import static com.example.mvvmretrofit.constants.AppConstants.API_KEY;

public interface ApiRequest {

    @GET("top-headlines?country=us&apiKey="+API_KEY)
    Call<ArticleResponse> getTopHeadlines();

}
