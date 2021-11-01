package Flipkart.services;

import Flipkart.bean.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by dakshay on 23/10/2021.
 */
public class MovieService {

    public List<Movie> getTopScoredMovieByReleaseYear(List<Movie> movies, int n, Long releaseYear){
//        movies.stream().map(m->m.getReleaseYear().equals(releaseYear));
        Map<Movie,Integer> hashMap = new HashMap<>();
        movies.forEach(m -> {
            if(m!=null) {
                if(m.getReleaseYear() == releaseYear){
                   int total = m.getReviews().stream().map(review -> review.getRating())
                            .collect(Collectors.summingInt(Integer::intValue));
                   hashMap.put(m,total);
                }
            }
        });
        return new ArrayList<>();
    }

    public List<Movie> getTopScoredMovieByGenre(List<Movie> movies, int n, String genre){
//        movies.stream().map(m->m.getReleaseYear().equals(releaseYear));
        Map<Integer,Movie> hashMap = new HashMap<>();
        movies.forEach(m -> {
            if(m!=null) {
                if(m.getGenres().contains(genre)){
                    int total = m.getReviews().stream().map(review -> review.getRating())
                            .collect(Collectors.summingInt(Integer::intValue));
                    hashMap.put(total,m);
                }
            }
        });
        return new ArrayList<>();

    }
}
