package com.example.kingofread;

public class Book {
    private String title;
    private String descriptions;
    private Integer cover;
    private int favStatus;


    public Book(String title, String descriptions, Integer cover, int favStatus) {
        this.title = title;
        this.descriptions = descriptions;
        this.cover = cover;
        this.favStatus = favStatus;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Integer getCover() {
        return cover;
    }

    public void setCover(Integer cover) {
        this.cover = cover;
    }
    public int getFavStatus() {
        return favStatus;
    }

    public void setFavStatus(int favStatus) {
        this.favStatus = favStatus;
    }
}
