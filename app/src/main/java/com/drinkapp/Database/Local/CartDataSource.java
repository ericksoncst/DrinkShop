package com.drinkapp.Database.Local;

import com.drinkapp.Database.DataSource.ICartDataSource;
import com.drinkapp.Database.ModelDb.Cart;

import java.util.List;

import io.reactivex.Flowable;

public class CartDataSource implements ICartDataSource {

    private CartDao cartDao;
    private static CartDataSource instanse;

    public CartDataSource(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    public static CartDataSource getInstance(CartDao cartDao){
        if (instanse == null)
            instanse = new CartDataSource(cartDao);
        return instanse;
    }

    @Override
    public Flowable<List<Cart>> getCartItens() {
        return cartDao.getCartItens();
    }

    @Override
    public Flowable<List<Cart>> getCartItemById(int cartItemId) {
        return cartDao.getCartItemById(cartItemId);
    }

    @Override
    public int countCartItens() {
        return cartDao.countCartItens();
    }

    @Override
    public void emptyCart() {
        cartDao.emptyCart();
    }

    @Override
    public void insertToCart(Cart... carts) {
        cartDao.insertToCart(carts);
    }

    @Override
    public void updateCart(Cart... carts) {
        cartDao.updateCart(carts);
    }

    @Override
    public void deleteCartItem(Cart cart) {
        cartDao.deleteCartItem(cart);
    }
}
