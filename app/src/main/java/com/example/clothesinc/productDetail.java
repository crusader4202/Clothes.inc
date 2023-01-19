package com.example.clothesinc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class productDetail extends AppCompatActivity implements Serializable {
    TextView clothesName, clothesBrand, clothesPrice;
    ImageView clothesImg;
    Button addToCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        Clothes clothes = (Clothes) getIntent().getSerializableExtra("clothesObject");
        clothesName = findViewById(R.id.productName);
        clothesBrand = findViewById(R.id.productBrand);
        clothesPrice = findViewById(R.id.productPriceDetail);
        clothesImg = findViewById(R.id.productImage);
        addToCart = findViewById(R.id.addToCartButton);
        clothesName.setText(clothes.getClothesTitle());
        clothesBrand.setText(clothes.getClothesBrand());
        clothesPrice.setText(clothes.getClothesPrice());
        clothesImg.setImageResource(clothes.getClothesImg());

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CartList cartList = CartList.getInstance();
                if(cartList.checkCartClothesList(clothes)){
                    cartList.addQuantity(clothes);
                }
                else{
                    cartList.addClothesList(clothes);
                }
            }
        });

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
                Intent cartActivity = new Intent(productDetail.this, Cart.class);
                startActivity(cartActivity);
                break;
            case R.id.home:
                Intent homeActitivy = new Intent(productDetail.this, MainActivity.class);
                startActivity(homeActitivy);
                break;
            case R.id.transaction:
                Intent transactionActivity = new Intent(productDetail.this, Transaction.class);
                startActivity(transactionActivity);
                return true;
            case R.id.shop:
                Intent shopActivity = new Intent(productDetail.this, ShopActivity.class);
                startActivity(shopActivity);
                break;
            case R.id.settings:
                Intent settingActivity = new Intent(productDetail.this, settings.class);
                startActivity(settingActivity);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}