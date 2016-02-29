package webalapu.service;

import webalapu.model.Actor;
import webalapu.service.exception.ActorAlreadyExistsException;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ActorManagerLocal {

    void addActor(Actor actor) throws ActorAlreadyExistsException;
    List<Actor> getAllActors();

}
