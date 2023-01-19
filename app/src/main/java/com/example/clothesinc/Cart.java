package com.example.clothesinc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        TextView emptyView = findViewById(R.id.emptyView);

        CartList cartlist = CartList.getInstance();
        RecyclerView recyclerView = findViewById(R.id.cartRecycler);
        CartClothesAdapter cartClothesAdapter = new CartClothesAdapter();
        cartClothesAdapter.addClothes(cartlist.getCartClothesList());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(cartClothesAdapter);

        // Check recycler view is empty
        if(cartlist.getCartClothesList().isEmpty()){
            recyclerView.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
            findViewById(R.id.totalPrice).setVisibility(View.GONE);
            findViewById(R.id.totalPriceText).setVisibility(View.GONE);
            findViewById(R.id.pengiriman).setVisibility(View.GONE);
            findViewById(R.id.spinnerPengiriman).setVisibility(View.GONE);
            findViewById(R.id.checkOutButton).setVisibility(View.GONE);

        }else{
            recyclerView.setVisibility(View.VISIBLE);
            findViewById(R.id.totalPrice).setVisibility(View.VISIBLE);
            findViewById(R.id.totalPriceText).setVisibility(View.VISIBLE);
            findViewById(R.id.pengiriman).setVisibility(View.VISIBLE);
            findViewById(R.id.spinnerPengiriman).setVisibility(View.VISIBLE);
            findViewById(R.id.checkOutButton).setVisibility(View.VISIBLE);
            emptyView.setVisibility(View.GONE);
        }



        calculateTotalPrice(cartlist.getCartClothesList());
        spinnerInitialize();
    }

    private void spinnerInitialize(){
        Spinner pengirimanDropdown = findViewById(R.id.spinnerPengiriman);
        String[] pengiriman = new String[]{"Gojek", "JNE", "Grab express"};

        ArrayAdapter<String> adapterPengiriman = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, pengiriman);
        pengirimanDropdown.setAdapter(adapterPengiriman);
    }

    private void calculateTotalPrice(ArrayList<CartClothes> cartClothesList){
        int totalPrice = 0;
        for (CartClothes c: cartClothesList) {
            totalPrice += (Integer.parseInt(c.getClothes().getClothesPrice()) * c.getQuantity());
        }
        TextView textTotalPrice = findViewById(R.id.totalPrice);
        textTotalPrice.setText("" + totalPrice);
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
                break;
            case R.id.home:
                Intent mainActivity = new Intent(Cart.this, MainActivity.class);
                startActivity(mainActivity);
                return true;
            case R.id.transaction:
                Intent transactionActivity = new Intent(Cart.this, Transaction.class);
                startActivity(transactionActivity);
                return true;
            case R.id.shop:
                Intent shopActivity = new Intent(Cart.this, ShopActivity.class);
                startActivity(shopActivity);
                break;
            case R.id.settings:
                ArrayList<User> user = (ArrayList<User>) getIntent().getSerializableExtra("myData");
                Intent settingsActivity = new Intent(Cart.this, settings.class);
                settingsActivity.putExtra("myData", user);
                startActivity(settingsActivity);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}