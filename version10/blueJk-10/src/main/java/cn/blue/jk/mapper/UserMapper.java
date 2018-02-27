package cn.blue.jk.mapper;

import cn.blue.jk.domain.User;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserMapper {
    public List<User> find(Map<String, Object> map) throws SQLException;

    public User get(Serializable id) throws SQLException;

    public void insert(User user) throws SQLException;

    /**
     * user,rid
     *
     * @param map
     * @throws Exception
     */
    public void insertUserRole(Map<String, Object> map) throws Exception;


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

    public void deleteUser_Role(Map<String, Object> map) throws SQLException;

    public void update(User user) throws SQLException;

    /**
     * username and password
     * @param map
     * @return
     * @throws SQLException
     */
    public User login(Map<String, Object> map)throws SQLException;
}
