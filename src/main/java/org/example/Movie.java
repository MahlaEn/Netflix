package org.example;

import java.util.ArrayList;

class Movie extends TVShow {
    private int length;
    public Movie(String title,String genre,int releaseYear,int duration,double rating,int length) {
        super(title,genre,releaseYear,duration,rating);
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
}
