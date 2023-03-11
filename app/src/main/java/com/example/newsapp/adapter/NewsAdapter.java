package com.example.newsapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapp.ModelResponseInJava.Article;
import com.example.newsapp.R;
import com.example.newsapp.ui.activities.DetailsActivity;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {


    List<Article> list;
    Context context;

    public NewsAdapter(List<Article> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View listitem = layoutInflater.inflate(R.layout.itemnews, parent, false);
        RecyclerView.ViewHolder viewHolder = new MyViewHolder(listitem);
        return (MyViewHolder) viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Article marticle = list.get(position);

        holder.newsTitle.setText(marticle.getTitle());
        holder.newsSource.setText(marticle.getSource().getName());
        // share button
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context, DetailsActivity.class);
                i.putExtra("url", marticle.getUrl());
                context.startActivity(i);


            }
        });

        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//              implicit intent ...
                String myString = "Hello, i found this interesting news on NewsApp , \n check this out " + marticle.getUrl() + "  ";
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, myString);
                context.startActivity(Intent.createChooser(shareIntent, "Share via"));


            }
        });


        // image ...
        Glide.with(context).load(marticle.getUrlToImage()).into(holder.image);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        private ImageView image, btnShare;
        private TextView newsTitle, newsSource;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.ivItemNewsImage);
            btnShare = itemView.findViewById(R.id.btnItemShare);


            newsTitle = itemView.findViewById(R.id.tvItemNewsTitle);
            newsSource = itemView.findViewById(R.id.tvItemNewsSource);


        }
    }

}
