package org.example;

import java.util.ArrayList;
import java.util.Objects;

class NetflixService {
    /*
     *The NetflixService should have an Arraylist of users, tv shows and movies.
     *The NetflixService should have a User object which represents current user.
     */
    private static User CurUser;
    private ArrayList<User>users=new ArrayList<>();
    private ArrayList<TVShow>tvShows=new ArrayList<>();
    private ArrayList<TVShow>movies=new ArrayList<>();

    public static User getCurUser() {
        return CurUser;
    }

    public static void setCurUser(User curUser) {
        NetflixService.CurUser = curUser;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<TVShow> getTvShows() {
        return tvShows;
    }

    public void setTvShows(ArrayList<TVShow> tvShows) {
        this.tvShows = tvShows;
    }

    public ArrayList<TVShow> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<TVShow> movies) {
        this.movies = movies;
    }

    public void addTVShow(TVShow tvShow){
        tvShows.add(tvShow);
        // Implement add tv show logic here
    }
    public void addTVShow(String title, String genre,int releaseYear,int duration,double rating){
        TVShow temp = new TVShow(title, genre, releaseYear, duration, rating);
        tvShows.add(temp);
    }

    public void addMovie(String title, String genre,int releaseYear,int duration,double rating, int length){
        Movie temp = new Movie(title, genre, releaseYear, duration, rating , length);
        tvShows.add(temp);
    }

    public void createAccount(String username, String password) {
        User newuser= new User();
        newuser.setUsername(username);
        newuser.setPassword(password);
        users.add(newuser);
        System.out.println("Account created successfully!=)");
    }

    public boolean login(String username, String password) {
        for(User temp : users){
            if(temp.getUsername().equals(username) && temp.getPassword().equals(password)){
                CurUser=temp;
                return true;
            }
            if(temp.getUsername().equals(username) && !temp.getPassword().equals(password)){
                System.err.println("Wrong password !:(");
                return false;
            }
        }
        System.err.println("No such user:(\n");
        return false;
    }

    public void logout() {
        CurUser=null;
        System.out.println("You have successfully logged out!:(");
    }

    public ArrayList<TVShow> searchByTitle(String title) {
        ArrayList<TVShow>temp = new ArrayList<>();
        for(TVShow cur : tvShows){
            if(cur.getTitle().equals(title)){
                temp.add(cur);
            }
        }
        for(TVShow cur : movies){
            if(cur.getTitle().equals(title)){
                temp.add(cur);
            }
        }
        return temp;
    }

    public ArrayList<TVShow> searchByGenre(String genre) {
        // Implement search by genre logic here
        ArrayList<TVShow>temp = new ArrayList<>();
        for(TVShow cur : tvShows){
            if(cur.getGenre().equals(genre)){
                temp.add(cur);
            }
        }
        for(TVShow cur : movies){
            if(cur.getGenre().equals(genre)){
                temp.add(cur);
            }
        }
        return temp;
    }

    public ArrayList<TVShow> searchByReleaseYear(int year) {
        // Implement search by release year logic here
        ArrayList<TVShow>temp = new ArrayList<>();
        for(TVShow cur : tvShows){
            if(cur.getReleaseYear()==year){
                temp.add(cur);
            }
        }
        for(TVShow cur : movies){
            if(cur.getReleaseYear()==year){
                temp.add(cur);
            }
        }
        return temp;
    }
    public static void ToString(TVShow tv,int num){
        System.out.println( num + ") " + "Title: " + tv.getTitle() +
                ", Genre: " + tv.getGenre() +
                ", Release year: " + tv.getReleaseYear() +
                ", Duration: "+ tv.getDuration() +
                ", Rating: "+ tv.getRating()
                +"\n___________________________________"
        );
    }
}

