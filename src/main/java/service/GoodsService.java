package service;

import cn.hwadee.utils.Page;
import dao.GoodsDao;
import pojo.Goods;
import pojo.GoodsQuery;

import java.sql.SQLException;
import java.util.List;

public interface GoodsService {
    List<Goods> getAll() throws SQLException;
    Goods getOne(int id);
    boolean updateGoods(Goods goods) throws SQLException;
    boolean delOne(int id) throws SQLException;
    boolean addOne(Goods goods) throws SQLException;
    Page<Goods> getPage(GoodsQuery goodsQuery) throws SQLException;
}
