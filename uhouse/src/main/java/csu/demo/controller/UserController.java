package csu.demo.controller;

import csu.demo.pojo.User;
import csu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/login")
    public String login(@ModelAttribute(value = "user") User user, HttpSession session){
        user=userService.getUserByAccountAndPassword(user);
        if(user!=null){
            session.setAttribute("user",user);
            return "redirect:/forum/index";
        }else {
            return "redirect:/index/index";
        }
    }
}
