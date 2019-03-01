package com.drinkapp.Adapter;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.drinkapp.Interface.ItemClickListenner;
import com.drinkapp.R;
import com.drinkapp.model.Drink;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DrinkAdapter extends RecyclerView.Adapter<DrinkViewHolder> {

    Context context;
    List<Drink> drinkList;

    public DrinkAdapter(Context context, List<Drink> drinkList) {
        this.context = context;
        this.drinkList = drinkList;
    }

    @NonNull
    @Override
    public DrinkViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.drink_item_layout, null);

        return new DrinkViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkViewHolder holder, final int position) {

        holder.tv_drink_item_price.setText(new StringBuilder("$").append(drinkList.get(position).price).toString());
        holder.tv_drink_item_name.setText(drinkList.get(position).name);

        holder.btn_add_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddToCartDialog(position);
            }
        });

        Picasso.with(context)
                .load(drinkList.get(position).link)
                .into(holder.iv_drink_product);

        holder.setItemClickListenner(new ItemClickListenner() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showAddToCartDialog(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.add_to_cart_layout, null);

        ImageView iv_cart_product = itemView.findViewById(R.id.iv_cart_product);
        ElegantNumberButton tv_count = itemView.findViewById(R.id.tv_count);
        TextView tv_product_cart_name = itemView.findViewById(R.id.tv_product_cart_name);

        EditText tv_comment = itemView.findViewById(R.id.tv_comment);

        RadioButton rb_sizeM = itemView.findViewById(R.id.rb_sizeM);
        RadioButton rb_sizeL = itemView.findViewById(R.id.rb_sizeL);

        RadioButton rb_sugar_100 = itemView.findViewById(R.id.rb_sugar_100);
        RadioButton rb_sugar_70 = itemView.findViewById(R.id.rb_sugar_70);
        RadioButton rb_sugar_50 = itemView.findViewById(R.id.rb_sugar_50);
        RadioButton rb_sugar_30 = itemView.findViewById(R.id.rb_sugar_30);
        RadioButton rb_sugar_free = itemView.findViewById(R.id.rb_sugar_free);

        RadioButton rb_ice_100 = itemView.findViewById(R.id.rb_ice_100);
        RadioButton rb_ice_70 = itemView.findViewById(R.id.rb_ice_70);
        RadioButton rb_ice_50 = itemView.findViewById(R.id.rb_ice_50);
        RadioButton rb_ice_30 = itemView.findViewById(R.id.rb_ice_30);
        RadioButton rb_ice_free = itemView.findViewById(R.id.rb_ice_free);

        Picasso.with(context)
                .load(drinkList.get(position).link)
                .into(iv_cart_product);
        tv_product_cart_name.setText(drinkList.get(position).name);

        builder.setView(itemView);
        builder.setNegativeButton("ADD TO CART", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.show();
    }

    @Override
    public int getItemCount() {
        return drinkList.size();
    }
}
