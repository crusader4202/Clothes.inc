package com.example.clothesinc;

import java.io.Serializable;

public class CartClothes implements Serializable {
    private Clothes clothes;
    private int quantity;

    public CartClothes(Clothes clothes, int quantity) {
        this.clothes = clothes;
        this.quantity = quantity;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
