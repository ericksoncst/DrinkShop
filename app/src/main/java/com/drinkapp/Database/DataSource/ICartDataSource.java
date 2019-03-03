package com.drinkapp.Database.DataSource;

import com.drinkapp.Database.ModelDb.Cart;

import java.util.List;

import io.reactivex.Flowable;

public interface ICartDataSource {

    Flowable<List<Cart>> getCartItens();
    Flowable<List<Cart>> getCartItemById(int cartItemId);
    int countCartItens();
    void emptyCart();
    void insertToCart(Cart...carts);
    void updateCart(Cart...carts);
    void deleteCartItem(Cart cart);

}
