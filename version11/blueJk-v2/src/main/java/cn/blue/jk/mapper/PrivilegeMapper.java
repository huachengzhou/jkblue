package cn.blue.jk.mapper;

import cn.blue.jk.domain.Privilege;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface PrivilegeMapper {

    public List<Privilege> find(Map map) throws SQLException;                //带条件查询，条件可以为null，既没有条件；返回list对象集合

    public Privilege get(Serializable id) throws SQLException;                    //只查询一个，常用于修改

    public void insert(Privilege privilege) throws SQLException;                    //插入，用实体作为参数

    public void update(Privilege privilege) throws SQLException;                    //修改，用实体作为参数

    public void deleteById(Serializable id) throws SQLException;        //按id删除，删除一条；支持整数型和字符串类型ID

    /**
     * param ids
     *
     * @throws SQLException
     */
    public void delete(Map<String, Object> map) throws SQLException;
}
