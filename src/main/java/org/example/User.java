package org.example;

import java.util.ArrayList;

class User {
    private String username;
    private String password;
    private ArrayList<TVShow>favoriteShows=new ArrayList<>() ;
    private ArrayList<TVShow> watchHistory=new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<TVShow> getFavoriteShows() {
        return favoriteShows;
    }

    public void setFavoriteShows(ArrayList<TVShow> favoriteShows) {
        this.favoriteShows = favoriteShows;
    }

    public ArrayList<TVShow> getWatchHistory() {
        return watchHistory;
    }

    public void setWatchHistory(ArrayList<TVShow> watchHistory) {
        this.watchHistory = watchHistory;
    }

    public ArrayList<TVShow> searchByTitle(String title) {
        ArrayList<TVShow>temp = new ArrayList<>();
        for(TVShow cur : favoriteShows){
            if(cur.getTitle().equals(title)){
                temp.add(cur);
            }
        }
        return temp;
    }
    public ArrayList<TVShow> searchByGenre(String genre) {
        ArrayList<TVShow>temp = new ArrayList<>();
        for(TVShow cur : favoriteShows){
            if(cur.getGenre().equals(genre)){
                temp.add(cur);
            }
        }
        return temp;
    }
    public ArrayList<TVShow> searchByReleaseYear(int year) {
        ArrayList<TVShow>temp = new ArrayList<>();
        for(TVShow cur : favoriteShows){
            if(cur.getReleaseYear()==year){
                temp.add(cur);
            }
        }
        return temp;
    }
    public void addToFavorites(TVShow show) {
        favoriteShows.add(show);
        System.out.println("Show added successfully!");
    }
    public void viewFavorites() {
        if(favoriteShows.isEmpty()){
            System.err.println("Is empty.");
            return;
        }
        int cnt=1;
        for(TVShow cur: favoriteShows){
            NetflixService.ToString(cur,cnt);
            cnt++;
        }
    }
    public ArrayList<TVShow> getRecommendations(NetflixService netflix) {
        ArrayList<TVShow>recommended=new ArrayList<>();
        for(TVShow my : favoriteShows){
            for(TVShow cur : netflix.getTvShows()){
                if(cur.getGenre().equals(my.getGenre()) && !cur.getTitle().equals(my.getTitle())){
                    recommended.add(cur);
                }
                if(cur.getRating()>7 && !recommended.contains(cur) && !favoriteShows.contains(cur)){
                    recommended.add(cur);
                }
            }
            for(TVShow cur : netflix.getMovies()){
                if(cur.getGenre().equals(my.getGenre()) && !cur.getTitle().equals(my.getTitle())){
                    recommended.add(cur);
                }
                if(cur.getRating()>7 && !recommended.contains(cur) && !favoriteShows.contains(cur)){
                    recommended.add(cur);
                }
            }
        }
        return recommended;
    }
}

