package webalapu.service;

import webalapu.model.Cinema;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CinemaManager implements CinemaManagerLocal {

    @PersistenceContext(unitName = "cinemaUnit")
    EntityManager em;

    @Override
    public List<Cinema> getAllCinema() {
        Query query = em.createQuery("SELECT cinema FROM Cinema cinema");
        List<Cinema> cinemaList = query.getResultList();
        if( cinemaList == null ) {
            return new ArrayList<>();
        }
        return cinemaList;
    }

}
