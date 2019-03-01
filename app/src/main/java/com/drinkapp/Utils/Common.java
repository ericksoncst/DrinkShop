package com.drinkapp.Utils;

import com.drinkapp.Retrofit.IDrinkShopAPI;
import com.drinkapp.Retrofit.RetrofitClient;
import com.drinkapp.model.Category;
import com.drinkapp.model.User;

public class Common {

    //emulator localhost = 10.0.2.2
    private static final String BASE_URL = "http://192.168.0.5:80/drinkshop/";

    public static User currentUser = null;

    public static Category currentCategory = null;

    public static IDrinkShopAPI getApi() {
        return RetrofitClient.getClient(BASE_URL).create(IDrinkShopAPI.class);
    }
}

