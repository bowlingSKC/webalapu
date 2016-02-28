package webalapu.backing;

import webalapu.model.Movie;
import webalapu.service.MovieManagerLocal;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class MovieBacking extends BaseBacking implements Serializable {

    @EJB
    private MovieManagerLocal movieManager;

    private List<Movie> allMovies;
    private Movie selectedMovie;
    private List<Movie> filteredMovies;

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
}
