package com.example.clothesinc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class ShopActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        ArrayList<Clothes> clothesList = new ArrayList<>();
        clothesList.add(new Clothes("Red Shirt", "ERIGO", "1000", R.drawable.red_shirts));
        clothesList.add(new Clothes("Red Shirt2", "ERIGO", "1000", R.drawable.red_shirts));
        clothesList.add(new Clothes("Red Shirt3", "ERIGO", "1000", R.drawable.red_shirts));
        clothesList.add(new Clothes("Red Shirt4", "ERIGO", "1000", R.drawable.red_shirts));
        clothesList.add(new Clothes("Red Shirt5", "ERIGO", "1000", R.drawable.red_shirts));
        clothesList.add(new Clothes("Red Shirt6", "ERIGO", "1000", R.drawable.red_shirts));
        clothesList.add(new Clothes("Red Shirt7", "ERIGO", "1000", R.drawable.red_shirts));
        clothesList.add(new Clothes("Red Shirt8", "ERIGO", "1000", R.drawable.red_shirts));
        clothesList.add(new Clothes("Red Shirt9", "ERIGO", "1000", R.drawable.red_shirts));
        clothesList.add(new Clothes("Red Shirt10", "ERIGO", "1000", R.drawable.red_shirts));
        clothesList.add(new Clothes("Red Shirt11", "ERIGO", "1000", R.drawable.red_shirts));
//
//
//
        RecyclerView shopList = findViewById(R.id.shopList);
        ClothesAdapter clothesAdapter = new ClothesAdapter(clothesList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        shopList.setLayoutManager(gridLayoutManager);
        shopList.setAdapter(clothesAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.cart:
                return true;
            case R.id.home:
                Intent homeActitivy = new Intent(ShopActivity.this, MainActivity.class);
                startActivity(homeActitivy);
                break;
            case R.id.wishlist:
                return true;
            case R.id.transaction:
                return true;
            case R.id.shop:
                return true;
            case R.id.settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}