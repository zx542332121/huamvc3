package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Goods;
import service.GoodsService;
import service.impl.GoodsServiceImpl;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired private  GoodsService goodsService;
    @RequestMapping("/all")
    public String goodsFind(Model model){
        try {
            List<Goods> list = goodsService.getAll();
            model.addAttribute("list",list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "goods";
    }
//    打开修改
    @RequestMapping("/update/{id}")
    public String updateGoods(@PathVariable("id")int id, ModelMap modelMap){
        Goods goods = goodsService.getOne(id);
        modelMap.addAttribute("goods",goods);
        return "edit";
    }
    /*
修改执行
 */
    @RequestMapping(value = "/doUpdate")
    public String doUpdate(Goods goods,ModelMap modelMap) throws SQLException {
        boolean rs = goodsService.updateGoods(goods);
        if(rs){
            List<Goods> list = goodsService.getAll();
            modelMap.addAttribute("list",list);
            return "goods";
        }
        modelMap.addAttribute("result","修改失败");
        return "goods";
    }
//    删除
    @RequestMapping("/del/{id}")
    public String del(@PathVariable("id") int id,ModelMap modelMap){
        try {
            boolean b = goodsService.delOne(id);
            if (b){
                List<Goods> list = goodsService.getAll();
                modelMap.addAttribute("list",list);
                return "goods";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "goods";
    }
//    新增
    @RequestMapping("/doAdd")
    public String addGoods(Goods goods,ModelMap modelMap) throws SQLException {
        boolean b = goodsService.addOne(goods);
        if (b){
            List<Goods> list = goodsService.getAll();
            modelMap.addAttribute("list",list);
            return "goods";
        }
        return "goods";
    }
}
