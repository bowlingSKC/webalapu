package webalapu.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "movie_actor")
@IdClass(MovieActorId.class)
public class MovieActor {

    @Id
    @Basic(optional = false)
    @Column(name = "movie_id")
    private long movieId;

    @Id
    @Basic(optional = false)
    @Column(name = "actor_id")
    private long actorId;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movie;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "actor_id", referencedColumnName = "id")
    private Actor actor;

    @Basic(optional = false)
    @NotNull
    @Column(name = "movie_character")
    private String character;

    @Basic(optional = false)
    @Column(name = "main_character")
    private boolean mainCharacter;

    public MovieActor() {

    }

    public MovieActor(Movie movie, Actor actor, String character, boolean mainCharacter) {
        this.movie = movie;
        this.actor = actor;
        this.character = character;
        this.mainCharacter = mainCharacter;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public long getActorId() {
        return actorId;
    }

    public void setActorId(long actorId) {
        this.actorId = actorId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public boolean isMainCharacter() {
        return mainCharacter;
    }

    public void setMainCharacter(boolean mainCharacter) {
        this.mainCharacter = mainCharacter;
    }
}
