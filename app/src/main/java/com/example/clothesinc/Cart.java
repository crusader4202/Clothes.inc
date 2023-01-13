package com.example.clothesinc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        CartList cartlist = CartList.getInstance();
        RecyclerView recyclerView = findViewById(R.id.cartRecycler);
        CartClothesAdapter cartClothesAdapter = new CartClothesAdapter(cartlist.getCartClothesList());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(cartClothesAdapter);

    }
}