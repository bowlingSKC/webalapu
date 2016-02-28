package webalapu.service;

import webalapu.model.Movie;
import webalapu.service.exception.MovieNotFoundException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class MovieManager implements MovieManagerLocal {

    @PersistenceContext(unitName = "cinemaUnit")
    EntityManager em;

    @Override
    public void addMovie(Movie newMovie) {
        em.persist(newMovie);
    }

    @Override
    public void deleteMovie(Movie movie) throws MovieNotFoundException {
        Movie dbMovie = em.find(Movie.class, movie.getId());
        if( dbMovie == null ) {
            throw new MovieNotFoundException();
        }

        em.remove(movie);
        em.flush();
    }

    @Override
    public List<Movie> getAllMovie() {
        Query query = em.createQuery("SELECT movie FROM Movie movie");
        List<Movie> movies = query.getResultList();
        if( movies == null ) {
            return new ArrayList<>();
        }
        return movies;
    }
}
