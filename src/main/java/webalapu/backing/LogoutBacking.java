package webalapu.backing;

import webalapu.model.User;
import webalapu.service.UserManagerLocal;
import webalapu.service.exception.UserNotFoundException;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.ServletException;

@Named
@RequestScoped
public class LogoutBacking extends BaseBacking {

    @EJB
    private UserManagerLocal userManager;

    public String login() {
        String email = getRequest().getUserPrincipal().getName();
        try {
            User user = userManager.getUserById(email);
            getContext().getExternalContext().getSessionMap().put("user", user);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String logout() {
        try {
            getContext().getExternalContext().invalidateSession();
            getRequest().logout();
            return "/public/pages/index.xhtml?faces-redirect=true";
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return null;
    }

}
