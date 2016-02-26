package webalapu.model;

import java.io.Serializable;

public class MovieActorId implements Serializable {

    private long movieId;
    private long actorId;

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

    @Override
    public int hashCode() {
        return (int)(actorId + movieId);
    }

    @Override
    public boolean equals(Object obj) {
        if( obj instanceof MovieActorId ) {
            MovieActorId otherId = (MovieActorId) obj;
            return (otherId.getActorId() == this.getActorId()) && ( otherId.getMovieId() == this.getMovieId() );
        }
        return false;
    }
}
