package webalapu.backing;

import webalapu.model.Actor;
import webalapu.service.ActorManagerLocal;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class ActorBacking extends BaseBacking implements Serializable {

    @EJB
    private ActorManagerLocal actorManager;

    private List<Actor> actors;

    public String retrieveActorList() {
        actors = actorManager.getAllActors();
        return null;
    }

    public List<String> completeText(String query) {
        List<String> filtered = new ArrayList<>();
        if( getActors() == null ) {
            System.err.println("null a lista");
        }
        for(Actor actor : getActors()) {
            if( actor.getName().contains(query) ) {
                filtered.add(actor.getName());
            }
        }
        return filtered;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

}
