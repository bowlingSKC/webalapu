package webalapu.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.ServletException;

@Named
@RequestScoped
public class LogoutBacking extends BaseBacking {

    public String logout() {
        try {
            getRequest().logout();
            return "/public/pages/index.xhtml?faces-redirect=true";
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return null;
    }

}
