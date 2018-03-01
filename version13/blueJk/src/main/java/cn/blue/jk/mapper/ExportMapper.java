package cn.blue.jk.mapper;

import cn.blue.jk.domain.Export;
import cn.blue.jk.exception.MapperException;

import java.util.List;
import java.util.Map;

public interface ExportMapper {
    public List<Export> find(Map<String, Object> map) throws MapperException;

    public void updateState(Map<String, Object> map) throws MapperException;

    public Export get(String id)throws MapperException;

    public void insert(Export export) throws MapperException;

    public void update(Export export) throws MapperException;

    public void delete(Map<String, Object> map)throws MapperException;

    public void deleteBy(String id)throws MapperException;
}
