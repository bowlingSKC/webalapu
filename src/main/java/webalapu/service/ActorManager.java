package webalapu.service;

import webalapu.model.Actor;
import webalapu.service.exception.ActorAlreadyExistsException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ActorManager implements ActorManagerLocal {

    @PersistenceContext(unitName = "cinemaUnit")
    EntityManager em;

    @Override
    public void addActor(Actor actor) throws ActorAlreadyExistsException {
        em.persist(actor);
    }

    @Override
    public List<Actor> getAllActors() {
        Query query = em.createQuery("SELECT actor FROM Actor actor", Actor.class);
        List<Actor> actors = query.getResultList();
        if( actors == null ) {
            return new ArrayList<>();
        }
        return actors;
    }
}
