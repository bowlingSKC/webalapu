package webalapu.service;

import webalapu.model.Movie;
import webalapu.service.exception.MovieNotFoundException;

import javax.ejb.Local;
import java.util.List;

@Local
public interface MovieManagerLocal {

    void addMovie(Movie newMovie);
    void deleteMovie(Movie movie) throws MovieNotFoundException;
    List<Movie> getAllMovie();

}
