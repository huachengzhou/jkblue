package cn.blue.jk.service;

import cn.blue.jk.domain.User;
import cn.blue.jk.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface UserService {
    public List<User> find(Map<String, Object> map) throws ServiceException;

    public User get(String id) throws ServiceException;

    public void insert(User user, String... rids) throws ServiceException;

    public void update(User user, String... rids) throws ServiceException;


    public void delete(String... ids) throws ServiceException;

    public User login(String username);

    public User getPassword(String username) throws ServiceException;
}
