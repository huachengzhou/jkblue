package cn.blue.jk.service.impl;

import cn.blue.common.factory.FactoryState;
import cn.blue.jk.domain.Factory;
import cn.blue.jk.mapper.FactoryMapper;
import cn.blue.jk.pagination.Page;
import cn.blue.jk.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "factoryService")
public class FactoryServiceImpl implements FactoryService {
    /*
     *
     * @CacheEvict：主要对方法配置，用来标记要清空缓存的方法，当这个方法被调用并满足一定条件后，即会清空缓存
     * value：缓存的位置，不能为空。
     * key：缓存的key，默认为空。
     * allEntries：true表示清除value中的全部缓存，默认为false。
     * condition：触发的条件，只有满足条件的情况才会清楚缓存，默认为空，支持SpEL。
     *
     * Cacheable既可以是类也可以是方法而CachePut就只能是方法
     *
     * CachePut cache method
     * */

    @Autowired
    FactoryMapper factoryMapper;

    @Override
    public List<Factory> findPage(Page page) throws Exception {
        return null;
    }

    /**
     * 使用缓存　并且使用自定义的key生成器生成缓存 --下面的方法都是同样原理
     *
     * @param paraMap
     * @return
     * @throws Exception
     */
    @Cacheable(cacheNames = {"factoryS"}, keyGenerator = "keyGenerator")
    @Override
    public List<Factory> find(Map paraMap) throws Exception {
        return factoryMapper.find();
    }

    @Cacheable(cacheNames = {"factoryS"}, keyGenerator = "keyGenerator")
    @Override
    public Factory get(Serializable id) throws Exception {
        return factoryMapper.get(id);
    }

    /**
     * 在方法调用前不会删除缓存,调用之后就会删除掉缓存,相当于标记为清除缓存,由于不好判断数据,
     * 因此不能够编写condition条件,当然还是同样使用一样的key生成器
     *
     * @param id
     * @throws Exception
     */
    @CacheEvict(cacheNames = {"factoryS"}, allEntries = true, keyGenerator = "keyGenerator")
    @Override
    public void deleteById(Serializable id) throws Exception {
        factoryMapper.deleteById(id);
    }

    @CacheEvict(cacheNames = {"factoryS"}, allEntries = true, keyGenerator = "keyGenerator")
    @Override
    public void delete(Serializable[] ids) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        factoryMapper.delete(map);
    }

    /**
     * 主要针对方法的配置，能够根据方法的请求参数对其结果进行缓存，和@Cacheable不同的是，它每次都会触发真实方法的调用。
     * 不再配置CachePut还是改为CacheEvict,由于测试结果得到没写condition似乎不能够引用呢
     * @param factory
     * @throws Exception
     */
    @CacheEvict(cacheNames = {"factoryS"}, allEntries = true, keyGenerator = "keyGenerator")
    @Override
    public void insert(Factory factory) throws Exception {
        factoryMapper.insertFactory(factory);
    }

    @CacheEvict(cacheNames = {"factoryS"}, allEntries = true, keyGenerator = "keyGenerator")
    @Override
    public void update(Factory factory) throws Exception {
        factoryMapper.update(factory);
    }

    @CacheEvict(cacheNames = {"factoryS"}, allEntries = true, keyGenerator = "keyGenerator")
    @Override
    public void updateStateStart(Serializable id) throws Exception {
        String state = FactoryState.FACTORY_STATE_START.getState();
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("state", state);
        factoryMapper.updateState(map);
    }

    @CacheEvict(cacheNames = {"factoryS"}, allEntries = true, keyGenerator = "keyGenerator")
    @Override
    public void updateStateStop(Serializable id) throws Exception {
        String state = FactoryState.FACTORY_STATE_STOP.getState();
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("state", state);
        factoryMapper.updateState(map);
    }

    @CachePut(cacheNames = {"factoryS"}, keyGenerator = "keyGenerator")
    @Override
    public void updateStateStart(Serializable[] ids) throws Exception {
        String state = FactoryState.FACTORY_STATE_START.getState();
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        map.put("state", state);
        factoryMapper.updateMoreState(map);
    }

    @CachePut(cacheNames = {"factoryS"}, keyGenerator = "keyGenerator")
    @Override
    public void updateStateStop(Serializable[] ids) throws Exception {
        String state = FactoryState.FACTORY_STATE_STOP.getState();
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        map.put("state", state);
        factoryMapper.updateMoreState(map);
    }
}
