package cn.blue.jk.service;

import cn.blue.jk.domain.Privilege;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface PrivilegeService {
    public List<Privilege> find(Map map) throws Exception;                //带条件查询，条件可以为null，既没有条件；返回list对象集合

    public Privilege get(Serializable id) throws Exception;                    //只查询一个，常用于修改

    public void insert(Privilege entity) throws Exception;                    //插入，用实体作为参数

    public void update(Privilege entity) throws Exception;                    //修改，用实体作为参数

    public void deleteById(Serializable id) throws Exception;        //按id删除，删除一条；支持整数型和字符串类型ID

    public void delete(Serializable...ids)throws Exception;
}
