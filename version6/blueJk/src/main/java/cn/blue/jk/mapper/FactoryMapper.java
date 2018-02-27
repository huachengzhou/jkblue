package cn.blue.jk.mapper;

import cn.blue.jk.domain.Factory;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface FactoryMapper {

    public List<Factory> find() throws SQLException;

    public void insertFactory(Factory factory) throws SQLException;

    public void update(Factory factory) throws SQLException;


    public Factory get(Serializable id) throws SQLException;

    /**
     * 更新状态　one
     *
     * @param map
     * @throws SQLException
     */
    public void updateState(Map<String, Object> map) throws SQLException;

    /**
     * 更新状态　多个 more and more
     *
     * @param map
     * @throws SQLException
     */
    public void updateMoreState(Map<String, Object> map) throws SQLException;

    /**
     * 按id删除，删除一条；支持整数型和字符串类型
     *
     * @param id
     * @throws SQLException
     */
    public void deleteById(Serializable id) throws SQLException;

    public void delete(Map<String, Object> map) throws SQLException;
}
