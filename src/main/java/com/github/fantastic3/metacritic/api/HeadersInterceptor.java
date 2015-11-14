package com.github.fantastic3.metacritic.api;

import com.github.fantastic3.metacritic.Constants;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class HeadersInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        final Request originalRequest = chain.request();
        final Request requestWithHeaders = originalRequest.newBuilder()
                                                          .header("Accept", "application/json")
                                                          .header("X-Mashape-Key", Constants.API_KEY)
                                                          .method(originalRequest.method(), originalRequest.body())
                                                          .build();
        return chain.proceed(requestWithHeaders);
    }
}
