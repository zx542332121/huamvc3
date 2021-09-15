package dao.daoimpl;

import dao.GoodsDao;
import org.springframework.stereotype.Component;
import pojo.Goods;
import service.SqlHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class GoodsDaoImpl implements GoodsDao {
    private Connection conn;
    private PreparedStatement ps;
    public List<Goods> findAllGoods() throws SQLException {
        conn = SqlHelper.getConn();
        String sql="select * from Goods";
        List<Goods> list=new ArrayList<Goods>();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery(sql);
        while(rs.next()){
            Goods goods = new Goods();
            goods.setId(rs.getInt("id"));
            goods.setG_name(rs.getString("g_name"));
            goods.setG_price(rs.getDouble("g_price"));
            goods.setG_date(rs.getDate("g_date"));
            list.add(goods);
        }
        return list;
    }
    public Goods findByCount(int pageNo,int pageSize){
        conn = SqlHelper.getConn();
        Goods goods = new Goods();
        try {
            ps = conn.prepareStatement("select * from Goods limit ?,?");
            ps.setInt(1,pageNo);
            ps.setInt(1,pageSize);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                goods.setId(rs.getInt("id"));
                goods.setG_name(rs.getString("g_name"));
                goods.setG_price(rs.getDouble("g_price"));
                goods.setG_date(rs.getDate("g_date"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            SqlHelper.connClose();
        }
        return goods;
    }
    public Goods findById(int id){
        conn = SqlHelper.getConn();
        Goods goods = new Goods();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("select * from Goods where id=?");
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                goods.setId(rs.getInt("id"));
                goods.setG_name(rs.getString("g_name"));
                goods.setG_price(rs.getDouble("g_price"));
                goods.setG_date(rs.getDate("g_date"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            SqlHelper.connClose();
        }
        return goods;
    }
    public boolean updateOrder(Goods goods){
        conn = SqlHelper.getConn();
        try {
            PreparedStatement ps = conn.prepareStatement("update Goods set g_name = ?,g_price=?,g_date = ? where id = ?");
            ps.setString(1,goods.getG_name());
            ps.setDouble(2,goods.getG_price());
            ps.setDate(3,goods.getG_date());
            ps.setInt(4,goods.getId());
            int number = ps.executeUpdate();
            if(number>0){
                System.out.println("修改成功！");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    //    删除
    public boolean delOne(int id){
        conn = SqlHelper.getConn();
        try {
            PreparedStatement ps = conn.prepareStatement("delete from Goods where id = ?");
            ps.setInt(1,id);
            int i = ps.executeUpdate();
            if(i>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    //    新增
    public boolean addOne(Goods goods){
        conn = SqlHelper.getConn();
        try {
            PreparedStatement ps = conn.prepareStatement("insert into Goods (g_name,g_price,g_date,id) values (?,?,?,?)");
            ps.setString(1,goods.getG_name());
            ps.setDouble(2,goods.getG_price());
            ps.setDate(3,goods.getG_date());
            ps.setInt(4,goods.getId());
            int i = ps.executeUpdate();
            if(i>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;

    }
}
