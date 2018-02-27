package cn.blue.jk.mapper;

import cn.blue.jk.domain.Factory;
import cn.blue.jk.exception.MapperException;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface FactoryMapper {

    public List<Factory> find(Map<String, Object> map) throws MapperException;

    public void insertFactory(Factory factory) throws MapperException;

    public void update(Factory factory) throws MapperException;


    public Factory get(Serializable id) throws MapperException;

    /**
     * 更新状态　one
     *
     * @param map
     * @throws MapperException
     */
    public void updateState(Map<String, Object> map) throws MapperException;

    /**
     * 更新状态　多个 more and more
     *
     * @param map
     * @throws MapperException
     */
    public void updateMoreState(Map<String, Object> map) throws MapperException;

    /**
     * 按id删除，删除一条；支持整数型和字符串类型
     *
     * @param id
     * @throws MapperException
     */
    public void deleteById(Serializable id) throws MapperException;

    public void delete(Map<String, Object> map) throws MapperException;
}
