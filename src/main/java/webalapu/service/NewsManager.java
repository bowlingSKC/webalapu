package webalapu.service;

import webalapu.model.News;
import webalapu.service.exception.NewsNotFoundException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Stateless
public class NewsManager implements NewsManagerLocal {

    @PersistenceContext(unitName = "cinemaUnit") //TODO: check
    EntityManager em;

    @Override
    public News getNewsById(Integer id) throws NewsNotFoundException {

        return null;
    }

    @Override
    public List<News> getAllNews() {
        List<News> news = new ArrayList<>();
        Query query = em.createQuery("SELECT n.id, n.title, n.content, n.date FROM News n");
        List<Object[]> newsList = query.getResultList();

        if( newsList == null ) {
            return news;
        }

        for(Object[] newsInfo : newsList) {
            News n = new News(
                    (Integer) newsInfo[0],
                    (String) newsInfo[1],
                    (String) newsInfo[2],
                    (Date) newsInfo[3]
            );
            news.add(n);
        }

        return news;
    }

    @Override
    public List<News> getTop5News() {
        List<News> news = new ArrayList<>();
        Query query = em.createQuery("SELECT n.id, n.title, n.content, n.date FROM News n ORDER BY n.date DESC").setMaxResults(5);
        List<Object[]> newsList = query.getResultList();

        if( newsList == null ) {
            return news;
        }

        for(Object[] newsInfo : newsList) {
            News n = new News(
                    (Integer) newsInfo[0],
                    (String) newsInfo[1],
                    (String) newsInfo[2],
                    (Date) newsInfo[3]
            );
            news.add(n);
        }

        return news;
    }

    @Override
    public void removeNews(Integer id) throws NewsNotFoundException {
        News news = em.find(News.class, id);
        if( news == null ) {
            throw new NewsNotFoundException();
        }
        em.remove(news);
        em.flush();
    }

    @Override
    public News addNewNews(News news) {
        em.persist(news);
        em.flush();
        return news;
    }

    @Override
    public News updateNews(News news) throws NewsNotFoundException {
        return null;
    }
}
