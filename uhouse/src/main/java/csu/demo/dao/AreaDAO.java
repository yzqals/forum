package csu.demo.dao;

import csu.demo.pojo.Area;

import java.util.List;

public interface AreaDAO {
    void addArea(String areaName);
    List<Area> getAreas();
    void deleteArea(int areaID);
}
