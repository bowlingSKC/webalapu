package webalapu.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

//TODO: Admin kapcsolat modellezése

@Entity
@Table(name = "cinema")
public class Cinema implements Serializable {
    private static final long serialVersionUID = 19765463226456456L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(max = 50)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @NotNull
    @Size(max = 50)
    @Column(name = "city")
    private String city;

    @Basic(optional = false)
    @NotNull
    @Size(max = 255)
    @Column(name = "address")
    private String address;

    @Basic(optional = false)
    @NotNull
    @Column(name = "latitude")
    private double latitude;

    @Basic(optional = false)
    @NotNull
    @Column(name = "longitude")
    private double longitude;

    @Basic(optional = false)
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "cinema")
    private List<Hall> halls;

    @OneToOne
    @JoinColumn(name = "admin_id")
    private User manager;

    public Cinema(){

    }

    public Cinema(Integer id, String name, String city, String address, double latitude, double longitude, String description){
        this.id = id;
        this.name = name;
        this.city = city;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
    }

    public Cinema(String name, String city, String address, double latitude, double longitude, String description){
        this.name = name;
        this.city = city;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude(){ return latitude; }

    public void setLatitude(double latitude){ this.latitude = latitude; }

    public double getLongitude(){ return longitude; }

    public void setLongitude(double longitude){ this.longitude = longitude; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Hall> getHalls() {
        return halls;
    }

    public void setHalls(List<Hall> halls) {
        this.halls = halls;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cinema)) return false;

        Cinema cinema = (Cinema) o;

        if (!address.equals(cinema.address)) return false;
        if (!city.equals(cinema.city)) return false;
        if (!name.equals(cinema.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
