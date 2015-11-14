package com.github.fantastic3.metacritic.api;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private final String name;
    private final String score;
    private final List<String> genre = new ArrayList<>();
    private final String thumbnail;
    private final double userscore;
    private final String summary;
    private final String platform;
    private final String publisher;
    private final String developer;
    private final String rating;
    private final String rlsdate;
    private final String url;


    public Result(String name,
                  String score,
                  String thumbnail,
                  double userscore,
                  String summary,
                  String platform,
                  String publisher, String developer, String rating, String rlsdate, String url) {
        this.name = name;
        this.score = score;
        this.thumbnail = thumbnail;
        this.userscore = userscore;
        this.summary = summary;
        this.platform = platform;
        this.publisher = publisher;
        this.developer = developer;
        this.rating = rating;
        this.rlsdate = rlsdate;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getScore() {
        return score;
    }

    public List<String> getGenre() {
        return genre;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public double getUserscore() {
        return userscore;
    }

    public String getSummary() {
        return summary;
    }

    public String getPlatform() {
        return platform;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getDeveloper() {
        return developer;
    }

    public String getRating() {
        return rating;
    }

    public String getRlsdate() {
        return rlsdate;
    }

    public String getUrl() {
        return url;
    }
}
