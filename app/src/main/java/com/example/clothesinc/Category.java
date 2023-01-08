package com.example.clothesinc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Category extends AppCompatActivity {

    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        String categoryName = getIntent().getStringExtra("categoryName");
        textView = findViewById(R.id.categoryName);
        textView.setText(categoryName);
    }



}