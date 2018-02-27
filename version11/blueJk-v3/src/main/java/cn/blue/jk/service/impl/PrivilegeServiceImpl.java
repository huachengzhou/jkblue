package cn.blue.jk.service.impl;

import cn.blue.jk.domain.Privilege;
import cn.blue.jk.exception.ServiceException;
import cn.blue.jk.mapper.PrivilegeMapper;
import cn.blue.jk.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("privilegeService")
public class PrivilegeServiceImpl implements PrivilegeService {
    @Lazy //延迟加载
    @Autowired(required = true)//必须注入
    private PrivilegeMapper privilegeMapper;

    @Cacheable(cacheNames = {"PrivilegeServiceCache"}, keyGenerator = "keyGenerator")
    @Override
    public List<Privilege> find(Map map) throws ServiceException {
        return privilegeMapper.find(map);
    }

    @Cacheable(cacheNames = {"PrivilegeServiceCache"}, keyGenerator = "keyGenerator")
    @Override
    public Privilege get(Serializable id) throws ServiceException {
        return privilegeMapper.get(id);
    }

    @Cacheable(cacheNames = {"PrivilegeServiceCache"}, keyGenerator = "keyGenerator")
    @Override
    public void insert(Privilege entity) throws ServiceException {
        privilegeMapper.insert(entity);
    }

    @Cacheable(cacheNames = {"PrivilegeServiceCache"}, keyGenerator = "keyGenerator")
    @Override
    public void update(Privilege entity) throws ServiceException {
        privilegeMapper.update(entity);
    }

    @Cacheable(cacheNames = {"PrivilegeServiceCache"}, keyGenerator = "keyGenerator")
    @Override
    public void deleteById(Serializable id) throws ServiceException {
        privilegeMapper.deleteById(id);
    }

    @Cacheable(cacheNames = {"PrivilegeServiceCache"}, keyGenerator = "keyGenerator")
    @Override
    public void delete(Serializable... ids) throws ServiceException {
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        privilegeMapper.delete(map);
    }
}
