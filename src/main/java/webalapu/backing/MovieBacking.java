package webalapu.backing;

import webalapu.model.Movie;
import webalapu.model.MovieActor;
import webalapu.service.MovieManagerLocal;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class MovieBacking extends BaseBacking implements Serializable {

    @EJB
    private MovieManagerLocal movieManager;

    @Named
    @Produces
    @RequestScoped
    private Movie newMovie = new Movie();

    private List<Movie> allMovies;
    private Movie selectedMovie;
    private List<Movie> filteredMovies;

    @PostConstruct
    public void init() {
        newMovie.setActors(new ArrayList<MovieActor>());
        addCharacter();
    }

    public String addCharacter() {
        newMovie.getActors().add(new MovieActor());
        System.out.println( "Number of Actors: " + newMovie.getActors().size() );
        return null;
    }

    public String removeCharacter(MovieActor item) {
        newMovie.getActors().remove(item);
        System.out.println( "Number of Actors: " + newMovie.getActors().size() );
        return null;
    }

    public String retrieveMovieList() {
        allMovies = movieManager.getAllMovie();
        return null;
    }

    public List<Movie> getAllMovies() {
        return allMovies;
    }

    public void setAllMovies(List<Movie> allMovies) {
        this.allMovies = allMovies;
    }

    public Movie getSelectedMovie() {
        return selectedMovie;
    }

    public void setSelectedMovie(Movie selectedMovie) {
        this.selectedMovie = selectedMovie;
    }

    public List<Movie> getFilteredMovies() {
        return filteredMovies;
    }

    public void setFilteredMovies(List<Movie> filteredMovies) {
        this.filteredMovies = filteredMovies;
    }

    public Movie getNewMovie() {
        return newMovie;
    }

    public void setNewMovie(Movie newMovie) {
        this.newMovie = newMovie;
    }
}
