package com.putrenkov.springmvc.dao.impl;


import com.putrenkov.springmvc.dao.StatisticsFileDao;
import com.putrenkov.springmvc.model.StatisticsFile;
import com.putrenkov.springmvc.dao.AbstractDao;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("statisticsFileDao")
public class StatisticsFileDaoImpl extends AbstractDao<Integer, StatisticsFile> implements StatisticsFileDao {

    @Override
    @SuppressWarnings("unchecked")
    public List<StatisticsFile> findAll() {
        Criteria crit = createEntityCriteria();
        return (List<StatisticsFile>)crit.list();
    }

    @Override
    public StatisticsFile findById(int id) {
        return getByKey(id);
    }

    @Override
    public void save(StatisticsFile statisticsFile) {
        persist(statisticsFile);
    }

}
