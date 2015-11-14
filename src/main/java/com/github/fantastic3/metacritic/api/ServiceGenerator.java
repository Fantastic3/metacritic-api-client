package com.github.fantastic3.metacritic.api;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.io.File;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class ServiceGenerator {
    private static final long   CACHE_SIZE   = 10 * 1024 * 1024;
    private static final String API_BASE_URL = "https://metacritic-2.p.mashape.com";

    private static OkHttpClient     httpClient = build(new OkHttpClient());
    private static Retrofit.Builder builder    =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(final Class<S> serviceClass) {
        return builder.client(httpClient).build().create(serviceClass);
    }

    private static OkHttpClient build(final OkHttpClient httpClient) {
        httpClient.networkInterceptors().add(new HeadersInterceptor());
        httpClient.networkInterceptors().add(new LoggingInterceptor());
        httpClient.setCache(new Cache(new File("/tmp/ms"), CACHE_SIZE));
        return httpClient;
    }
}
