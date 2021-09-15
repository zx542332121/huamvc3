package dao;

import pojo.Goods;
import pojo.User;
import service.SqlHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface GoodsDao {
    public List<Goods> findAllGoods() throws SQLException;
    public Goods findById(int id);
    public boolean updateOrder(Goods goods);
    public boolean delOne(int id);
    public boolean addOne(Goods goods);
    Goods findByCount(int pageNo,int pageSize);
}
