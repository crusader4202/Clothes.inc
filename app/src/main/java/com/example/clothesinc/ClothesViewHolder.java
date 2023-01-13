package com.example.clothesinc;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ClothesViewHolder extends RecyclerView.ViewHolder{

    TextView clothesBrandView, clothesNameView, clothesPriceView;
    ImageView clothesImgView;
    Clothes clothes;
    public ClothesViewHolder(@NonNull View itemView) {
        super(itemView);
        clothesNameView = itemView.findViewById(R.id.clothesNameView);
        clothesBrandView = itemView.findViewById(R.id.clothesBrandView);
        clothesPriceView = itemView.findViewById(R.id.clothesPriceView);
        clothesImgView = itemView.findViewById(R.id.clothesImgView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), productDetail.class);
                i.putExtra("clothesObject", clothes);
                view.getContext().startActivity(i);

            }
        });
    }
}
