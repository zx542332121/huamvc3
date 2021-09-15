package dao.daoimpl;

import junit.framework.TestCase;
import pojo.Goods;

public class GoodsDaoImplTest extends TestCase {

    public void testFindByCount() {
        GoodsDaoImpl goodsDao = new GoodsDaoImpl();
        Goods byCount = goodsDao.findByCount(1, 2);
        System.out.printf(String.valueOf(byCount));
    }
}