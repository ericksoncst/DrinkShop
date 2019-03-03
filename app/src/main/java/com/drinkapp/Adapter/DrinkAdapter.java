package com.drinkapp.Adapter;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.drinkapp.Database.ModelDb.Cart;
import com.drinkapp.Interface.ItemClickListenner;
import com.drinkapp.R;
import com.drinkapp.Utils.Common;
import com.drinkapp.model.Drink;
import com.google.gson.Gson;
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

    private void showAddToCartDialog(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.add_to_cart_layout, null);

        ImageView iv_cart_product = itemView.findViewById(R.id.iv_cart_product);
        final ElegantNumberButton tv_count = itemView.findViewById(R.id.tv_count);
        TextView tv_product_cart_name = itemView.findViewById(R.id.tv_product_cart_name);

        final EditText tv_comment = itemView.findViewById(R.id.tv_comment);

        RadioButton rb_sizeM = itemView.findViewById(R.id.rb_sizeM);
        RadioButton rb_sizeL = itemView.findViewById(R.id.rb_sizeL);

        rb_sizeM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.sizeOfCup = 0;
            }
        });

        rb_sizeL.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.sizeOfCup = 1;
            }
        });

        RadioButton rb_sugar_100 = itemView.findViewById(R.id.rb_sugar_100);
        RadioButton rb_sugar_70 = itemView.findViewById(R.id.rb_sugar_70);
        RadioButton rb_sugar_50 = itemView.findViewById(R.id.rb_sugar_50);
        RadioButton rb_sugar_30 = itemView.findViewById(R.id.rb_sugar_30);
        RadioButton rb_sugar_free = itemView.findViewById(R.id.rb_sugar_free);

        rb_sugar_30.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.sugar = 30;
            }
        });

        rb_sugar_50.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.sugar = 50;
            }
        });

        rb_sugar_70.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.sugar = 70;
            }
        });

        rb_sugar_100.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.sugar = 100;
            }
        });

        rb_sugar_free.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.sugar = 0;
            }
        });

        RadioButton rb_ice_100 = itemView.findViewById(R.id.rb_ice_100);
        RadioButton rb_ice_70 = itemView.findViewById(R.id.rb_ice_70);
        RadioButton rb_ice_50 = itemView.findViewById(R.id.rb_ice_50);
        RadioButton rb_ice_30 = itemView.findViewById(R.id.rb_ice_30);
        RadioButton rb_ice_free = itemView.findViewById(R.id.rb_ice_free);

        rb_ice_30.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.ice = 30;
            }
        });

        rb_ice_50.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.ice = 50;
            }
        });

        rb_ice_70.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.ice = 70;
            }
        });

        rb_ice_100.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.ice = 100;
            }
        });

        rb_ice_free.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.ice = 0;
            }
        });

        RecyclerView rv_topping = itemView.findViewById(R.id.rv_topping);
        rv_topping.setLayoutManager(new LinearLayoutManager(context));
        rv_topping.setHasFixedSize(true);

        MultiChoiceAdapter adapter = new MultiChoiceAdapter(context, Common.toppingList);
        rv_topping.setAdapter(adapter);

        Picasso.with(context)
                .load(drinkList.get(position).link)
                .into(iv_cart_product);
        tv_product_cart_name.setText(drinkList.get(position).name);

        builder.setView(itemView);
        builder.setNegativeButton("ADD TO CART", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (Common.sizeOfCup == -1) {
                    Toast.makeText(context, "Please choose your size cup", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (Common.sugar == -1) {
                    Toast.makeText(context, "Please choose sugar", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (Common.ice == -1) {
                    Toast.makeText(context, "Please choose ice", Toast.LENGTH_SHORT).show();
                    return;
                }

                showConfirmDialog(position, tv_count.getNumber());
                dialog.dismiss();
            }
        });

        builder.show();
    }

    private void showConfirmDialog(int position, final String number) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.confirm_add_to_cart_layout, null);

        ImageView iv_confirm_product = itemView.findViewById(R.id.iv_confirm_product);
        final TextView tv_product_confirm_name = itemView.findViewById(R.id.tv_product_confirm_name);
        TextView tv_product_confirm_price = itemView.findViewById(R.id.tv_product_confirm_price);
        TextView tv_sugar = itemView.findViewById(R.id.tv_sugar);
        TextView tv_ice = itemView.findViewById(R.id.tv_ice);
        final TextView tv_topping_extras = itemView.findViewById(R.id.tv_topping_extras);

        Picasso.with(context).load(drinkList.get(position).link).into(iv_confirm_product);
        tv_product_confirm_name.setText(new StringBuilder(drinkList.get(position).name).append(" x")
        .append(number)
        .append(Common.sizeOfCup == 0 ? "Size M" : "Size L").toString());

        tv_ice.setText(new StringBuilder("Ice: ").append(Common.ice).append("%").toString());
        tv_sugar.setText(new StringBuilder("Sugar: ").append(Common.sugar).append("%").toString());

        double price = (Double.parseDouble(drinkList.get(position).price)* Double.parseDouble(number)) + Common.toppingPrice;

        if (Common.sizeOfCup == 1)
            price+=3.0;

        tv_product_confirm_price.setText(new StringBuilder("$").append(price));

        StringBuilder topping_final_comment = new StringBuilder("");
        for(String line: Common.toppingAdded)
            topping_final_comment.append(line).append("\n");

        tv_topping_extras.setText(topping_final_comment);

        final double finalPrice = price;
        builder.setNegativeButton("CONFIRM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();

                try {

                    Cart cartItem = new Cart();
                    cartItem.name = tv_product_confirm_name.getText().toString();
                    cartItem.amount = Integer.parseInt(number);
                    cartItem.ice = Common.ice;
                    cartItem.sugar = Common.sugar;
                    cartItem.price = finalPrice;
                    cartItem.toppingExtras = tv_topping_extras.getText().toString();

                    Common.cartRepository.insertToCart(cartItem);

                    Log.d("DEBUUUUUUG", new Gson().toJson(cartItem));

                    Toast.makeText(context, "Item Saved Successfully", Toast.LENGTH_SHORT).show();

                } catch(Exception e) {
                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                }


            }
        });

        builder.setView(itemView);
        builder.show();
    }


    @Override
    public int getItemCount() {
        return drinkList.size();
    }
}
