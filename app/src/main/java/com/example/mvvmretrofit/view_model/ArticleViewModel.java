package com.example.mvvmretrofit.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mvvmretrofit.Repository.ArticleReposytry;
import com.example.mvvmretrofit.Response.ArticleResponse;

public class ArticleViewModel extends AndroidViewModel {

    private ArticleReposytry articleReposytry;
    private LiveData<ArticleResponse> articleResponseLiveData;

    public ArticleViewModel(@NonNull Application application) {
        super(application);
        this.articleReposytry = new ArticleReposytry();
        this.articleResponseLiveData = articleReposytry.getDashBoardNews();
    }

    public LiveData<ArticleResponse> getBashBoardNewsLiveData(){
        return articleResponseLiveData;
    }
}
