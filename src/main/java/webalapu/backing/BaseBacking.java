package webalapu.backing;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class BaseBacking {

    protected FacesContext getContext() {
        return FacesContext.getCurrentInstance();
    }

    protected Map getRequestMap() {
        return getContext().getExternalContext().getRequestMap();
    }

    protected HttpServletRequest getRequest() {
        return (HttpServletRequest) getContext().getExternalContext().getRequest();
    }

    protected Object evaluteEL(String elExpression, Class beanClazz) {
        return getContext().getApplication().evaluateExpressionGet(getContext(), elExpression, beanClazz);
    }

    protected void updateValueExpression(String expression, Object value) {
        ELContext elContext = getContext().getELContext();
        ValueExpression targetExpression = getContext().getApplication().getExpressionFactory().createValueExpression(elContext, expression, Object.class);
        targetExpression.setValue(elContext, value);
    }

}
