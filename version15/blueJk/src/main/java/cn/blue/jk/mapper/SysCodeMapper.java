package cn.blue.jk.mapper;

import cn.blue.jk.domain.SysCode;
import cn.blue.jk.exception.MapperException;

import java.util.List;
import java.util.Map;

public interface SysCodeMapper {
    /**
     * parent_id
     * @param map
     * @return
     * @throws MapperException
     */
    public List<SysCode> find(Map<String, Object> map) throws MapperException;
}
