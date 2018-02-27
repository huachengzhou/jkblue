package cn.blue.jk.mapper;

import cn.blue.jk.domain.Factory;

import java.util.List;

public interface FactoryMapper {

    public List<Factory> find() throws Exception;

    public void insertFactory(Factory factory)throws Exception;
}
