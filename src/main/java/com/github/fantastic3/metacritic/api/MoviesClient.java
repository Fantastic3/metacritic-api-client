package com.github.fantastic3.metacritic.api;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface MoviesClient {
    @GET("/find/movie")
    Call<Wrapper> find(@Query("title") String title);
}
