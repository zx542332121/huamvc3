package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.User;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/asa/{id}")
    public String queryUser(@PathVariable("id")int id, ModelMap modelMap, HttpServletRequest request){
        User user = new User();
        user.setId(id);
        user.setUsername("lisi");
        modelMap.addAttribute("User",user);
        request.setAttribute("id",user.getId());
        request.setAttribute("username",user.getUsername());
        return "User";
    }
    @RequestMapping("/asa")
    public String queryUser(ModelMap modelMap, HttpServletRequest request){
        User user = new User();
        user.setId(1);
        user.setUsername("lisi");
        modelMap.addAttribute("User",user);
        request.setAttribute("id",user.getId());
        request.setAttribute("username",user.getUsername());
        return "User";
    }
}
