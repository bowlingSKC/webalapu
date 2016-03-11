package webalapu.backing;

import webalapu.model.Cinema;
import webalapu.service.CinemaManagerLocal;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class CinemaBacking extends BaseBacking implements Serializable {

    @EJB
    private CinemaManagerLocal cinemaManager;

    private List<Cinema> cinemas;
    private Cinema selectedCinema;

    public void getAllCinema() {
        cinemas = cinemaManager.getAllCinema();
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
}
