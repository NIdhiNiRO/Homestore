package com.myregistry.homestore.retrofit;

import com.myregistry.homestore.model.GetTrendItems;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by nidhiparekh.
 */

public interface ServiceAPI {

    @GET("v1/trends")
    Call<GetTrendItems> getTrendListing(@Query("format") String format, @Query("apikey") String apikey);

}
