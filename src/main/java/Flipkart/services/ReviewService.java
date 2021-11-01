package Flipkart.services;

import Flipkart.bean.Movie;
import Flipkart.bean.Review;
import Flipkart.bean.User;
import Flipkart.excpetions.CustomException;
import Flipkart.excpetions.ExceptionConstants;

import java.time.Instant;
import java.util.List;

/**
 * Created by dakshay on 23/10/2021.
 */
public class ReviewService {
    private List<Movie> movies;
    private final List<User> users;

    public ReviewService(List<Movie> movies, List<User> user) {
        this.movies = movies;
        this.users = user;
    }


    public void createReview(String userName, String movieName, int rating) throws CustomException{
        this.movies.stream().filter(m-> m.getMovieName().equals(movieName)).forEach(m->{
            if(m.getReleaseYear() > Instant.now().toEpochMilli()) {
                throw new CustomException(ExceptionConstants.MOVIE_YET_TO_BE_PUBLISHED.name());
            }
            Review r = m.getReviews().stream()
                    .filter(review -> review!=null && review.getUser()!=null && review.getUser().getName()!=null
                              ? review.getUser().getName().equals(userName) : null).findFirst().orElse(null);
            if(r!=null) {
                throw new CustomException(ExceptionConstants.MULTIPLE_REVIEWS_NOT_ALLOWED.name());
            }
            User user = users.stream().filter(u->u.getName().equals(userName)).findFirst().orElse(null);
            Review review = new Review(user,rating);
            List<Review> existingReviews = m.getReviews();
            existingReviews.add(review);

        });

    }
}
