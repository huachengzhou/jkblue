package cn.blue.jk.service.impl;

import cn.blue.jk.domain.ExtCproduct;
import cn.blue.jk.domain.SysCode;
import cn.blue.jk.exception.ServiceException;
import cn.blue.jk.mapper.ExtCproductMapper;
import cn.blue.jk.mapper.SysCodeMapper;
import cn.blue.jk.service.ExtCproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "extCproductService")
public class ExtCproductServiceImpl implements ExtCproductService {
    private final String sysCodeB = "0104";
    @Lazy
    @Autowired
    private ExtCproductMapper extCproductMapper;

    @Lazy
    @Autowired
    private SysCodeMapper sysCodeMapper;

    /**
     * @param parent_id
     * @return
     * @throws ServiceException
     */
    @Cacheable(cacheNames = {"ExtCproductServiceCache"}, keyGenerator = "keyGenerator")
    @Override
    public List<SysCode> findSysCode(String parent_id) throws ServiceException {
        Map<String, Object> map = new HashMap<>();
        if (parent_id == null) parent_id = sysCodeB;
        map.put("parent_id", parent_id);
        return sysCodeMapper.find(map);
    }

    @Cacheable(cacheNames = {"ExtCproductServiceCache"}, keyGenerator = "keyGenerator")
    @Override
    public void insert(ExtCproduct entity) throws ServiceException {
        extCproductMapper.insert(entity);
    }

    @CacheEvict(cacheNames = {"ExtCproductServiceCache"},keyGenerator = "keyGenerator",allEntries = true)
    @Override
    public void update(ExtCproduct entity) throws ServiceException {
        extCproductMapper.update(entity);
    }

    @CacheEvict(cacheNames = {"ExtCproductServiceCache"},keyGenerator = "keyGenerator",allEntries = true)
    @Override
    public void delete(String... ids) throws ServiceException {
        if (ids.length == 1) {
            extCproductMapper.deleteById(ids[0]);
        } else {
            Map<String, Object> map = new HashMap<>();
            map.put("ids", ids);
            extCproductMapper.delete(map);
        }
    }

    @CacheEvict(cacheNames = {"ExtCproductServiceCache"},keyGenerator = "keyGenerator",allEntries = true)
    @Override
    public List<ExtCproduct> find(Map<String, Object> map) throws ServiceException {
        return extCproductMapper.find(map);
    }

    @Cacheable(cacheNames = {"ExtCproductServiceCache"}, keyGenerator = "keyGenerator")
    @Override
    public ExtCproduct get(String id) throws ServiceException {
        return extCproductMapper.get(id);
    }
}
