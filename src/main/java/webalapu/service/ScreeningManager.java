package webalapu.service;

import webalapu.model.Screening;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ScreeningManager implements ScreeningManagerLocal {

    @PersistenceContext(unitName = "cinemaUnit")
    EntityManager em;

    public List<Screening> getAllScreening(){
        Query query = em.createQuery("SELECT screening FROM Screening screening");
        List<Screening> screeningList = query.getResultList();
        if( screeningList == null ) {
            return new ArrayList<>();
        }
        return screeningList;
    }
}
