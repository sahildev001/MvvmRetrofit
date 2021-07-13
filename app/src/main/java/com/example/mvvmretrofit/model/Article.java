package com.example.mvvmretrofit.model;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Article {

    @SerializedName("urlToImage")
    @Expose
    private String urlToImage;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("title")
    @Expose
    private String title;

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//
//     @Override
//    public String toString() {
//        return "BashboardNews{"+
//                "urlToImage =' "+ urlToImage + '\''+
//                ", description =' " +title+'\''+
//                '}';
//    }
}
