package com.drinkapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.drinkapp.Adapter.CartAdapter;
import com.drinkapp.Database.ModelDb.Cart;
import com.drinkapp.R;
import com.drinkapp.Utils.Common;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CartActivity extends AppCompatActivity {

    RecyclerView rv_cart;
    Button btn_place_order;

    CompositeDisposable compositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        compositeDisposable = new CompositeDisposable();

        rv_cart = findViewById(R.id.rv_cart);
        rv_cart.setLayoutManager(new LinearLayoutManager(this));
        rv_cart.setHasFixedSize(true);

        btn_place_order = findViewById(R.id.btn_place_order);

        loadCartItens();
    }

    private void loadCartItens() {
        compositeDisposable.add(
                Common.cartRepository.getCartItens()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<List<Cart>>() {
                    @Override
                    public void accept(List<Cart> carts) throws Exception {
                        displayCartItens(carts);
                    }
                })
        );
    }

    private void displayCartItens(List<Cart> carts) {
        CartAdapter cartAdapter = new CartAdapter(this, carts);
        rv_cart.setAdapter(cartAdapter);
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }
}
