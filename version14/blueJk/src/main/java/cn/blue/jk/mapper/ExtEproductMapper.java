package cn.blue.jk.mapper;

import cn.blue.jk.domain.ExtEproduct;
import cn.blue.jk.exception.MapperException;

import java.util.List;
import java.util.Map;

public interface ExtEproductMapper {
    public List<ExtEproduct> find(Map<String, Object> map) throws MapperException;

    public ExtEproduct get(String id)throws MapperException;

    public void insert(ExtEproduct extEproduct) throws MapperException;

    public void update(ExtEproduct extEproduct) throws MapperException;

    public void delete(Map<String, Object> map)throws MapperException;

    public void deleteBy(String id)throws MapperException;
}
