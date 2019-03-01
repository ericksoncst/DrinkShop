package com.drinkapp.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.drinkapp.Interface.ItemClickListenner;
import com.drinkapp.R;

public class DrinkViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    ImageView iv_drink_product;
    TextView tv_drink_item_name,tv_drink_item_price;

    ItemClickListenner itemClickListenner;

    public void setItemClickListenner(ItemClickListenner itemClickListenner) {
        this.itemClickListenner = itemClickListenner;
    }

    public DrinkViewHolder(@NonNull View itemView) {
        super(itemView);

        iv_drink_product = itemView.findViewById(R.id.iv_drink_product);
        tv_drink_item_name = itemView.findViewById(R.id.tv_drink_item_name);
        tv_drink_item_price = itemView.findViewById(R.id.tv_drink_item_price);

        itemView.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        itemClickListenner.onClick(v);
    }
}
