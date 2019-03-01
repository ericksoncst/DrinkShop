package com.drinkapp.Retrofit;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit=null;
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    public static Retrofit getClient(String baseUrl){
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

}
