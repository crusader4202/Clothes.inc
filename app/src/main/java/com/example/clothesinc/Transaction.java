package com.example.clothesinc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class Transaction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
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
                Intent cartActivity = new Intent(Transaction.this, Cart.class);
                startActivity(cartActivity);
                break;
            case R.id.home:
                Intent mainActivity = new Intent(Transaction.this, MainActivity.class);
                startActivity(mainActivity);
                return true;
            case R.id.transaction:
                return true;
            case R.id.shop:
                Intent shopActivity = new Intent(Transaction.this, ShopActivity.class);
                startActivity(shopActivity);
                break;
            case R.id.settings:
                ArrayList<User> user = (ArrayList<User>) getIntent().getSerializableExtra("myData");
                Intent settingsActivity = new Intent(Transaction.this, settings.class);
                settingsActivity.putExtra("myData", user);
                startActivity(settingsActivity);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}