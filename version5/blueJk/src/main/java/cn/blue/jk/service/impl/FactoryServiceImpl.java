package cn.blue.jk.service.impl;

import cn.blue.common.factory.FactoryState;
import cn.blue.jk.domain.Factory;
import cn.blue.jk.mapper.FactoryMapper;
import cn.blue.jk.pagination.Page;
import cn.blue.jk.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Cacheable(value = "factoryS")
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
        return factoryMapper.get(id);
    }

    @Override
    public void insert(Factory factory) throws Exception {
        factoryMapper.insertFactory(factory);
    }

    @Override
    public void update(Factory factory) throws Exception {
        factoryMapper.update(factory);
    }

    @Override
    public void deleteById(Serializable id) throws Exception {
        factoryMapper.deleteById(id);
    }

    @Override
    public void delete(Serializable[] ids) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        factoryMapper.delete(map);
    }

    @Override
    public void updateStateStart(Serializable id) throws Exception {
        String state = FactoryState.FACTORY_STATE_START.getState();
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("state", state);
        factoryMapper.updateState(map);
    }

    @Override
    public void updateStateStop(Serializable id) throws Exception {
        String state = FactoryState.FACTORY_STATE_STOP.getState();
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("state", state);
        factoryMapper.updateState(map);
    }

    @Override
    public void updateStateStart(Serializable[] ids) throws Exception {
        String state = FactoryState.FACTORY_STATE_START.getState();
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        map.put("state", state);
        factoryMapper.updateMoreState(map);
    }

    @Override
    public void updateStateStop(Serializable[] ids) throws Exception {
        String state = FactoryState.FACTORY_STATE_STOP.getState();
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        map.put("state", state);
        factoryMapper.updateMoreState(map);
    }
}
