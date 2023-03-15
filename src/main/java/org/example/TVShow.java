package org.example;

import java.util.ArrayList;

class TVShow {
    private String title;
    private String[] genre;
    private String releaseYear;
    private int duration;
    double rating;
    private ArrayList<String>cast;
    public TVShow(String title,String[] genre,String releaseYear,int duration,double rating){
        this.title=title;
        this.genre=genre;
        this.releaseYear=releaseYear;
        this.duration=duration;
        this.rating=rating;
    }

    public String getTitle() {
        return title;
    }
    public String[] getGenre() {
        return genre;
    }
    public String getReleaseYear() {
        return releaseYear;
    }
    public int getDuration() {
        return duration;
    }
    public double getRating() {
        return rating;
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
