package com.neu.movies.dao;

import com.neu.movies.entity.Comments;
import com.neu.movies.entity.Movies;

import java.util.List;

public interface MoviesDao {
    //显示全部电影信息
    public List<Movies> showAll();
    //分页查询
    public List<Movies> pageList(int index, int size);
    //显示总记录数
    public int count();
    //模糊查询  片名 描述
    public List<Movies> selectKey(String key);
    //根据id查找电影
    public Movies findById(int id);
    //更新电影信息
    public void update(Movies m);
    //删除电影信息
    public void deleteById(int id);
    //添加电影信息
    public int addMovies(Movies m);
    //根据m_id获取评论
    public List<Comments> getIdCom(Integer m_id);
    //插入评论
    public int insertCom(Comments comments);
    //删除评论
    public void deleteCom(int id);
}
