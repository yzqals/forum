package csu.demo.dao;

import csu.demo.pojo.Article;

import java.util.List;

public interface ArticleDAO {
    List<Article> getArticleByAreaID(int areaID);
    int addArticle(Article article);
    int getFloors(int articleID);
    void deleteArticle(int articleID);
    void updateArticle(int articleID);
}
