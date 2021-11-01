package Flipkart.bean;

import java.util.List;

/**
 * Created by dakshay on 23/10/2021.
 */
public class Movie {
    private final String movieName;
    private final Long releaseYear;
    private final List<Genre> genres;
    private List<Review> reviews;

    public Movie(String movieName, Long releaseYear, List<Genre> genres, List<Review> reviews) {
        this.movieName = movieName;
        this.releaseYear = releaseYear;
        this.genres = genres;
        this.reviews = reviews;
    }

    public Movie(String movieName, Long releaseYear, List<Genre> genres) {
        this.movieName = movieName;
        this.releaseYear = releaseYear;
        this.genres = genres;
    }

    public String getMovieName() {
        return movieName;
    }

    public Long getReleaseYear() {
        return releaseYear;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieName='" + movieName + '\'' +
                ", releaseYear=" + releaseYear +
                ", genres=" + genres +
                ", reviews=" + reviews +
                '}';
    }
}
