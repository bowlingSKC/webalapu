package webalapu.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @Basic(optional = false)
    @Size(min = 5, max = 100)
    @Column(name = "email")
    private String email;

    @Basic(optional = false)
    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "first_name")
    private String firstName;

    @Basic(optional = false)
    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "last_name")
    private String lastName;

    @Basic(optional = false)
    @NotNull
    @Column(name = "password")
    private String password;

    @Transient
    private String password2;

    @Basic(optional = false)
    @Column(name = "credit")
    private Integer credit;

    public User() {

    }

    public User(String email, String firstName, String lastName, String password, Integer credit) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.credit = credit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }
}
