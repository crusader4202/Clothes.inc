package com.example.clothesinc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class ShopActivity extends AppCompatActivity  {

    ClothesAdapter clothesAdapter;
    ArrayList<Clothes> clothesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        clothesList = new ArrayList<>();
        clothesList.add(new Clothes("Red Shirt", "ERIGO", "1000", R.drawable.red_shirts));
        clothesList.add(new Clothes("Ocean Long Sleeve", "Nevada", "5000", R.drawable.blue_long_sleeve));
        clothesList.add(new Clothes("White Shirt", "Nevada", "3000", R.drawable.white_shirt));
        clothesList.add(new Clothes("NBA Polo Shirt", "Uniqlo", "1500", R.drawable.nba_polo));
        clothesList.add(new Clothes("Maroon Polo", "Chanel", "6000", R.drawable.polo_maroon));
        clothesList.add(new Clothes("Security Black", "Uniqlo", "5400", R.drawable.security_polo));
        clothesList.add(new Clothes("Red Tennis Polo", "Chanel", "2200", R.drawable.red_tennis_polo));
        clothesList.add(new Clothes("Green Mix Polo", "Levi's", "3500", R.drawable.green_mix_polo));
        clothesList.add(new Clothes("Moonchild Shirt", "Levi's", "4400", R.drawable.moonchild_shirt));
        clothesList.add(new Clothes("Onyx Long Sleeve", "Balenciaga", "9000", R.drawable.onyx_long_sleeve));
        clothesList.add(new Clothes("Collar Woman Polo", "Balenciaga", "8000", R.drawable.collar_tennis_polo));
        clothesList.add(new Clothes("Sparty Sleeve", "Duke", "9500", R.drawable.sparty_sleeve));

//
//
        RecyclerView shopList = findViewById(R.id.shopList);
        clothesAdapter = new ClothesAdapter(clothesList, ShopActivity.this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        shopList.setLayoutManager(gridLayoutManager);
        shopList.setAdapter(clothesAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.shop_menu, menu);

        MenuItem searchClothes = menu.findItem(R.id.searchClothes);

        SearchView searchView = (SearchView) searchClothes.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filterClothes(s);
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.cart:
                Intent cartActivity = new Intent(ShopActivity.this, Cart.class);
                startActivity(cartActivity);
                return true;
            case R.id.home:
                Intent homeActitivy = new Intent(ShopActivity.this, MainActivity.class);
                startActivity(homeActitivy);
                break;
            case R.id.transaction:
                Intent transactionActivity = new Intent(ShopActivity.this, Transaction.class);
                startActivity(transactionActivity);
                return true;
            case R.id.shop:
                return true;
            case R.id.settings:
                Intent settingActivity = new Intent(ShopActivity.this, settings.class);
                startActivity(settingActivity);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void filterClothes(String s){
        ArrayList<Clothes> filterClothesList = new ArrayList<>();
        for(Clothes clothes : clothesList){
            if(clothes.getClothesTitle().toLowerCase().contains(s.toLowerCase())){
                filterClothesList.add(clothes);
            }
        }
        if (!filterClothesList.isEmpty()) {
            clothesAdapter.filterClothes(filterClothesList);
        }
    }

}