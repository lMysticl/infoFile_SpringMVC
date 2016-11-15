package com.putrenkov.springmvc.service;


import com.putrenkov.springmvc.model.StatisticsFile;

import java.util.List;

public interface StatisticsFileService {

    StatisticsFile findById(int id);

    void saveStatisticsFile(StatisticsFile statisticsFile);

    List<StatisticsFile> findAllStatisticsFiles();

}
