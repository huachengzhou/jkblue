package cn.blue.jk.service;

import cn.blue.jk.domain.PackingList;
import cn.blue.jk.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface PackingListService {
    public List<PackingList> find(Map<String, Object> map) throws ServiceException;

    public void updateStop(String... ids) throws ServiceException;

    public void updateStart(String... ids) throws ServiceException;

    public PackingList get(String id) throws ServiceException;

    public void insert(PackingList packingList) throws ServiceException;

    public void update(PackingList packingList) throws ServiceException;

    public void delete(String... ids) throws ServiceException;

    public String toExportNos(String id)throws ServiceException;
}
