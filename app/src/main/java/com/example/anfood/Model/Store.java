package com.example.anfood.Model;

public class Store {
    private int img;
    private String title;
    private double rating;
    private String vitri;


    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getVitri() {
        return vitri;
    }

    public void setVitri(String vitri) {
        this.vitri = vitri;
    }

    public Store(int img, String title, double rating, String vitri){
        this.img = img;
        this.title = title;
        this.rating = rating;
        this.vitri = vitri;
    }
}
