package dao;



import pojo.User;
import service.SqlHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private Connection conn;
    private PreparedStatement ps;
    public List<User> findAll() throws SQLException {
        conn = SqlHelper.getConn();
        String sql="select * from User";
        List<User> list=new ArrayList<User>();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery(sql);
        while(rs.next()){
            User user=new User();
            user.setUsername(rs.getString("userName"));
            user.setSex(rs.getString("sex"));
            user.setAge(rs.getInt("age"));
            user.setBirthday(rs.getDate("birthday"));
            list.add(user);
        }
        return list;
    }
}
