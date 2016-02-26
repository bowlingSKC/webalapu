package webalapu.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "screening_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Screening screening;

    @JoinColumn(name = "user_id", referencedColumnName = "email")
    @ManyToOne(optional = false)
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @Basic(optional = false)
    @NotNull
    @Column(name = "reservation_time")
    private Date reservationTime;

    @Basic(optional = false)
    @Column(name = "used")
    private boolean used;

    @Basic(optional = false)
    @Column(name = "paid")
    private boolean paid;

    @Basic(optional = false)
    @Column(name = "hall_row")
    private Integer hallRow;

    @Basic(optional = false)
    @Column(name = "hall_col")
    private Integer hallCol;

    public Ticket() {

    }

    public Ticket(Screening screening, User user, Date reservationTime, boolean used, boolean paid, Integer hallRow, Integer hallCol) {
        this.screening = screening;
        this.user = user;
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

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

}
