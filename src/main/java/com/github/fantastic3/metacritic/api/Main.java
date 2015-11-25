package com.github.fantastic3.metacritic.api;

import com.github.fantastic3.metacritic.api.movies.MoviesClient;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        final ServiceGenerator serviceGenerator = ServiceGenerator.build(new File("/tmp/ms"));
        final MoviesClient mc = serviceGenerator.createService(MoviesClient.class);
        System.out.println(mc.find("batman")
                             .execute()
                             .body().getResult().getName());
        System.out.println(mc.newReleases(null).execute().body().getResults());
        System.out.println(mc.comingSoon().execute().body().getResults());
        System.out.println(mc.search(null, "batman", null, null).execute().body().getResults());
    }
}
