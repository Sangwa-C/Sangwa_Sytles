package com.chel.sangwa_sytles.networks;

import com.chel.sangwa_sytles.models.YelpBusinessesSearchResponse;

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
