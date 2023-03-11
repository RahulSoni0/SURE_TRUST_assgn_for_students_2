package com.example.newsapp.ModelResponseInJava;

import com.google.gson.annotations.SerializedName;

public class Article {


    @SerializedName("author")
    String writer;

    String content;
    String description;
    String publishedAt;
    Source source;
    String url;
    String title;
    String urlToImage;

    @Override
    public String toString() {
        return "Article{" +
                "writer='" + writer + '\'' +
                ", content='" + content + '\'' +
                ", description='" + description + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", source=" + source +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                '}';
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }
}
