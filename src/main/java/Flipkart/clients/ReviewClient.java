package Flipkart.clients;

import Flipkart.bean.Genre;
import Flipkart.bean.Movie;
import Flipkart.bean.Review;
import Flipkart.bean.User;
import Flipkart.dto.GenreDTO;
import Flipkart.helpers.GenreHelper;
import Flipkart.services.ReviewService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dakshay on 23/10/2021.
 */
public class ReviewClient {

    private List<Movie> movies = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public Movie addMovie(String movieName, Long releaseYear, List<GenreDTO> genreDTO){
        List<Genre> genre = GenreHelper.convertToBean(genreDTO);
        Movie movie = new Movie(movieName,releaseYear,genre);
        this.movies.add(movie);
        return movie;
    }

    public User addUser(String name) {
        User user = new User(name, User.Judgement.VIEWER);
        this.users.add(user);
        return user;
    }

    public void makeReview(String userName, String movieName, int rating) {
        ReviewService reviewService = new ReviewService(movies,users);
        reviewService.createReview(userName,movieName,rating);
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public List<User> getUsers() {
        return users;
    }

    public Movie createMovieObject(String movieName, Long releaseYear, String genre) {
        GenreDTO genreDto = new GenreDTO(genre);
        List<GenreDTO> genreDTOS = new ArrayList<>();
        Collections.addAll(genreDTOS,genreDto);
        return this.addMovie(movieName,releaseYear,genreDTOS );
    }

    public static void main(String[] args) {
        try {
            ReviewClient reviewClient = new ReviewClient();
            User user1 = reviewClient.addUser("dakshay");
            User user2 = reviewClient.addUser("Gaurav");
            Movie movie1 = reviewClient.createMovieObject("DON", 2011L, "COMEDY");
            Movie movie2 = reviewClient.createMovieObject("Padmavat", 2006L, "COMEDY");
            if(reviewClient.getUsers()!=null){
                reviewClient.getUsers().forEach(u->{
                    System.out.println(u.getName());
                });
            }
            System.out.println("Users are:- " + reviewClient.getUsers());
            System.out.println("Movies are:- " + reviewClient.getMovies());
            if(reviewClient.getMovies()!=null){
                reviewClient.getMovies().forEach(m->{
                    System.out.println(m.getMovieName());
                });
            }
            reviewClient.makeReview("dakshay", "Padmavat", 4);
            System.out.println("Movies are:- " + reviewClient.getMovies());
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
