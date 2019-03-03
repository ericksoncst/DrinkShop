package com.drinkapp.Utils;

import com.drinkapp.Retrofit.IDrinkShopAPI;
import com.drinkapp.Retrofit.RetrofitClient;
import com.drinkapp.model.Category;
import com.drinkapp.model.Drink;
import com.drinkapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class Common {

    //emulator localhost = 10.0.2.2
    private static final String BASE_URL = "http://192.168.0.5:80/drinkshop/";

    public static User currentUser = null;
    public static Category currentCategory = null;


    public static List<Drink> toppingList = new ArrayList<>();
    public static final String TOPPING_MENU_ID = "7";
    public static double toppingPrice = 0.0;
    public static List<String> toppingAdded = new ArrayList<>();
    public static int sizeOfCup = -1;
    public static int ice = -1;
    public static int sugar = -1;

    public static IDrinkShopAPI getApi() {
        return RetrofitClient.getClient(BASE_URL).create(IDrinkShopAPI.class);
    }
}

