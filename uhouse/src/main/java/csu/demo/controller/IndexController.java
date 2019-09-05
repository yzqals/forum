package csu.demo.controller;

import csu.demo.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/index")
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String viewIndex(Model model){
        model.addAttribute("user",new User());
        return "index";
    }
}
