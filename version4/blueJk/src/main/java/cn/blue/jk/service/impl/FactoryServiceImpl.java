package cn.blue.jk.service.impl;

import cn.blue.jk.domain.Factory;
import cn.blue.jk.mapper.FactoryMapper;
import cn.blue.jk.pagination.Page;
import cn.blue.jk.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Service(value = "factoryService")
public class FactoryServiceImpl implements FactoryService {

    @Autowired
    FactoryMapper factoryMapper;

    @Override
    public List<Factory> findPage(Page page) throws Exception {
        return null;
    }

    @Override
    public List<Factory> find(Map paraMap) throws Exception {
        return factoryMapper.find();
    }

    @Override
    public Factory get(Serializable id) throws Exception {
        return null;
    }

    @Override
    public void insert(Factory factory) throws Exception {
        factoryMapper.insertFactory(factory);
    }

    @Override
    public void update(Factory factory) throws Exception {

    }

    @Override
    public void deleteById(Serializable id) throws Exception {

    }

    @Override
    public void delete(Serializable[] ids) throws Exception {

    }
}
