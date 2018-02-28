package cn.blue.jk.service;

import cn.blue.jk.domain.ExtCproduct;
import cn.blue.jk.domain.SysCode;
import cn.blue.jk.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface ExtCproductService{
    public static String contractProductId = "contractProductId";

    /**
     * @param parent_id
     * @return
     * @throws ServiceException
     */
    public List<SysCode> findSysCode(String parent_id) throws ServiceException;

    public void insert(ExtCproduct entity) throws ServiceException;

    public void update(ExtCproduct entity) throws ServiceException;

    public void delete(String...ids) throws ServiceException;

    /**
     * contractProductId
     * @param map
     * @return
     * @throws ServiceException
     */
    public List<ExtCproduct> find(Map<String, Object> map) throws ServiceException;

    public ExtCproduct get(String id) throws ServiceException;
}
