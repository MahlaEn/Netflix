package org.example;

import java.util.ArrayList;

class Movie extends TVShow {
    private int length;
    public Movie(String title,String genre,String releaseYear,int duration,double rating,int length) {
        super(title,genre,releaseYear,duration,rating);
    }
    public int getLength() {
        return length;
    }
}
