package cn.blue.jk.service;

import cn.blue.jk.domain.ExtEproduct;
import cn.blue.jk.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface ExtEproductService {
    public List<ExtEproduct> find(Map<String, Object> map) throws ServiceException;

    public ExtEproduct get(String id)throws ServiceException;

    public void insert(ExtEproduct extEproduct) throws ServiceException;

    public void update(ExtEproduct extEproduct) throws ServiceException;

    public void delete(String...ids)throws ServiceException;

}
