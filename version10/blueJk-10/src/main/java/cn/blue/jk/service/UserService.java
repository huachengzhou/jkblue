package cn.blue.jk.service;

import cn.blue.jk.domain.User;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface UserService {
    public List<User> find(Map<String, Object> map) throws Exception;

    public User get(Serializable id) throws Exception;

    public void insert(User user, String... rids) throws Exception;

    public void update(User user, String... rids) throws Exception;


    public void delete(Serializable... ids) throws Exception;

    public User login(String username);

    public User getPassword(String username)throws Exception;
}
