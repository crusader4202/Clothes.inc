package com.example.clothesinc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartClothesAdapter extends RecyclerView.Adapter<CartClothesViewHolder> {

    ArrayList<CartClothes> cartClothes;

    public CartClothesAdapter() {
        this.cartClothes = new ArrayList<>();
    }

    @NonNull
    @Override
    public CartClothesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View cartClothesItemView = layoutInflater.inflate(R.layout.clothes_cart_view, parent,false);
        CartClothesViewHolder cartClothesViewHolder = new CartClothesViewHolder(cartClothesItemView);

        return cartClothesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartClothesViewHolder holder, int position) {
        holder.clothesCartName.setText(cartClothes.get(position).getClothes().getClothesTitle());
        holder.clothesCartBrand.setText(cartClothes.get(position).getClothes().getClothesBrand());
        holder.clothesCartPrice.setText(cartClothes.get(position).getClothes().getClothesPrice());
        holder.clothesCartQuantity.setText(cartClothes.get(position).getQuantity());
        holder.clothesCartImg.setImageResource(cartClothes.get(position).getClothes().getClothesImg());

    }

    @Override
    public int getItemCount() {
        return cartClothes.size();
    }

    public void addClothes(ArrayList<CartClothes> cartClothesList) {
        this.cartClothes = cartClothesList;
        notifyDataSetChanged();
    }
}
