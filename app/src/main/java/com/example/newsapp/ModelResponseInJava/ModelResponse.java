package com.example.newsapp.ModelResponseInJava;

import java.util.List;

public class ModelResponse {


    List<Article> articles;
    String status;
    int totalResults;

    @Override
    public String toString() {
        return "ModelResponse{" +
                "articles=" + articles +
                ", status='" + status + '\'' +
                ", totalResults=" + totalResults +
                '}';
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

//    val status: String,
//    val totalResults: Int
}
