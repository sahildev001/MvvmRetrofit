package com.example.mvvmretrofit.Repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvmretrofit.Response.ArticleResponse;
import com.example.mvvmretrofit.Retrofit.ApiRequest;
import com.example.mvvmretrofit.Retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleReposytry {


    private  static final String TAG = ArticleReposytry.class.getSimpleName();
    private final ApiRequest apiRequest;

    public  ArticleReposytry(){
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData<ArticleResponse> getDashBoardNews(){
        final MutableLiveData<ArticleResponse> data = new MutableLiveData<>();
        apiRequest.getTopHeadlines()
                .enqueue(new Callback<ArticleResponse>() {
                    @Override
                    public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {


                        if(response.body()!= null){
                            data.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticleResponse> call, Throwable t) {
                        data.setValue(null);

                    }
                });
        return data;
    }
}
