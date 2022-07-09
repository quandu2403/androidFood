package com.example.anfood.Model;

public class Store {
    private int img;
    private String title;
    private double rating;
    private String vitri;
    private String country;


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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Store(String country, String title, String vitri, double rating, int img){
        this.country = country;
        this.vitri = vitri;
        this.title = title;
        this.rating = rating;
        this.img = img;
    }

}
