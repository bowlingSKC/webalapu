package webalapu.backing;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@SessionScoped
@ManagedBean(name = "localizationBacking", eager = true)
public class LocalizationBacking implements Serializable{
    private static final long serialVersionUID = 1L;
    private static Map<String,Object> countries;
    private Locale locale;

    static{
        countries = new LinkedHashMap<>();
        countries.put("English", Locale.ENGLISH);
        countries.put("Hungarian", new Locale("hu"));
    }

    public LocalizationBacking(){
        this.locale = new Locale("hu");
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public void localeChanged(String language){
        for (Map.Entry<String, Object> entry : countries.entrySet()) {
            if(entry.getKey().equals(language)){
                locale = (Locale)entry.getValue();
                FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
            }
        }

    }

    public String testLocale(){
        System.out.println(locale.getDisplayLanguage());
        return "";
    }

    public String setDefaultLocale(){
        locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        return "";
    }
}
