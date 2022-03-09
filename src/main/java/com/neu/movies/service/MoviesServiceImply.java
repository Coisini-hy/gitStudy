package com.neu.movies.service;

import com.neu.movies.dao.MoviesDao;
import com.neu.movies.dao.MoviesDaoImply;
import com.neu.movies.entity.Comments;
import com.neu.movies.entity.Movies;

import java.util.List;

public class MoviesServiceImply implements MoviesService {
    private final MoviesDao moviesDao = new MoviesDaoImply();

    @Override
    public List<Movies> showAll() {
        return moviesDao.showAll();
    }

    @Override
    public List<Movies> pageList(int index, int size) {
        return moviesDao.pageList(index,size);
    }

    @Override
    public int count() {
        return moviesDao.count();
    }

    @Override
    public List<Movies> selectKey(String key) {
        return moviesDao.selectKey(key);
    }

    @Override
    public Movies findById(int id) {
        return moviesDao.findById(id);
    }

    @Override
    public void update(Movies m) {
        moviesDao.update(m);
    }

    @Override
    public void deleteById(int id) {
        moviesDao.deleteById(id);
    }

    @Override
    public int addMovies(Movies m) {
        return moviesDao.addMovies(m);
    }

    @Override
    public List<Comments> getIdCom(Integer m_id) {
        return moviesDao.getIdCom(m_id);
    }

    @Override
    public int insertCom(Comments comments) {
        return moviesDao.insertCom(comments);
    }

    @Override
    public void deleteCom(int id) {
        moviesDao.deleteCom(id);
    }
}
