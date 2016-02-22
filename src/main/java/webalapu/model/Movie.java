package webalapu.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

//TODO: Modellezni a rendező kapcsolatot

//TODO: DateTime modellezése

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



}
