package webalapu.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

//TODO: Mozi kapcsolat modellezése

@Entity
@Table(name = "hall")
public class Hall implements Serializable{
    private static final long serialVersionUID = 19765461754653456L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(max = 20)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @NotNull
    @Column(name = "rows")
    private Integer rows;

    @Basic(optional = false)
    @NotNull
    @Column(name = "cols")
    private Integer cols;

    public Hall() {

    }

    public Hall(Integer id, String name, Integer rows, Integer cols) {
        this.id = id;
        this.name = name;
        this.rows = rows;
        this.cols = cols;
    }

    public Hall(String name, Integer rows, Integer cols) {
        this.name = name;
        this.rows = rows;
        this.cols = cols;
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

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getCols() {
        return cols;
    }

    public void setCols(Integer cols) {
        this.cols = cols;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hall)) return false;

        Hall hall = (Hall) o;

        if (!cols.equals(hall.cols)) return false;
        if (!name.equals(hall.name)) return false;
        if (!rows.equals(hall.rows)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + rows.hashCode();
        result = 31 * result + cols.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Hall{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rows=" + rows +
                ", cols=" + cols +
                '}';
    }
}
