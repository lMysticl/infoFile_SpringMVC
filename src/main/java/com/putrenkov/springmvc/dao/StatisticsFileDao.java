package com.putrenkov.springmvc.dao;

import com.putrenkov.springmvc.model.StatisticsFile;

import java.util.List;


public interface StatisticsFileDao {

    List<StatisticsFile> findAll();

    StatisticsFile findById(int id);

    void save(StatisticsFile statisticsFile);
}
