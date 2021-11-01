package Flipkart.bean;

/**
 * Created by dakshay on 23/10/2021.
 */
public class Review {

    private final User user;
    private final Integer rating;


    public Review(User user, Integer rating) {
        this.user = user;
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public Integer getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Review{" +
                "user=" + user +
                ", rating=" + rating +
                '}';
    }
}
