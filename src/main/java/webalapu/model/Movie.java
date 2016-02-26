package webalapu.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

//TODO: Modellezni a rendező kapcsolatot

@Entity
@Table(name = "movie")
public class Movie implements Serializable {
    private static final long serialVersionUID = 19763540754653456L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(max = 100)
    @Column(name = "title")
    private String title;

    @Basic(optional = false)
    @NotNull
    @Size(max = 100)
    @Column(name = "original_title")
    private String originalTitle;

    @Basic(optional = false)
    @NotNull
    @Column(name = "duration")
    private Integer duration;

    @Basic(optional = false)
    @NotNull
    @Column(name = "rate")
    private Integer rate;

    @Basic(optional = false)
    @NotNull
    @Size(max = 255)
    @Column(name = "imdb_url")
    private String imdbURL;

    @Basic(optional = false)
    @NotNull
    @Size(max = 255)
    @Column(name = "youtube_url")
    private String youtubeURL;

    @Basic(optional = false)
    @NotNull
    @Column(name = "description")
    private String description;

    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date premiere;

    @JoinColumn(name = "director_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Director director;

    @ManyToMany
    @JoinTable(name = "movie_genre", joinColumns = {@JoinColumn(name = "movie_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "genre_id", referencedColumnName = "id")})
    private List<Genre> genreList;

    @OneToMany(mappedBy = "movie")
    private List<MovieActor> actors;

    public Movie() {

    }

    public Movie(String title, String originalTitle, Integer duration, Integer rate, String imdbURL, String youtubeURL, String description, Date premiere, Director director, List<Genre> genreList, List<MovieActor> actors) {
        this.title = title;
        this.originalTitle = originalTitle;
        this.duration = duration;
        this.rate = rate;
        this.imdbURL = imdbURL;
        this.youtubeURL = youtubeURL;
        this.description = description;
        this.premiere = premiere;
        this.director = director;
        this.genreList = genreList;
        this.actors = actors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getImdbURL() {
        return imdbURL;
    }

    public void setImdbURL(String imdbURL) {
        this.imdbURL = imdbURL;
    }

    public String getYoutubeURL() {
        return youtubeURL;
    }

    public void setYoutubeURL(String youtubeURL) {
        this.youtubeURL = youtubeURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPremiere() {
        return premiere;
    }

    public void setPremiere(Date premiere) {
        this.premiere = premiere;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    public List<MovieActor> getActors() {
        return actors;
    }

    public void setActors(List<MovieActor> actors) {
        this.actors = actors;
    }
}
