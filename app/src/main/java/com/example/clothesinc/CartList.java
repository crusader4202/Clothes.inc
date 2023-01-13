package com.example.clothesinc;

import java.util.ArrayList;

public class CartList {
    private static CartList cartList = null;
    private ArrayList<CartClothes> cartClothesList;

    private CartList(){
        this.cartClothesList = new ArrayList<>();
    }

    public static CartList getInstance(){
        if(cartList == null){
            cartList = new CartList();
        }
        return cartList;
    }

    public void add(CartClothes cartClothes){
        this.cartClothesList.add(cartClothes);
    }

    public boolean checkCartClothesList(Clothes clothes){
        int temp = 0;
        if(this.cartClothesList.isEmpty()){
            return false;
        }
        for (CartClothes c : this.cartClothesList) {
            if(c.getClothes().getClothesTitle().equals(clothes.getClothesTitle())){
                temp = 1;
                break;
            }
        }
        if(temp == 1){
            return true;
        }
        return false;
    }

    public void addQuantity(Clothes clothes){
        for (CartClothes c : this.cartClothesList) {
            if(c.getClothes().getClothesTitle().equals(clothes.getClothesTitle())){
                c.setQuantity(c.getQuantity()+1);
                break;
            }
        }
    }
    
    public ArrayList<CartClothes> getCartClothesList() {
        return cartClothesList;
    }
}
