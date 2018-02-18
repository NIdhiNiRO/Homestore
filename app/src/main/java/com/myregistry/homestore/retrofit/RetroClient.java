package com.myregistry.homestore.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nidhiparekh.
 */

public class RetroClient {

    //Base Api URL
    //I have used walmart public api for demo purpose
    public static final String BASE_URL = "http://api.walmartlabs.com/";
    private static RetroClient restClient;
    private ServiceAPI serviceApi;

    public static void CreateRetroClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);  // <-- this is the important line!
        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC);
        builder.excludeFieldsWithoutExposeAnnotation();
        Gson ExposeGson = builder.create();
        restClient = new RetroClient();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create(ExposeGson)).build();
        restClient.serviceApi = retrofit.create(ServiceAPI.class);
    }

    public static RetroClient getClient() {
        return restClient;
    }

    public static ServiceAPI getServiceApis() {
        return restClient.serviceApi;
    }
}
