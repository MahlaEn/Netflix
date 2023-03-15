package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static boolean Exit=false;
    static Scanner in = new Scanner(System.in);
    static NetflixService Netflix = new NetflixService();

    public static void main(String[] args) {
        initialize();
        showMenu();
    }
    public static void showMenu(){
        while(!Exit) {
            System.out.println("ENTER YOUR CHOICE :\n" + "1* Login\n" + "4* Create account\n" + "3* Logout\n" + "4* Exit\n");
            String cmd = in.nextLine();
            if (cmd.equals("1")) {//Login
                login();
                System.out.println("ENTER YOUR CHOICE :\n" + "1* Search by Title\n" +
                        "2* Search by Genre\n" + "3* Search by ReleaseYear\n" +
                        "4* Get recommendation\n" + "5* Add to favorites\n" + "6* View favorites");
                cmd = in.nextLine();
                if (cmd.equals("1")) {//search title
                    System.out.println("Enter a title :");
                    String title = in.nextLine();
                    ArrayList<TVShow> res = new ArrayList<>();
                    res=Netflix.searchByTitle(title);
                    if (res.size() == 0) {
                        System.out.println("No TVShow or movie found:(");
                    }
                    else {
                        System.out.println("TVShows and movies with that title :");
                        int cnt = 1;
                        for (TVShow temp : res) {
                            Netflix.ToString(temp, cnt);
                            cnt++;
                        }
                    }
                }
                else if (cmd.equals("2")) {//search genre
                    System.out.println("Enter a genre");
                    String genre = in.nextLine();
                    ArrayList<TVShow> res = Netflix.searchByGenre(genre);
                    if (res.size() == 0) {
                        System.out.println("No TVShow or movie found:(");
                    }
                    else {
                        System.out.println("TVShows and movies with that genre :");
                        int cnt = 1;
                        for (TVShow temp : res) {
                            Netflix.ToString(temp, cnt);
                            cnt++;
                        }
                    }
                }
                else if (cmd.equals("3")) {//search year
                    System.out.println("Enter a year");
                    String year = in.nextLine();
                    ArrayList<TVShow> res = Netflix.searchByReleaseYear(year);
                    if (res.size() == 0) {
                        System.out.println("No TVShow or movie found:(");
                    }
                    else {
                        System.out.println("TVShows and movies with that year :");
                        int cnt = 1;
                        for (TVShow temp : res) {
                            Netflix.ToString(temp, cnt);
                            cnt++;
                        }
                    }
                }
                else if (cmd.equals("4")) {//recommendation
                    ArrayList<TVShow> recommended = Netflix.getCurUser().getRecommendations(Netflix);
                    System.out.println("Recommended TVShows and movies : ");
                    int cnt = 1;
                    for (TVShow rec : recommended) {
                        Netflix.ToString(rec, cnt);
                        cnt++;
                    }
                }
                else if (cmd.equals("5")) {//add fav
                    String title;
                    title = in.nextLine();
                    for (TVShow fav : Netflix.searchByTitle(title)) {
                        Netflix.getCurUser().addToFavorites(fav);
                    }
                }
                else if (cmd.equals("6")) {//fav list
                    System.out.println("Your favourite TVShows and Movies :");
                    Netflix.getCurUser().viewFavorites();
                    System.out.println("ENTER YOUR CHOICE :\n" + "1* Search in favourites by Title\n" +
                            "2* Search in favourites by Genre\n" + "3* Search in favourites by ReleaseYear\n");
                            cmd = in.nextLine();

                    if (cmd.equals("1")) {//search title
                        System.out.println("Enter a title :");
                        String title = in.nextLine();
                        ArrayList<TVShow> res = new ArrayList<>();
                        res=Netflix.getCurUser().searchByTitle(title);
                        if (res.size() == 0) {
                            System.out.println("No TVShow or movie found:(");
                        }
                        else {
                            System.out.println("TVShows and movies with that title :");
                            int cnt = 1;
                            for (TVShow temp : res) {
                                Netflix.ToString(temp, cnt);
                                cnt++;
                            }

                        }
                    }
                    else if (cmd.equals("2")) {//search genre
                        System.out.println("Enter a genre");
                        String genre = in.nextLine();
                        ArrayList<TVShow> res = Netflix.getCurUser().searchByGenre(genre);
                        if (res.size() == 0) {
                            System.out.println("No TVShow or movie found:(");
                        }
                        else {
                            System.out.println("TVShows and movies with that genre :");
                            int cnt = 1;
                            for (TVShow temp : res) {
                                Netflix.ToString(temp, cnt);
                                cnt++;
                            }
                        }
                    }
                    else if (cmd.equals("3")) {//search year
                        System.out.println("Enter a year");
                        String year = in.nextLine();
                        ArrayList<TVShow> res = Netflix.getCurUser().searchByReleaseYear(year);
                        if (res.size() == 0) {
                            System.out.println("No TVShow or movie found:(");
                        }
                        else {
                            System.out.println("TVShows and movies with that year :");
                            int cnt = 1;
                            for (TVShow temp : res) {
                                Netflix.ToString(temp, cnt);
                                cnt++;
                            }
                        }
                    }
                }
                else if(cmd.equals("7")){//Exit
                    System.err.println("Good Bye👋🏻");
                    Exit=true;
                    return;
                }
            }
            else if(cmd.equals("2")){
                createAccount();
            }
            else if (cmd.equals("3")) {//Logout
                logout();
            }
            else if(cmd.equals("4")){//Exit
                System.err.println("Good Bye👋🏻");
                Exit=true;
                return;
            }
        }
    }
    public static void login(){
        String username,password;
        System.out.println("UserName :");
        username=in.nextLine();
        System.out.println("Password :");
        password=in.nextLine();
        if(!Netflix.login(username,password)){
            System.out.println("Enter 1 to create an account or 2 to exit application.");
            String cmd=in.nextLine();
            if(cmd.equals("1")){//Create account
                createAccount();
            }
            else if(cmd.equals("2")){//Exit
                System.err.println("Good Bye👋🏻");
                Exit=true;
                return;
            }
        }
        else{
            Netflix.login(username,password);
            System.out.println("Welcome "+username+" !:)");
        }
    }
    public static void logout(){
        Netflix.logout();
    }
    public static void createAccount(){
        System.out.println("Enter a username:");
        String username = in.nextLine();
        boolean exist=false;
        for(User u:Netflix.getUsers()){
            if(u.getUsername().equals(username)){
                exist=true;
            }
        }
        if(exist){
            System.err.println("This username already exists.");
            createAccount();
            return;
        }
        System.out.println("Enter a password:");
        String password = in.nextLine();
        Netflix.createAccount(username,password);
    }

    public static void initialize(){
        Netflix.createAccount("Mahla","0000");
        Netflix.login("Mahla","0000");
        Netflix.addMovie("ScreamVI","Horror","2023",122,7.4,122);
        Netflix.addMovie("Everything Everywhere All at Once","Action","2022",139,7.0,139);
        Netflix.addMovie("The Whale","Drama","2022",117,7.8,117);
        Netflix.addMovie("A man called Otto","Comedy , Drama","2022",126,7.5,126);
        Netflix.addTVShow("The last of us","Action , Drama , Adventure","2023",50,9.0);
        Netflix.addTVShow("Attack on Titan","Animation , Action , Adventure","2013",24,9.0);
        Netflix.addTVShow("Game of Thrones","Action , Adventure , Drama","2011",57,9.2);
        Netflix.addTVShow("Breaking bad","Drama","2008",49,9.5);
        Netflix.addTVShow("The Office","Comedy","2005",22,9.0);
        TVShow show=Netflix.searchByTitle("Breaking bad").get(0);
        show.setCast(new ArrayList<>(Arrays.asList("Bryan Cranston","Aaron Paul")));
    }

}
