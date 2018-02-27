package cn.blue.jk.service.impl;

import cn.blue.jk.domain.Role;
import cn.blue.jk.mapper.RoleMapper;
import cn.blue.jk.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {

    @Lazy //延迟加载
    @Autowired(required = true)//必须注入
    private RoleMapper roleMapper;

    @Override
    public List<Role> find(Map map) throws Exception {
        return roleMapper.find(map);
    }

    @Override
    public Role get(Serializable id) throws Exception {
        return roleMapper.get(id);
    }

    /**
     * @param entity
     * @throws Exception
     */
    @Override
    public void insert(Role entity, String... pids) throws Exception {
        roleMapper.insert(entity);
        Map<String, Object> map = null;
        for (String s : pids) {//不提取出来
            map = new HashMap<>();
            map.put("pid", s);
            map.put("role", entity);
            roleMapper.insertRolePrivilege(map);
        }
    }

    /**
     * @param entity
     * @throws Exception
     */

    @Override
    public void update(Role entity, String... pids) throws Exception {
        Serializable[] rids = {entity.getRid()};
        Map<String, Object> map = new HashMap<>();
        map.put("ids", rids);
        roleMapper.deletePrivilege_role(map);
        update(entity);
        for (String s : pids) {//选择不提出来,涉及到了三个数据库语句有点复杂
            map = new HashMap<>();
            map.put("pid", s);
            map.put("role", entity);
            roleMapper.insertRolePrivilege(map);
        }
    }

    public void update(Role role) throws Exception {
        roleMapper.update(role);
    }


    @Override
    public void delete(Serializable... ids) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        roleMapper.delete(map);
        roleMapper.deletePrivilege_role(map);
    }
}
