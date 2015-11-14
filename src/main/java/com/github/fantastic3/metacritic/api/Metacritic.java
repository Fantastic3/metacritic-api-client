package com.github.fantastic3.metacritic.api;

import com.github.fantastic3.metacritic.Constants;
import com.squareup.okhttp.OkHttpClient;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;

public class Metacritic {
    private final OkHttpClient client;
    private final Retrofit     retrofit;

    private Metacritic(final OkHttpClient client) {
        this.client = client;
        this.retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl(Constants.BASE_URL)
                .build();
    }

    ;

    static Metacritic create(OkHttpClient client) {
        return new Metacritic(client);
    }


    public static interface MoviesClient {
        @GET("/find/movie")
        Call<Wrapper> find(@Query("title") String title);
    }

    public MoviesClient getMoviesClient() {
        return this.retrofit.create(MoviesClient.class);
    }

    public static void main(String[] args) throws Exception {
        OkHttpClient oc = new OkHttpClient();
        oc.interceptors().add(new HeadersInterceptor());
        oc.interceptors().add(new LoggingInterceptor());
        Metacritic metacritic = new Metacritic(oc);
        System.out.println(metacritic.getMoviesClient()
                                     .find("batman")
                                     .execute()
                                     .body().getResult().getName());
    }
}
