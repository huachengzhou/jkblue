package cn.blue.jk.mapper;

import cn.blue.jk.domain.ContractProduct;
import cn.blue.jk.pagination.Page;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ContractProductMapper {
    public List<ContractProduct> findPage(Page page) throws SQLException;        //分页查询

    public List<ContractProduct> find(Map map) throws SQLException;            //带条件查询，条件可以为null，既没有条件；返回list对象集合

    public ContractProduct get(Serializable id) throws SQLException;            //只查询一个，常用于修改

    public void insert(ContractProduct contractProduct) throws SQLException;    //插入，用实体作为参数

    public void update(ContractProduct contractProduct) throws SQLException;    //修改，用实体作为参数

    public void deleteById(Serializable id) throws SQLException;                //按id删除，删除一条；支持整数型和字符串类型ID

    /**
     * @param map ==> ids
     */
    public void delete(Map<String, Object> map);                    //批量删除；支持整数型和字符串类型ID
}
