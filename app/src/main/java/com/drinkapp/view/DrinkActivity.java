  package com.drinkapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.drinkapp.Adapter.DrinkAdapter;
import com.drinkapp.R;
import com.drinkapp.Retrofit.IDrinkShopAPI;
import com.drinkapp.Utils.Common;
import com.drinkapp.model.Drink;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

  public class DrinkActivity extends AppCompatActivity {

    IDrinkShopAPI mService;

    RecyclerView lst_drink;

    TextView tv_drink_name;

    //RXJAVA
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        mService = Common.getApi();

        lst_drink = findViewById(R.id.rv_drink);
        lst_drink.setLayoutManager(new GridLayoutManager(this,2));
        lst_drink.setHasFixedSize(true);

        tv_drink_name = findViewById(R.id.tv_drink_name);
        tv_drink_name.setText(Common.currentCategory.name);

        loadDrinkList(Common.currentCategory.id);
    }

      private void loadDrinkList(String menuId) {
        compositeDisposable.add(mService.getDrink(menuId)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<List<Drink>>() {
            @Override
            public void accept(List<Drink> drinks) throws Exception {
                displayDrinkList(drinks);
            }
        }));
      }

      private void displayDrinkList(List<Drink> drinks) {
          DrinkAdapter adapter = new DrinkAdapter(this,drinks);
          lst_drink.setAdapter(adapter);
      }
  }
