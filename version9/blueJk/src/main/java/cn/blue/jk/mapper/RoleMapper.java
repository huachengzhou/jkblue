package cn.blue.jk.mapper;

import cn.blue.jk.domain.Role;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface RoleMapper {
    public List<Role> find(Map map) throws SQLException;                //带条件查询，条件可以为null，既没有条件；返回list对象集合

    public Role get(Serializable id) throws SQLException;                    //只查询一个，常用于修改

    public void insert(Role role) throws SQLException;

    /**
     * role,pid
     *
     * @param map
     * @throws Exception
     */
    public void insertRolePrivilege(Map<String, Object> map) throws Exception;


    /**
     * param ids
     *
     * @throws SQLException
     */
    public void delete(Map<String, Object> map) throws SQLException;

    /**
     * ids
     *
     * @param map
     * @throws SQLException
     */

    public void deletePrivilege_role(Map<String, Object> map) throws SQLException;

    public void update(Role role) throws SQLException;

}
