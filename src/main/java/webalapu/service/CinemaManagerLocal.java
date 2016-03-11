package webalapu.service;

import webalapu.model.Cinema;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CinemaManagerLocal {

    List<Cinema> getAllCinema();

}
