package webalapu.service;

import webalapu.model.News;
import webalapu.service.exception.NewsNotFoundException;

import javax.ejb.Local;
import java.util.List;

@Local
public interface NewsManagerLocal {

    News getNewsById(Integer id) throws NewsNotFoundException;
    List<News> getAllNews();
    List<News> getTop5News();
    void removeNews(Integer id) throws NewsNotFoundException;
    News addNewNews(News news);
    News updateNews(News news) throws NewsNotFoundException;

}
