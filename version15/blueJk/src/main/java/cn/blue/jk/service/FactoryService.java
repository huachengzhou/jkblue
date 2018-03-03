package cn.blue.jk.service;

import cn.blue.jk.domain.Factory;
import cn.blue.jk.exception.ServiceException;
import cn.blue.jk.pagination.Page;

import java.util.List;
import java.util.Map;

public interface FactoryService {
    public List<Factory> findPage(Page page) throws ServiceException;        //分页查询

    public List<Factory> find(Map paraMap) throws ServiceException;            //带条件查询，条件可以为null，既没有条件；返回list对象集合

    public Factory get(String id) throws ServiceException;            //只查询一个，常用于修改

    public void insert(Factory factory) throws ServiceException;            //插入，用实体作为参数

    public void update(Factory factory) throws ServiceException;            //修改，用实体作为参数

    public void deleteById(String id) throws ServiceException;        //按id删除，删除一条；支持整数型和字符串类型ID

    public void delete(String[] ids) throws ServiceException;            //批量删除；支持整数型和字符串类型ID

    /**
     * 更新状态
     *
     * @param id
     * @throws ServiceException
     */
    public void updateStateStart(String id) throws ServiceException;

    /**
     * 更新状态 多个
     *
     * @param ids
     * @throws ServiceException
     */
    public void updateStateStart(String[] ids) throws ServiceException;

    /**
     * 更新状态
     *
     * @param id
     * @throws ServiceException
     */
    public void updateStateStop(String id) throws ServiceException;

    /**
     * 更新状态 多个
     *
     * @param ids
     * @throws ServiceException
     */
    public void updateStateStop(String[] ids) throws ServiceException;

    public List<Factory> getFactoryList() throws ServiceException;
}
