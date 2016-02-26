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
    @Column(name = "reservation_time")
    @Temporal(TemporalType.DATE)
    private Date reservationTime = new Date();

    @Basic(optional = false)
    @NotNull
    @Column(name = "used")
    private boolean used;

    @Basic(optional = false)
    @NotNull
    @Column(name = "paid")
    private boolean paid;

    @Basic(optional = false)
    @NotNull
    @Column(name = "hall_row")
    private Integer hallRow;

    @Basic(optional = false)
    @NotNull
    @Column(name = "hall_col")
    private Integer hallCol;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "screening")
    private List<Ticket> tickets;

    @JoinColumn(name = "hall_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Hall hall;

    public Screening(){

    }

    public Screening(Integer id, Date reservationTime, boolean used, boolean paid, Integer hallRow, Integer hallCol) {
        this.id = id;
        this.reservationTime = reservationTime;
        this.used = used;
        this.paid = paid;
        this.hallRow = hallRow;
        this.hallCol = hallCol;
    }

    public Screening(Date reservationTime, boolean used, boolean paid, Integer hallRow, Integer hallCol) {
        this.reservationTime = reservationTime;
        this.used = used;
        this.paid = paid;
        this.hallRow = hallRow;
        this.hallCol = hallCol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Date reservationTime) {
        this.reservationTime = reservationTime;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Integer getHallRow() {
        return hallRow;
    }

    public void setHallRow(Integer hallRow) {
        this.hallRow = hallRow;
    }

    public Integer getHallCol() {
        return hallCol;
    }

    public void setHallCol(Integer hallCol) {
        this.hallCol = hallCol;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Screening)) return false;

        Screening screening = (Screening) o;

        if (!hallCol.equals(screening.hallCol)) return false;
        if (!hallRow.equals(screening.hallRow)) return false;
        if (!reservationTime.equals(screening.reservationTime)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reservationTime.hashCode();
        result = 31 * result + hallRow.hashCode();
        result = 31 * result + hallCol.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Screening{" +
                "id=" + id +
                ", reservationTime=" + reservationTime +
                ", used=" + used +
                ", paid=" + paid +
                ", hallRow=" + hallRow +
                ", hallCol=" + hallCol +
                '}';
    }
}
