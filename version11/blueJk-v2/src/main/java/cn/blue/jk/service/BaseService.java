package cn.blue.jk.service;

import cn.blue.jk.exception.ServiceException;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseService<T> {

    public void insert(T entity, Serializable... ids) throws ServiceException;

    public void update(T entity, Serializable... ids) throws ServiceException;

    public void delete(Serializable... ids) throws ServiceException;

    public List<T> find(Map<String, Object> map) throws ServiceException;

    public T get(Serializable id) throws ServiceException;

}
