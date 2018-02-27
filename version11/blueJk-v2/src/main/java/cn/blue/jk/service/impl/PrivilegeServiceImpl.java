package cn.blue.jk.service.impl;

import cn.blue.jk.domain.Privilege;
import cn.blue.jk.mapper.PrivilegeMapper;
import cn.blue.jk.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public List<Privilege> find(Map map) throws Exception {
        return privilegeMapper.find(map);
    }

    @Override
    public Privilege get(Serializable id) throws Exception {
        return privilegeMapper.get(id);
    }

    @Override
    public void insert(Privilege entity) throws Exception {
        privilegeMapper.insert(entity);
    }

    @Override
    public void update(Privilege entity) throws Exception {
        privilegeMapper.update(entity);
    }

    @Override
    public void deleteById(Serializable id) throws Exception {
        privilegeMapper.deleteById(id);
    }

    @Override
    public void delete(Serializable... ids) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        privilegeMapper.delete(map);
    }
}
