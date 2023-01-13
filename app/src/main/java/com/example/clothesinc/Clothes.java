package com.example.clothesinc;

import java.io.Serializable;

public class Clothes implements Serializable {
    private String clothesTitle;
    private String clothesBrand;
    private String clothesPrice;
    private int clothesImg;

    public Clothes(String clothesTitle, String clothesBrand, String clothesPrice, int clothesImg) {
        this.clothesTitle = clothesTitle;
        this.clothesBrand = clothesBrand;
        this.clothesPrice = clothesPrice;
        this.clothesImg = clothesImg;
    }

    public String getClothesTitle() {
        return clothesTitle;
    }

    public void setClothesTitle(String clothesTitle) {
        this.clothesTitle = clothesTitle;
    }

    public String getClothesBrand() {
        return clothesBrand;
    }

    public void setClothesBrand(String clothesBrand) {
        this.clothesBrand = clothesBrand;
    }

    public String getClothesPrice() {
        return clothesPrice;
    }

    public void setClothesPrice(String clothesPrice) {
        this.clothesPrice = clothesPrice;
    }

    public int getClothesImg() {
        return clothesImg;
    }

    public void setClothesImg(int clothesImg) {
        this.clothesImg = clothesImg;
    }
}
