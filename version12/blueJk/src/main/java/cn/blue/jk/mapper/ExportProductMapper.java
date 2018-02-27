package cn.blue.jk.mapper;

import cn.blue.jk.domain.ExportProduct;
import cn.blue.jk.exception.MapperException;

import java.util.List;
import java.util.Map;

public interface ExportProductMapper {
    public List<ExportProduct> find(Map<String, Object> map) throws MapperException;

    public ExportProduct get(String id)throws MapperException;

    public void insert(ExportProduct exportProduct) throws MapperException;

    public void update(ExportProduct exportProduct) throws MapperException;

    public void delete(Map<String, Object> map)throws MapperException;

    public void deleteBy(String id)throws MapperException;
}

