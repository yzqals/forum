package csu.demo.controller;

import com.sun.org.apache.bcel.internal.generic.MONITORENTER;
import csu.demo.pojo.Area;
import csu.demo.pojo.Article;
import csu.demo.pojo.Floor;
import csu.demo.pojo.User;
import csu.demo.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/forum")
public class ForumController {
    @Autowired
    private ForumService forumService;

    @RequestMapping("/index")
    public String forumIndex(Model model){
        List<Area> areaList = forumService.getAreas();
        model.addAttribute("areaList",areaList);
        return "forum";
    }

    @RequestMapping("/addArea")
    public String addArea(@RequestParam("areaName")String areaName){
        forumService.addArea(areaName);
        return "redirect:index";
    }

    @RequestMapping("/deleteArea")
    public String deleteArea(@RequestParam("areaID")int areaID){
        forumService.deleteArea(areaID);
        return "redirect:index";
    }

    @RequestMapping("/toArea")
    public String toArea(@RequestParam("areaID") int areaID,Model model,HttpSession session){
        List<Article> articleList = forumService.getArticleByAreaID(areaID);
        model.addAttribute(articleList);
        session.setAttribute("areaID",areaID);
        return "area";
    }

    @RequestMapping("/toAddArticle")
    public String toAddArticle(){
        System.out.println("进入用");
        return "addArticle";
    }

    @RequestMapping("/addArticle")
    public String addArticle(@RequestParam("title")String title,@RequestParam("content")String content, HttpSession session){
        System.out.println("功能用");
        User user=(User)session.getAttribute("user");
        Article article=new Article();
        Floor floor = new Floor();
        int areaID=(Integer) session.getAttribute("areaID");
        article.setTitle(title);
        article.setAccount(user.getAccount());
        article.setAreaID(areaID);
        floor.setAccount(user.getAccount());
        floor.setFloorNumber(1);//这里新建的主题楼层必为第一层
        floor.setContent(content);
        forumService.addArticle(article,floor);
        return "redirect:toArea?areaID="+areaID;
    }

    @RequestMapping("toArticle")
    public String toArticle(@RequestParam("articleID")int articleID,Model model,HttpSession session){
        session.setAttribute("articleID",articleID);
        List<Floor> floorList = forumService.getFloorByArticleID(articleID);
        model.addAttribute("floorList",floorList);
        return "article";
    }

    @RequestMapping("deleteArticle")
    public String deleteArticle(@RequestParam("articleID")int articleID,HttpSession session){
        int areaID = (Integer)session.getAttribute("areaID");
        forumService.deleteArticleByArticleID(articleID);
        return "redirect:toArea?areaID="+areaID;
    }

    @RequestMapping("addFloor")
    public String addFloor(@RequestParam("content")String content,HttpSession session){
        int articleID =(Integer)session.getAttribute("articleID");
        User user=(User)session.getAttribute("user");
        Floor floor=new Floor();
        floor.setArticleID(articleID);
        floor.setContent(content);
        floor.setAccount(user.getAccount());
        forumService.addFloor(floor);
        return "redirect:toArticle?articleID="+articleID;
    }

    @RequestMapping("deleteFloor")
    public String deleteFloor(@RequestParam("articleID")int articleID,@RequestParam("floorNumber")int floorNumber){
        Floor floor=new Floor();
        floor.setFloorNumber(floorNumber);
        floor.setArticleID(articleID);
        forumService.deleteFloorByFloor(floor);
        return "redirect:toArticle?articleID="+articleID;
    }
}
