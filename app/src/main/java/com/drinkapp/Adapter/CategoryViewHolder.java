package com.drinkapp.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.drinkapp.Interface.ItemClickListenner;
import com.drinkapp.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView iv_product;
    TextView tv_menu_name;

    ItemClickListenner itemClickListenner;

    public void setItemClickListenner(ItemClickListenner itemClickListenner) {
        this.itemClickListenner = itemClickListenner;
    }

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);


        iv_product = itemView.findViewById(R.id.iv_product);
        tv_menu_name = itemView.findViewById(R.id.tv_menu_name);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        itemClickListenner.onClick(v);
    }
}
