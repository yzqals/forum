package csu.demo.service.impl;

import csu.demo.dao.AreaDAO;
import csu.demo.dao.ArticleDAO;
import csu.demo.dao.FloorDAO;
import csu.demo.pojo.Area;
import csu.demo.pojo.Article;
import csu.demo.pojo.Floor;
import csu.demo.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumServiceImpl implements ForumService {
    @Autowired
    private AreaDAO areaDAO;
    @Autowired
    private ArticleDAO articleDAO;
    @Autowired
    private FloorDAO floorDAO;


    @Override
    public void addArea(String areaName) {
        areaDAO.addArea(areaName);
    }

    @Override
    public void addArticle(Article article,Floor floor) {
        articleDAO.addArticle(article);
        floor.setArticleID(article.getArticleID());
        floorDAO.addFloor(floor);
    }

    @Override
    public void addFloor(Floor floor) {//逻辑上应该在插入楼层成功后再主题楼层数+1
        floor.setFloorNumber(articleDAO.getFloors(floor.getArticleID())+1);
        floorDAO.addFloor(floor);
        articleDAO.updateArticle(floor.getArticleID());
    }

    @Override
    public List<Area> getAreas() {
        return areaDAO.getAreas();
    }

    @Override
    public List<Article> getArticleByAreaID(int areaID) {
        return articleDAO.getArticleByAreaID(areaID);
    }

    @Override
    public List<Floor> getFloorByArticleID(int articleID) {
        return floorDAO.getFloorByArticleID(articleID);
    }

    public void deleteArea(int areaID) {
        areaDAO.deleteArea(areaID);
    }

    @Override
    public void deleteArticleByArticleID(int articleID) {
        articleDAO.deleteArticle(articleID);
    }

    @Override
    public void deleteFloorByFloor(Floor floor) {
        floorDAO.deleteFloorByFloor(floor);
    }
}
