package webalapu.service;

import webalapu.model.Cinema;
import webalapu.service.exception.CinemaAlreadyExistsException;
import webalapu.service.exception.CinemaNotFoundException;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CinemaManagerLocal {

    void addNewCinema(Cinema newCinema) throws CinemaAlreadyExistsException;
    void deleteCinema(Cinema cinema) throws CinemaNotFoundException;
    void updateCinema(Cinema cinema) throws CinemaNotFoundException;
    List<Cinema> getAllCinemas();

}
