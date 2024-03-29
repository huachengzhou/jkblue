package cn.blue.jk.service.impl;

import cn.blue.common.help.ZhouBase64;
import cn.blue.jk.domain.User;
import cn.blue.jk.exception.ServiceException;
import cn.blue.jk.mapper.UserMapper;
import cn.blue.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Lazy //延迟加载
    @Autowired(required = true)//必须注入
    private UserMapper userMapper;

    @Cacheable(cacheNames = {"UserServiceCache"}, keyGenerator = "keyGenerator")
    @Override
    public List<User> find(Map<String, Object> map) throws ServiceException {
        return userMapper.find(map);
    }


    @Cacheable(cacheNames = {"UserServiceCache"}, keyGenerator = "keyGenerator")
    @Override
    public User get(Serializable id) throws ServiceException {
        return userMapper.get(id);
    }

    @Cacheable(cacheNames = {"UserServiceCache"}, keyGenerator = "keyGenerator")
    @Override
    public void insert(User user, String... rids) throws ServiceException {
        userMapper.insert(user);
        Map<String, Object> map = null;
        for (String s : rids) {//不提取出来
            map = new HashMap<>();
            map.put("rid", s);
            map.put("user", user);
            userMapper.insertUserRole(map);
        }
    }

    @Cacheable(cacheNames = {"UserServiceCache"}, keyGenerator = "keyGenerator")
    @Override
    public void update(User user, String... rids) throws ServiceException {
        Serializable[] uids = {user.getUid()};
        Map<String, Object> map = new HashMap<>();
        map.put("ids", uids);
        userMapper.deleteUser_Role(map);
        update(user);
        for (String s : rids) {//选择不提出来,涉及到了三个数据库语句有点复杂
            map = new HashMap<>();
            map.put("rid", s);
            map.put("user", user);
            userMapper.insertUserRole(map);
        }
    }


    public void update(User user) throws ServiceException {
        userMapper.update(user);
    }

    @Cacheable(cacheNames = {"UserServiceCache"}, keyGenerator = "keyGenerator")
    @Override
    public void delete(Serializable... ids) throws ServiceException {
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        userMapper.delete(map);
        userMapper.deleteUser_Role(map);
    }

    @Cacheable(cacheNames = {"UserServiceCache"}, keyGenerator = "keyGenerator")
    @Override
    public User login(String username) {
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        try {
            return userMapper.login(map);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Cacheable(cacheNames = {"UserServiceCache"}, keyGenerator = "keyGenerator")
    @Override
    public User getPassword(String username) throws ServiceException {
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        User user = userMapper.login(map);
        if (user != null) {
            String id = user.getUid();
            String password = user.getPassword();
            password = ZhouBase64.isDecode(password);
            int index = id.length();
            password = password.substring(index, password.length());
            user.setPassword(password);
        }
        return user;
    }
}
