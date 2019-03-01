package com.drinkapp.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.drinkapp.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    ImageView iv_product;
    TextView tv_menu_name;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);


        iv_product = itemView.findViewById(R.id.iv_product);
        tv_menu_name = itemView.findViewById(R.id.tv_menu_name);
    }
}
