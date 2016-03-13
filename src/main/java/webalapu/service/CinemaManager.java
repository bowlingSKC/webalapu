package webalapu.service;

import org.primefaces.model.map.LatLng;
import webalapu.model.Cinema;
import webalapu.service.exception.CinemaAlreadyExistsException;
import webalapu.service.exception.CinemaNotFoundException;
import webalapu.util.GeoCoder;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CinemaManager implements CinemaManagerLocal {

    @PersistenceContext(unitName = "cinemaUnit")
    EntityManager em;

    @Override
    public void addNewCinema(Cinema newCinema) throws CinemaAlreadyExistsException{
        Query query = em.createQuery("SELECT cinema FROM Cinema cinema WHERE cinema.address = :address " +
                                                                        "AND cinema.city =:city " +
                                                                        "AND cinema.name =:name");
        query.setParameter("address", newCinema.getAddress());
        query.setParameter("city", newCinema.getCity());
        query.setParameter("name", newCinema.getName());

        try {
            query.getSingleResult();
            throw new CinemaAlreadyExistsException();
        } catch (NoResultException ex) {
            // semmi baj nem történt, sőőt ...
        }

        em.persist(newCinema);
        em.flush();
    }

    @Override
    public void deleteCinema(Cinema cinema) throws CinemaNotFoundException{
        Cinema dbCinema = em.find(Cinema.class, cinema.getId());
        if( dbCinema == null ) {
            throw new CinemaNotFoundException();
        }

        em.remove(cinema);
        em.flush();
    }

    @Override
    public void updateCinema(Cinema cinema) throws CinemaNotFoundException{
        Cinema updateCinema = em.find(Cinema.class, cinema.getId());
        if( updateCinema == null ) {
            throw new CinemaNotFoundException();
        }

        mergeCinemarAttrs(cinema, updateCinema);
        em.merge(updateCinema);
        em.flush();
    }

    @Override
    public List<Cinema> getAllCinemas() {
        Query query = em.createQuery("SELECT cinema FROM Cinema cinema");
        List<Cinema> cinemaList = query.getResultList();
        if( cinemaList == null ) {
            return new ArrayList<>();
        }
        return cinemaList;
    }

    private void mergeCinemarAttrs(Cinema cinema, Cinema updateCinema){
        //TODO: Az attribútumok össefésülését implementálni
    }

}
