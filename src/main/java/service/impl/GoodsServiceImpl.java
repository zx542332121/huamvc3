package service.impl;

import cn.hwadee.utils.Page;
import dao.GoodsDao;
import dao.daoimpl.GoodsDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.Goods;
import pojo.GoodsQuery;
import service.GoodsService;

import java.sql.SQLException;
import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    @Autowired private GoodsDao goodsDao;
    public List<Goods> getAll() throws SQLException {
        return goodsDao.findAllGoods();
    }
    //根据主键查询
    public Goods getOne(int id){
//        GoodsDao goodsDao = new GoodsDaoImpl();
        return goodsDao.findById(id);
    }
    //    修改订单
    public boolean updateGoods(Goods goods) throws SQLException {
        boolean result = goodsDao.updateOrder(goods);;
        return result;
    }
    //    删除订单
    public boolean delOne(int id) throws SQLException {
        return goodsDao.delOne(id);
    }
    //    新增订单
    public boolean addOne(Goods goods) throws SQLException {
        boolean b = goodsDao.addOne(goods);
        return b;
    }

    @Override
    public Page<Goods> getPage(GoodsQuery goodsQuery) throws SQLException {
        if(goodsQuery.getPage() == null){
            goodsQuery.setPage(1);
        }
        // 设置查询的起始记录条数
        goodsQuery.setStart((goodsQuery.getPage() - 1) * goodsQuery.getSize());
        // 查询数据列表和数据总数
        List<Goods> restList = goodsDao.findAllGoods();
        Goods byCount = goodsDao.findByCount(goodsQuery.getPage(), goodsQuery.getSize());
        int size = restList.size();
        Page<Goods> page = new Page<Goods>();
        page.setTotal(size); // 数据总数
        page.setSize(goodsQuery.getSize()); // 每页显示条数
        page.setPage(goodsQuery.getPage()); // 当前页数
        page.setRows((List<Goods>) byCount); // 数据列表
        return page;
    }
}
