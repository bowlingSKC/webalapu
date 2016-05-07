package webalapu.backing;

import org.primefaces.model.map.LatLng;
import webalapu.model.Cinema;
import webalapu.model.Hall;
import webalapu.model.Screening;
import webalapu.model.User;
import webalapu.service.CinemaManagerLocal;
import webalapu.service.ScreeningManagerLocal;
import webalapu.service.UserManagerLocal;
import webalapu.service.exception.CinemaAlreadyExistsException;
import webalapu.service.exception.CinemaNotFoundException;
import webalapu.service.exception.UserNotFoundException;
import webalapu.util.GeoCoder;

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
public class CinemaBacking extends BaseBacking implements Serializable {

    @EJB
    private CinemaManagerLocal cinemaManager;

    @EJB
    private UserManagerLocal userManager;

    @EJB
    private ScreeningManagerLocal screeningManager;

    private List<Screening> screeningList;
    private List<Screening> filteredScreeningList;

    private List<Cinema> cinemas;
    private Cinema selectedCinema;

    private List<Cinema> filteredCinemas;

    @Named
    @Produces
    @RequestScoped
    private Cinema newCinema = new Cinema();

    @PostConstruct
    public void init() {
        cinemas = cinemaManager.getAllCinemas();
    }

    public List<Screening> getScreeningByCinema() {
        List<Screening> screenings = new ArrayList<>();
        if( selectedCinema != null ) {
            for(Hall hall : selectedCinema.getHalls()) {
                screenings.addAll(hall.getScreenings());
            }
        }
        return screenings;
    }

    public void getAllCinema() {
        cinemas = cinemaManager.getAllCinemas();
    }

    public List<Cinema> getCinemas() {
        return cinemas;
    }

    public void setCinemas(List<Cinema> cinemas) {
        this.cinemas = cinemas;
    }

    public Cinema getSelectedCinema() {
        return selectedCinema;
    }

    public void setSelectedCinema(Cinema selectedCinema) {
        this.selectedCinema = selectedCinema;
    }

    public List<Cinema> getFilteredCinemas() {
        return filteredCinemas;
    }

    public void setFilteredCinemas(List<Cinema> filteredCinemas) {
        this.filteredCinemas = filteredCinemas;
    }

    public Cinema getNewCinema() {
        return newCinema;
    }

    public void setNewCinema(Cinema newCinema){
        this.newCinema = newCinema;
    }

    public String delete() {
        try {
            Cinema selectedCinema = getSelectedCinema();

            cinemaManager.deleteCinema(selectedCinema);
            cinemas.remove(selectedCinema);
        } catch (CinemaNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String insert(String managerEmail) {
        try{
            LatLng coordinates = GeoCoder.getCoordinatesFromAddress(newCinema.getAddress());
            newCinema.setLatitude(coordinates.getLat());
            newCinema.setLongitude(coordinates.getLng());

            User manager = userManager.getUserById("moziadmin@moziadmin.hu");
            newCinema.setManager(manager);

            cinemaManager.addNewCinema(newCinema);
            cinemas.add(newCinema);

            newCinema = new Cinema();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        } catch(CinemaAlreadyExistsException ex){
            ex.printStackTrace();
        }

        return null;
    }

    public String update() {
        System.out.println( "Updated: " + selectedCinema );
        return null;
    }

    public void getAllScreening(){
        screeningList = screeningManager.getAllScreening();
    }

    public List<Screening> getFilteredScreening(){
        screeningList = screeningManager.getAllScreening();
        filteredScreeningList = new ArrayList<>();
        for(Screening scr : screeningList){
            if(scr.getHall().getCinema().equals(selectedCinema)){
                filteredScreeningList.add(scr);
            }
        }
        return filteredScreeningList;
    }

    public List<Screening> getScreeningList() {
        return screeningList;
    }

    public void setScreeningList(List<Screening> screeningList) {
        this.screeningList = screeningList;
    }

    public List<Screening> getFilteredScreeningList() {
        return filteredScreeningList;
    }

    public void setFilteredScreeningList(List<Screening> filteredScreeningList) {
        this.filteredScreeningList = filteredScreeningList;
    }
}
