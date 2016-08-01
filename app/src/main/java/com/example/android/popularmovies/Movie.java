package com.example.android.popularmovies;

/**
 * Created by deepakpe on 7/31/2016.
 */
public class Movie {
    private String poster_path;
    private Boolean adult;
    private String overview;
    private String release_date;
    private String[] genre_ids;
    private String id;
    private String original_title;
    private String title;
    private String backdrop_path;
    private String popularity;
    private String vote_count;
    private String video;
    private String vote_average;

    public Movie(String popularity,
                 String poster_path,
                 Boolean adult,
                 String backdrop_path,
                 String[] genre_ids,
                 String original_date,
                 String id,
                 String overview,
                 String title,
                 String video,
                 String vote_average,
                 String vote_count,
                 String release_date)
    {
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.adult = adult;
        this.backdrop_path = backdrop_path;
        this.genre_ids = genre_ids;
        this.original_title = original_title;
        this.id = id;
        this.overview = overview;
        this.title = title;
        this.video = video;
        this.vote_count = vote_count;
        this.vote_average = vote_average;
        this.release_date = release_date;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String[] getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(String[] genre_ids) {
        this.genre_ids = genre_ids;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginal_date() {
        return original_title;
    }

    public void setOriginal_date(String original_date) {
        this.original_title = original_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getVote_count() {
        return vote_count;
    }

    public void setVote_count(String vote_count) {
        this.vote_count = vote_count;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }
}
