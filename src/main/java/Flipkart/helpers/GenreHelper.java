package Flipkart.helpers;

import Flipkart.bean.Genre;
import Flipkart.dto.GenreDTO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dakshay on 23/10/2021.
 */
public class GenreHelper {

    public static List<Genre> convertToBean(List<GenreDTO> genreDTO) {
        return  genreDTO.stream().map(g->new Genre(g.getName())).collect(Collectors.toList());
    }
}
