package webalapu.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "director")
public class Director implements Serializable {

    private static final long serialVersionUID = 1976546465461561356L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(max = 100)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @Column(name = "personal_details")
    private String personalDetails;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "director")
    private List<Movie> movies;

    public Director() {

    }

    public Director(Integer id, String name, String personalDetails) {
        this.id = id;
        this.name = name;
        this.personalDetails = personalDetails;
    }

    public Director(String name, String personalDetails){
        this.name = name;
        this.personalDetails = personalDetails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(String personalDetails) {
        this.personalDetails = personalDetails;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Director)) return false;

        Director director = (Director) o;

        if (!name.equals(director.name)) return false;
        if (personalDetails != null ? !personalDetails.equals(director.personalDetails) : director.personalDetails != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (personalDetails != null ? personalDetails.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", personalDetails='" + personalDetails + '\'' +
                '}';
    }
}
