package com.example.newsapp.ui.fragments;

import static com.example.newsapp.utils.Constants.API_KEY;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.ModelResponseInJava.Article;
import com.example.newsapp.ModelResponseInJava.ModelResponse;
import com.example.newsapp.R;
import com.example.newsapp.adapter.NewsAdapter;
import com.example.newsapp.api.NewsInterface;
import com.example.newsapp.api.RetrofitBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TechnologyFragment extends Fragment {

    private RecyclerView rv;
    NewsAdapter adapter;
    List<Article> list;
    private ProgressDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_technology, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv = view.findViewById(R.id.newsRvTech);

        list = new ArrayList<>();
        adapter = new NewsAdapter(list, getContext());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setHasFixedSize(true);
        rv.setAdapter(adapter);
        progressDialog = ProgressDialog.show(getContext(), "Loading", "Please wait...", true);

        NewsInterface news = RetrofitBuilder.getNews();

        Call<ModelResponse> call = news.getNews("Technology", API_KEY);

        call.enqueue(new Callback<ModelResponse>() {
            @Override
            public void onResponse(Call<ModelResponse> call, Response<ModelResponse> response) {

                if (response != null && response.body() != null) {


                    /// recieve the data

                    ModelResponse mresponse = response.body();
                    List<Article> mlist = mresponse.getArticles();

                    list.addAll(mlist);
                    progressDialog.dismiss();
                    adapter.notifyDataSetChanged();


                }


            }

            @Override
            public void onFailure(Call<ModelResponse> call, Throwable t) {

            }
        });


    }
}