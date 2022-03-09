package com.neu.movies.dao;

import com.neu.movies.entity.Comments;
import com.neu.movies.entity.Movies;
import com.neu.utils.BaseDao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MoviesDaoImply extends BaseDao implements MoviesDao {

    /**
     * 存储数据
     *
     * @param moviesList
     */
    private void saveInfo1(List<Movies> moviesList) {
        try {
            while (rs.next()) {
                //在while循环中，每一次遍历，都是在往集合中存一个电影信息
                Movies movies = new Movies(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getDouble(5), rs.getInt(6),
                        rs.getString(7), rs.getString(8));
                moviesList.add(movies);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void saveInfo2(List<Comments> comList) {
        try {
            while (rs.next()) {
                //在while循环中，每一次遍历，都是在往集合中存一个电影信息
                Comments comments = new Comments(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getInt(4),
                        rs.getString(5), rs.getTimestamp(6));
                comList.add(comments);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Movies> showAll() {
        List<Movies> moviesList = new ArrayList<>();
        //编写sql
        String sql = "select * from movie250";
        //执行sql
        super.query(sql);
        saveInfo1(moviesList);
        return moviesList;
    }

    @Override
    public List<Movies> pageList(int index, int size) {
        //1.初始化参数用来存放书籍信息
        List<Movies> moviesList = new ArrayList<>();
        //2.编写sql
        String sql = "select * from movie250 limit ?,?";
        //3.因为继承 调用父类方法
        super.query(sql,(index-1)*size,size);
        saveInfo1(moviesList);
        return moviesList;
    }

    @Override
    public int count() {
        int count = 0;
        //编写sql
        String sql = "select count(1) from movie250";
        super.query(sql);
        try {
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<Movies> selectKey(String key) {
        List<Movies> moviesList = new ArrayList<>();
        //编写sql
        String sql = "select * from movie250 where m_name like ? or m_info like ? or m_instruction like ?";
        //执行sql
        super.query(sql, "%" + key + "%", "%" + key + "%", "%" + key + "%");
        saveInfo1(moviesList);
        return moviesList;
    }

    @Override
    public Movies findById(int id) {
        Movies movies = null;
        //编写sql
        String sql = "select * from movie250 where m_id=?";
        //执行sql
        super.query(sql, id);
        try {
            if (rs.next()) {
                movies = new Movies(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getDouble(5), rs.getInt(6),
                        rs.getString(7), rs.getString(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }

    @Override
    public void update(Movies m) {
        //编写sql
        String sql = "update movie250 set m_infoLink=?, m_picLink=?, m_name=?, m_score=?, m_rated=?, m_instruction=?, " +
                "m_info=? where m_id=?";
        //执行sql
        super.update(sql, m.getM_infoLink(), m.getM_picLink(), m.getM_name(), m.getM_score(), m.getM_rated(),
                m.getM_instruction(), m.getM_info(), m.getM_id());
    }

    @Override
    public void deleteById(int id) {
        //编写sql
        String sql = "delete from movie250 where m_id=?";
        //执行sql
        super.update(sql, id);
    }

    @Override
    public int addMovies(Movies m) {
        //编写sql
        String sql = "insert into movie250 values(0,?,?,?,?,?,?,?)";
        //执行sql
        return super.update(sql, m.getM_infoLink(), m.getM_picLink(), m.getM_name(), m.getM_score(), m.getM_rated(),
                m.getM_instruction(), m.getM_info());
    }

    @Override
    public List<Comments> getIdCom(Integer m_id) {
        List<Comments> comList = new ArrayList<>();
        //编写sql
        String sql = "select * from u_comment where m_id = ? order by ur_date desc";
        //执行sql
        super.query(sql,m_id);
        saveInfo2(comList);
        return comList;
    }

    @Override
    public int insertCom(Comments comments) {
        //编写sql
        String sql = "insert into u_comment(user_id,user_name,m_id,ur_comment) values(?,?,?,?)";
        //执行sql
        return super.update(sql,comments.getUser_id(),comments.getUser_name(),comments.getM_id(),comments.getUr_comment());
    }

    @Override
    public void deleteCom(int id) {
        //编写sql
        String sql = "delete from u_comment where ur_id=?";
        //执行sql
        super.update(sql, id);
    }
}
