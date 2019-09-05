package csu.demo.dao;

import csu.demo.pojo.Floor;

import java.util.List;

public interface FloorDAO {
    void addFloor(Floor floor);
    List<Floor> getFloorByArticleID(int articleID);
    void deleteFloorByFloor(Floor floor);
}
