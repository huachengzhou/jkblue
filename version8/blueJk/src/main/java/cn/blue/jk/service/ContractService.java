package cn.blue.jk.service;

import cn.blue.jk.domain.Contract;
import cn.blue.jk.pagination.Page;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface ContractService {
    public List<Contract> findPage(Page page) throws Exception;        //分页查询

    public List<Contract> find(Map paraMap) throws Exception;            //带条件查询，条件可以为null，既没有条件；返回list对象集合

    public Contract get(Serializable id) throws Exception;            //只查询一个，常用于修改

    public void insert(Contract contract) throws Exception;            //插入，用实体作为参数

    public void update(Contract contract) throws Exception;            //修改，用实体作为参数

    public void deleteById(Serializable id) throws Exception;        //按id删除，删除一条；支持整数型和字符串类型ID

    public void delete(Serializable[] ids) throws Exception;            //批量删除；支持整数型和字符串类型ID

    public void submit(Serializable[] ids) throws Exception;            //上报

    public void cancel(Serializable[] ids) throws Exception;            //取消
}
