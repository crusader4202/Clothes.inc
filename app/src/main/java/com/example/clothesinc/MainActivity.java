package com.example.clothesinc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                return true;
            case R.id.wishlist:
                return true;
            case R.id.transaction:
                return true;
            case R.id.shop:
                Intent shopActivity = new Intent(MainActivity.this, ShopActivity.class);
                startActivity(shopActivity);
                break;
            case R.id.settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}