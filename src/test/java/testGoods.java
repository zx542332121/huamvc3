import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.Goods;
import service.GoodsService;

import java.sql.SQLException;
import java.util.List;

@ContextConfiguration("classpath:springApplication.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class testGoods {
    @Autowired private BeanFactory beanFactory;
    @Test
    public void testOne(){
        GoodsService goodsService = beanFactory.getBean("goodsService", GoodsService.class);
        try {
            List<Goods> all = goodsService.getAll();
            for (Goods goods:all){
                System.out.printf(String.valueOf(goods));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
