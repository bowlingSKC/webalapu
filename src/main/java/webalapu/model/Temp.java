package webalapu.model;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class Temp implements Serializable {

    private String text = "This is a test text from bean";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
