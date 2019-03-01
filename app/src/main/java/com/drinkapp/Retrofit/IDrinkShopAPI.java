package com.drinkapp.Retrofit;

import com.drinkapp.model.Banner;
import com.drinkapp.model.CheckUserResponse;
import com.drinkapp.model.User;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IDrinkShopAPI {

    @FormUrlEncoded
    @POST("checkuser.php")
    Call<CheckUserResponse> checkUserExists(@Field("phone") String phone);

    @FormUrlEncoded
    @POST("register.php")
    Call<User> registerNewUser(@Field("phone") String phone,
                                       @Field("name") String name,
                                       @Field("birthdate") String birthdate,
                                       @Field("address") String address);

    @FormUrlEncoded
    @POST("getuser.php")
    Call<User> getUserInformation(@Field("phone") String phone);

    @GET("getbanners.php")
    Observable<List<Banner>> getBanners();

}
