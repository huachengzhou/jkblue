package cn.blue.jk.mapper;

import cn.blue.jk.exception.MapperException;
import cn.blue.jk.vo.OutProductVO;

import java.util.List;
import java.util.Map;

public interface OutProductMapper {
    public List<OutProductVO> find(Map<String,Object> map) throws MapperException;
}
