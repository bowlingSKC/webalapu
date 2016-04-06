package webalapu.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "screening")
public class Screening implements Serializable{
    private static final long serialVersionUID = 197654625554653456L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "start")
    @Temporal(TemporalType.DATE)
    private Date startTime = new Date();

    @Basic(optional = false)
    @NotNull
    @Column(name = "priece")
    private Integer priece;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "screening")
    private List<Ticket> tickets;

    @JoinColumn(name = "hall_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Hall hall;

    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Movie movie;

    public Screening(){

    }

    public Screening(Date startTime, Integer priece, Hall hall, Movie movie) {
        this.startTime = startTime;
        this.priece = priece;
        this.hall = hall;
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getPriece() {
        return priece;
    }

    public void setPriece(Integer priece) {
        this.priece = priece;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    @Override
    public String toString() {
        return "Screening{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", priece=" + priece +
                ", hall=" + hall +
                ", movie=" + movie +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Screening screening = (Screening) o;

        if (id != null ? !id.equals(screening.id) : screening.id != null) return false;
        if (startTime != null ? !startTime.equals(screening.startTime) : screening.startTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        return result;
    }
}
