package com.chel.sangwa_sytles.network;

import com.chel.sangwa_sytles.YelpBusinessesSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YelpApi {
    @GET("businesses/search")
    Call<YelpBusinessesSearchResponse> getMalls(
            @Query("location") String location,
            @Query("term") String term
    );
}
