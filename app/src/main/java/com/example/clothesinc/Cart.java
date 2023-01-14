package com.example.clothesinc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        CartList cartlist = CartList.getInstance();
        RecyclerView recyclerView = findViewById(R.id.cartRecycler);
        CartClothesAdapter cartClothesAdapter = new CartClothesAdapter();
        cartClothesAdapter.addClothes(cartlist.getCartClothesList());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(cartClothesAdapter);


        spinnerInitialize();
    }

    private void spinnerInitialize(){
        Spinner pengirimanDropdown = findViewById(R.id.spinnerPengiriman);
        String[] pengiriman = new String[]{"Gojek", "JNE", "Grab express"};

        ArrayAdapter<String> adapterPengiriman = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, pengiriman);
        pengirimanDropdown.setAdapter(adapterPengiriman);
    }
}