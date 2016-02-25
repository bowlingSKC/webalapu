package webalapu.backing;

import webalapu.model.User;
import webalapu.service.UserManagerLocal;
import webalapu.service.exception.UserAlreadyException;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class UserAddBacking extends BaseBacking implements Serializable {

    @EJB
    private UserManagerLocal userManager;

    private String infoMessage;

    @Named
    @Produces
    @RequestScoped
    private User newUser = new User();

    public String registerUser() {
        if( !newUser.getPassword().equals(newUser.getPassword2()) ) {
            getContext().addMessage(null, new FacesMessage("A két jelszó nem egyezik!"));
            return null;
        }

        try {
            userManager.register(newUser);
            infoMessage = "Sikeres regsisztrálás!";
            newUser = new User();
        } catch (UserAlreadyException ex) {
            infoMessage = "Ilyen E-mail cím már regisztálva van a rendszerben!";
        } catch (Exception ex) {
            getContext().addMessage(null, new FacesMessage("Hiba történt a regisztrálás közben!"));
        }

        return null;
    }

    public String getInfoMessage() {
        return infoMessage;
    }

    public void setInfoMessage(String infoMessage) {
        this.infoMessage = infoMessage;
    }
}
