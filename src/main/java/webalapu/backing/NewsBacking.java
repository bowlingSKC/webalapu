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
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
@ViewScoped
public class NewsBacking extends BaseBacking implements Serializable {

    @EJB
    private NewsManagerLocal newsManager;

    private List<News> news;
    private List<News> top5News;
    private News selectedNews;

    @Named
    @Produces
    @RequestScoped
    private News newNews = new News();

    @PostConstruct
    public void init() {
        top5News = newsManager.getTop5News();

        news = newsManager.getAllNews();
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
        newsManager.addNewNews(newNews);
        news.add(newNews);

        news.sort(new Comparator<News>() {
            @Override
            public int compare(News o1, News o2) {
                if( o1.getDate().before(o2.getDate()) ) {
                    return 1;
                } else if( o1.getDate().after(o2.getDate()) ) {
                    return -1;
                }
                return 0;
            }
        });

        newNews = new News();
        return null;
    }

    public String update() {
        System.out.println( "Updated: " + selectedNews );
        return null;
    }

    public News getSelectedNews() {
        return selectedNews;
    }

    public void setSelectedNews(News selectedNews) {
        System.out.println("Selected news: " + selectedNews);
        this.selectedNews = selectedNews;
    }

    public News getNewNews() {
        return newNews;
    }

    public void setNewNews(News newNews) {
        this.newNews = newNews;
    }

    public List<News> getTop5News() {
        return top5News;
    }

    public void setTop5News(List<News> top5News) {
        this.top5News = top5News;
    }
}
