package com.drinkapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.drinkapp.Database.ModelDb.Cart;
import com.drinkapp.R;
import com.drinkapp.Utils.Common;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder>{

    Context context;
    List<Cart> cartList;


    public CartAdapter(Context context, List<Cart> cartList) {
        this.context = context;
        this.cartList = cartList;
    }


    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.cart_layout_item, parent,false);
        return new CartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, final int position) {
        Picasso.with(context).load(cartList.get(position).link).into(holder.iv_cart_item_product_img);

        holder.tv_amount.setNumber(String.valueOf(cartList.get(position).amount));
        holder.tv_cart_item_product_price.setText(new StringBuilder("$").append(cartList.get(position).price));
        holder.tv_cart_item_product_name.setText(cartList.get(position).name);
        holder.tv_cart_item_product_sugar_ice.setText(new StringBuilder("Sugar: ")
            .append(cartList.get(position).sugar).append("%").append("\n")
            .append("Ice: ").append(cartList.get(position).ice).append("%").toString());

        holder.tv_amount.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                Cart cart = cartList.get(position);
                cart.amount = newValue;

                Common.cartRepository.updateCart(cart);
            }
        });

    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    class CartViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_cart_item_product_img;
        ElegantNumberButton tv_amount;
        TextView tv_cart_item_product_name,tv_cart_item_product_sugar_ice,tv_cart_item_product_price;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_cart_item_product_img = itemView.findViewById(R.id.iv_cart_item_product_img);
            tv_amount = itemView.findViewById(R.id.tv_amount);
            tv_cart_item_product_name = itemView.findViewById(R.id.tv_cart_item_product_name);
            tv_cart_item_product_sugar_ice = itemView.findViewById(R.id.tv_cart_item_product_sugar_ice);
            tv_cart_item_product_price = itemView.findViewById(R.id.tv_cart_item_product_price);
        }
    }
}
