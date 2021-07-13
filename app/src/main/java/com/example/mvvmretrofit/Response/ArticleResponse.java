package com.example.mvvmretrofit.Response;

import com.example.mvvmretrofit.model.Article;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArticleResponse {

        @SerializedName("articles")
        @Expose
    private List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

//    @Override
//    public String toString() {
//        return "BashboardNewsResponse{" +
//                "articles=" + articles +
//                '}';
//    }
}
