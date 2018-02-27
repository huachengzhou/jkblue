package cn.blue.jk.service;

import cn.blue.jk.domain.Factory;
import cn.blue.jk.pagination.Page;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface FactoryService {
    public List<Factory> findPage(Page page) throws Exception;        //分页查询

    public List<Factory> find(Map paraMap) throws Exception;            //带条件查询，条件可以为null，既没有条件；返回list对象集合

    public Factory get(Serializable id) throws Exception;            //只查询一个，常用于修改

    public void insert(Factory factory) throws Exception;            //插入，用实体作为参数

    public void update(Factory factory) throws Exception;            //修改，用实体作为参数

    public void deleteById(Serializable id) throws Exception;        //按id删除，删除一条；支持整数型和字符串类型ID

    public void delete(Serializable[] ids) throws Exception;            //批量删除；支持整数型和字符串类型ID

    /**
     * 更新状态
     *
     * @param id
     * @throws Exception
     */
    public void updateStateStart(Serializable id) throws Exception;

    /**
     * 更新状态 多个
     *
     * @param ids
     * @throws Exception
     */
    public void updateStateStart(Serializable[] ids) throws Exception;

    /**
     * 更新状态
     *
     * @param id
     * @throws Exception
     */
    public void updateStateStop(Serializable id) throws Exception;

    /**
     * 更新状态 多个
     *
     * @param ids
     * @throws Exception
     */
    public void updateStateStop(Serializable[] ids) throws Exception;
}
