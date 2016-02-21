package webalapu.backing;

import org.primefaces.context.RequestContext;
import webalapu.model.News;
import webalapu.service.NewsManagerLocal;
import webalapu.service.exception.NewsNotFoundException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.inject.Produces;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
@ViewScoped
public class NewsBacking extends BaseBacking implements Serializable {

    @EJB
    private NewsManagerLocal newsManager;

    private List<News> news;
    private News selectedNews;

    @Named
    @Produces
    @RequestScoped
    private News newNews = new News();

    @PostConstruct
    public void init() {
        news = newsManager.getTop5News();
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public String delete() {
        try {
            News selectedNews = getSelectedNews();

            newsManager.removeNews(selectedNews.getId());
            news.remove(selectedNews);
        } catch (NewsNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String insert() {
        System.out.println( newNews );
        newsManager.addNewNews(newNews);
        newNews = new News();
        return null;
    }

    public News getSelectedNews() {
        return selectedNews;
    }

    public void setSelectedNews(News selectedNews) {
        this.selectedNews = selectedNews;
    }

    public News getNewNews() {
        return newNews;
    }

    public void setNewNews(News newNews) {
        this.newNews = newNews;
    }
}
