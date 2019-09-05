package csu.demo.service;

import csu.demo.pojo.Area;
import csu.demo.pojo.Article;
import csu.demo.pojo.Floor;

import java.util.List;

public interface ForumService {
    void addArea(String areaName);//创建版区
    void addArticle(Article article,Floor floor);//创建主题,返回ID供插入楼层
    void addFloor(Floor floor);//跟帖
    List<Area> getAreas();//进入论坛
    List<Article> getArticleByAreaID(int areaID);//进入版区
    List<Floor> getFloorByArticleID(int articleID);//进入主题
    void deleteArea(int areaID);//删除版区(管理员限定）
    void deleteArticleByArticleID(int articleID);//删除主题（管理员限定）
    void deleteFloorByFloor(Floor floor);//删除帖子（贴主and管理员）
}
