package com.drinkapp.Database.Local;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.drinkapp.Database.ModelDb.Cart;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface CartDao {

    @Query("SELECT * FROM Cart")
    Flowable<List<Cart>> getCartItens();

    @Query("SELECT * FROM Cart WHERE id=:cartItemId")
    Flowable<List<Cart>> getCartItemById(int cartItemId);

    @Query("SELECT COUNT (*) FROM Cart")
    int countCartItens();

    @Query("DELETE FROM Cart")
    void emptyCart();

    @Insert
    void insertToCart(Cart...carts);

    @Update
    void updateCart(Cart...carts);

    @Delete
    void deleteCartItem(Cart cart);


}
