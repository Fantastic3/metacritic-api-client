package com.github.fantastic3.metacritic.api;

public class Main {

    public static void main(String[] args) throws Exception {
        MoviesClient mc = ServiceGenerator.createService(MoviesClient.class);
        System.out.println(mc.find("batman")
                             .execute()
                             .body().getResult().getName());
    }
}
