package com.example.clothesinc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ClothesAdapter extends RecyclerView.Adapter<ClothesViewHolder> {

    ArrayList<Clothes> clothesList = new ArrayList<>();

    public ClothesAdapter(ArrayList<Clothes> clothesList, Context context){
        this.clothesList = clothesList;
    }

    @NonNull
    @Override
    public ClothesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View clothesItemView = layoutInflater.inflate(R.layout.clothes_item_view, parent, false);
        ClothesViewHolder clothesViewHolder = new ClothesViewHolder(clothesItemView);
        return clothesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ClothesViewHolder holder, int position) {
        holder.clothes = clothesList.get(position);
        holder.clothesNameView.setText(clothesList.get(position).getClothesTitle());
        holder.clothesBrandView.setText(clothesList.get(position).getClothesBrand());
        holder.clothesPriceView.setText(clothesList.get(position).getClothesPrice());
        holder.clothesImgView.setImageResource(clothesList.get(position).getClothesImg());

    }

    @Override
    public int getItemCount() {
        return clothesList.size();
    }

    public void filterClothes(ArrayList<Clothes> filterClothesList) {
        this.clothesList = filterClothesList;
        notifyDataSetChanged();
    }


}
