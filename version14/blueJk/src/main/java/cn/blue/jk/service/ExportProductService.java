package cn.blue.jk.service;

import cn.blue.jk.domain.ExportProduct;
import cn.blue.jk.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface ExportProductService {
    public List<ExportProduct> find(Map<String, Object> map) throws ServiceException;

    public ExportProduct get(String id)throws ServiceException;

    public void insert(ExportProduct exportProduct) throws ServiceException;

    public void update(ExportProduct exportProduct) throws ServiceException;

    public void delete(String...ids)throws ServiceException;

}
