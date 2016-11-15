package com.putrenkov.springmvc.service.impl;

import com.putrenkov.springmvc.dao.StatisticsFileDao;
import com.putrenkov.springmvc.model.StatisticsFile;
import com.putrenkov.springmvc.service.StatisticsFileService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service("statisticsFileService")
@Transactional
public class StatisticsFileServiceImpl implements StatisticsFileService {

    @Autowired
    StatisticsFileDao dao;

    @Override
    public List<StatisticsFile> findAllStatisticsFiles() {
        return dao.findAll();
    }


    public StatisticsFile findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void saveStatisticsFile(StatisticsFile statisticsFile) {
            dao.save(statisticsFile);
    }
}
