package org.example;

import java.util.ArrayList;

class TVShow {
    /*
    *The TVShow should have a title , genre, release year, duration and a rating.
     *The TVShow should have an ArrayList of the cast.
     */
    private String title, genre;
    private int releaseYear, duration;
    double rating;
    private ArrayList<String>cast;
    public TVShow(String title,String genre,int releaseYear,int duration,double rating){
        this.title=title;
        this.genre=genre;
        this.releaseYear=releaseYear;
        this.duration=duration;
        this.rating=rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public ArrayList<String> getCast() {
        return cast;
    }

    public void setCast(ArrayList<String> cast) {
        this.cast = cast;
    }
    public void addCast(String name){
        cast.add(name);
    }
}
