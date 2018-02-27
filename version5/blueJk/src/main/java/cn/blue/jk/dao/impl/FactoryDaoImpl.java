package cn.blue.jk.dao.impl;

import cn.blue.jk.dao.FactoryDao;
import cn.blue.jk.dao.base.BaseDao;
import cn.blue.jk.domain.Factory;
import cn.blue.jk.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Repository
public class FactoryDaoImpl implements FactoryDao {

    @Autowired
    BaseDao<Factory> baseDao;

    @Override
    public List<Factory> findPage(Page page) {
        return null;
    }

    @Override
    public List<Factory> find(Map paraMap) {
        return baseDao.find(paraMap);
    }

    @Override
    public Factory get(Serializable id) {
        return null;
    }

    @Override
    public void insert(Factory entity) {

    }

    @Override
    public void update(Factory entity) {

    }

    @Override
    public void deleteById(Serializable id) {

    }

    @Override
    public void delete(Serializable[] ids) {

    }
}
