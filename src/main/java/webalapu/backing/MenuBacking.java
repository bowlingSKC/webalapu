package webalapu.backing;


import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class MenuBacking {

    public String getPath(String fileName) {
        return "/public/pages/" + fileName;
    }

    public String getLoggedPath(String fileName) {
        return "/protected/" + fileName;
    }

    public String getAdminPath(String fileName) {
        return "/protected/admin/" + fileName;
    }

    public String isActive(String fileName) {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String path = req.getServletPath();

        if (path.substring(path.lastIndexOf("/") + 1).equals(fileName)){
            return " active";
        }

        return "";
    }
}
