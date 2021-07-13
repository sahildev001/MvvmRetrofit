package com.example.mvvmretrofit.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.mvvmretrofit.Adapter.ArticleAdapter;
import com.example.mvvmretrofit.R;
import com.example.mvvmretrofit.model.Article;
import com.example.mvvmretrofit.view_model.ArticleViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recycler_view;
    private ProgressBar progress_bar;

    private LinearLayoutManager linearLayoutManager;
    private ArrayList<Article> articleArrayList = new ArrayList<>();
    ArticleViewModel articleViewModel;
    private ArticleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        getArticles();


    }

    private void getArticles() {
        articleViewModel.getBashBoardNewsLiveData().observe(this,articleResponse -> {
            if(articleResponse != null && articleResponse.getArticles()!=null
            && !articleResponse.getArticles().isEmpty()){
                progress_bar.setVisibility(View.GONE);
                List<Article> articleList = articleResponse.getArticles();
                articleArrayList.addAll(articleList);
                adapter.notifyDataSetChanged();
            }
        });

    }//end getArticle

    private void init() {

        progress_bar = findViewById(R.id.progressBar);
        recycler_view = findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        recycler_view.setLayoutManager(linearLayoutManager);
        recycler_view.setHasFixedSize(true);
        adapter = new ArticleAdapter(MainActivity.this,articleArrayList);
        recycler_view.setAdapter(adapter);
        articleViewModel = new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(ArticleViewModel.class);



    }

  
}