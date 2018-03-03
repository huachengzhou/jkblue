package cn.blue.jk.mapper;

import cn.blue.jk.domain.PackingList;
import cn.blue.jk.exception.MapperException;

import java.util.List;
import java.util.Map;

public interface PackingListMapper {

    public List<PackingList> find(Map<String, Object> map) throws MapperException;

    public PackingList get(String id) throws MapperException;

    public void insert(PackingList packingList) throws MapperException;

    public void update(PackingList packingList) throws MapperException;

    public void moreUpdate(Map<String, Object> map)throws MapperException;

    public void delete(Map<String, Object> map) throws MapperException;

    public void deleteBy(String id) throws MapperException;


}
