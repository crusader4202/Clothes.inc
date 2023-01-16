package com.example.clothesinc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageSliderAdapter imageSliderAdapter;
    List<Slider> sliderData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderData = new ArrayList<>();
        setData();
        setAdapter();
    }

    private void setAdapter() {
        recyclerView = findViewById(R.id.recyclerViewImageSlider);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));
        imageSliderAdapter = new ImageSliderAdapter(this, sliderData);
        recyclerView.setAdapter(imageSliderAdapter);

        final int interval_time = 3000;
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int count = 0;
            @Override
            public void run() {
                if(count<sliderData.size()){
                    recyclerView.scrollToPosition(count++);
                    handler.postDelayed(this,interval_time);
                    if(count==sliderData.size()){
                        count=0;
                    }
                }
            }
        };
        handler.postDelayed(runnable,interval_time);
    }

    private void setData() {
        sliderData.add(new Slider("https://www.masterclass.com/cdn-cgi/image/width=1920,quality=75,format=webp/https://images.ctfassets.net/3s5io6mnxfqz/3N5iXB8yNlqVQS3xWdIIgX/fa0d654680fbd64eb5852dbbbcf4cca4/AdobeStock_303371265.jpeg",""));
        sliderData.add(new Slider("https://www.telegraph.co.uk/content/dam/family/2022/11/01/TELEMMGLPICT000314735064_trans_NvBQzQNjv4Bq-LJS7LKjeK9Zr8QxHnNHGwpwjfeuChtHUoe9wtZBhk8.jpeg?imwidth=680",""));
        sliderData.add(new Slider("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSLpz0jACzVX8WR5S4MCz7Zc5_D4K4U-3p92g&usqp=CAU",""));
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
                Intent cartActivity = new Intent(MainActivity.this, Cart.class);
                startActivity(cartActivity);
                break;
            case R.id.home:
                return true;
            case R.id.transaction:
                return true;
            case R.id.shop:
                Intent shopActivity = new Intent(MainActivity.this, ShopActivity.class);
                startActivity(shopActivity);
                break;
            case R.id.settings:
                ArrayList<User> user = (ArrayList<User>) getIntent().getSerializableExtra("myData");
                Intent settingsActivity = new Intent(MainActivity.this, settings.class);
                settingsActivity.putExtra("myData", user);
                startActivity(settingsActivity);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void categoryWoman(View view) {
        Intent category = new Intent(this, Category.class);
        category.putExtra("categoryName", "Woman");
        startActivity(category);
    }

    public void categoryMan(View view) {
        Intent category = new Intent(this, Category.class);
        category.putExtra("categoryName", "Man");
        startActivity(category);
    }

    public void categoryAll(View view) {
        Intent category = new Intent(this, Category.class);
        category.putExtra("categoryName", "All");
        startActivity(category);
    }
}