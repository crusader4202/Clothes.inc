package com.example.clothesinc;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CartClothesViewHolder extends RecyclerView.ViewHolder {

    TextView clothesCartName, clothesCartBrand, clothesCartPrice, clothesCartQuantity;
    ImageView clothesCartImg;

    public CartClothesViewHolder(@NonNull View itemView) {
        super(itemView);
        clothesCartName = itemView.findViewById(R.id.clothesCartName);
        clothesCartBrand = itemView.findViewById(R.id.clothesCartBrand);
        clothesCartPrice = itemView.findViewById(R.id.clothesCartPrice);
        clothesCartQuantity = itemView.findViewById(R.id.clothesCartQuantity);
        clothesCartImg = itemView.findViewById(R.id.clothesCartImg);


    }
}
