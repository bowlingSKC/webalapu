package webalapu.backing;

import webalapu.model.Cinema;
import webalapu.model.Hall;
import webalapu.model.Movie;
import webalapu.model.Screening;
import webalapu.service.CinemaManagerLocal;
import webalapu.service.MovieManagerLocal;
import webalapu.service.ScreeningManagerLocal;
import webalapu.service.UserManagerLocal;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class ScreeningBacking  extends BaseBacking implements Serializable {

    @EJB
    private CinemaManagerLocal cinemaManager;

    @EJB
    private UserManagerLocal userManager;

    @EJB
    private ScreeningManagerLocal screeningManager;

    @EJB
    private MovieManagerLocal movieManager;

    private List<Movie> movieList;
    private List<Screening> screeningList;
    private List<Screening> filteredScreeningList;
    private List<Cinema> cinemaList;

    private String selectedStringMovie;
    private String selectedStringCinema;
    private String selectedStringScreening;
    private Movie selectedMovie;
    private Screening selectedScreening;
    private Cinema selectedCinema;
    private Integer rows;
    private Integer cols;

    @PostConstruct
    public void init() {
        movieList = movieManager.getAllMovie();
        screeningList = screeningManager.getAllScreening();
        cinemaList = cinemaManager.getAllCinemas();
        selectedCinema = new Cinema(); selectedMovie = new Movie();
        rows = 0; cols = 0;
    }

    public void onMovieChange(){
        for(Movie mov : movieList){
            if(mov.getOriginalTitle().equals(selectedStringMovie)){
                selectedMovie = mov;
            }
        }
        filteredScreeningList = getFilteredScreening();
        System.out.println("OnMovieChange: " + selectedMovie.getOriginalTitle());
    }
    public void onCinemaChange(){
        for(Cinema cin : cinemaList){
            if(cin.getName().equals(selectedStringCinema)){
                selectedCinema = cin;
            }
        }
        filteredScreeningList = getFilteredScreening();
        System.out.println("OnCinemaChange: " + selectedCinema.getName());
    }
    public void onScreeningChange(){
        for(Screening scr : screeningList){
            if(scr.getId().toString().equals(selectedStringScreening)){
                selectedScreening = scr;
                rows = selectedScreening.getHall().getRows();
                cols = selectedScreening.getHall().getCols();
                System.out.println("Rows: " + rows + " Cols: " + cols);
            }
        }
        System.out.println("OnScreeningChange: " + selectedScreening);
    }
    public List<Screening> getFilteredScreening(){
        screeningList = screeningManager.getAllScreening();
        filteredScreeningList = new ArrayList<>();
        for(Screening scr : screeningList){
              if(scr.getHall().getCinema().getName().equals(selectedCinema.getName()) && scr.getMovie().getOriginalTitle().equals(selectedMovie.getOriginalTitle())){
                filteredScreeningList.add(scr);
            }
        }
        return filteredScreeningList;
    }

    public Integer getRows() {return rows;}

    public void setRows(Integer rows) {this.rows = rows;}

    public Integer getCols() {return cols;}

    public void setCols(Integer cols) {this.cols = cols;}

    public void getAllMovie(){
        movieList = movieManager.getAllMovie();
    }

    public void getAllCinema() {
        cinemaList = cinemaManager.getAllCinemas();
    }

    public void getAllScreening(){
        screeningList = screeningManager.getAllScreening();
    }

    public Movie getSelectedMovie() {
        return selectedMovie;
    }

    public void setSelectedMovie(Movie selectedMovie) {
        this.selectedMovie = selectedMovie;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public List<Screening> getFilteredScreeningList() {
        return filteredScreeningList;
    }

    public void setFilteredScreeningList(List<Screening> filteredScreeningList) {this.filteredScreeningList = filteredScreeningList;}

    public List<Screening> getScreeningList() {
        return screeningList;
    }

    public void setScreeningList(List<Screening> screeningList) {
        this.screeningList = screeningList;
    }

    public List<Cinema> getCinemaList() {
        return cinemaList;
    }

    public void setCinemaList(List<Cinema> cinemaList) {
        this.cinemaList = cinemaList;
    }

    public String getSelectedStringCinema() {
        return selectedStringCinema;
    }

    public void setSelectedStringCinema(String selectedStringCinema) {this.selectedStringCinema = selectedStringCinema;}

    public String getSelectedStringMovie() {
        return selectedStringMovie;
    }

    public void setSelectedStringMovie(String selectedStringMovie) {
        this.selectedStringMovie = selectedStringMovie;
    }

    public Cinema getSelectedCinema() {
        return selectedCinema;
    }

    public void setSelectedCinema(Cinema selectedCinema) {
        this.selectedCinema = selectedCinema;
    }

    public String getSelectedStringScreening() {
        return selectedStringScreening;
    }

    public void setSelectedStringScreening(String selectedStringScreening) {this.selectedStringScreening = selectedStringScreening;}

    public Screening getSelectedScreening() {
        return selectedScreening;
    }

    public void setSelectedScreening(Screening selectedScreening) {
        this.selectedScreening = selectedScreening;
    }
}
