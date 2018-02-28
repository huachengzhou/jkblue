package cn.blue.jk.service;

import cn.blue.jk.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface BaseService<T> {

    public void insert(T entity, Map<String, Object> map) throws ServiceException;

    public void update(T entity, Map<String, Object> map) throws ServiceException;

    public void delete(Map<String, Object> map) throws ServiceException;

    public List<T> find(Map<String, Object> map) throws ServiceException;

    public T get(String id, Map<String, Object> map) throws ServiceException;

}
