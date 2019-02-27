package com.drinkapp.Utils;

import com.drinkapp.Retrofit.IDrinkShopAPI;
import com.drinkapp.Retrofit.RetrofitClient;

public class Commom {

    //emulator localhost = 10.0.2.2
    private static final String BASE_URL = "http://192.168.0.5/drinkshop/";

    public static IDrinkShopAPI getApi() {
        return RetrofitClient.getClient(BASE_URL).create(IDrinkShopAPI.class);
    }
}

