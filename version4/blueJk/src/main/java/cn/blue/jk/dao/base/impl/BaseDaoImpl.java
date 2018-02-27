package cn.blue.jk.dao.base.impl;

import cn.blue.jk.dao.base.BaseDao;
import cn.blue.jk.pagination.Page;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Component
public class BaseDaoImpl<T> implements BaseDao<T> {


    private SqlSessionFactory sqlSessionFactory;

    private String ns;//命名空间

    public BaseDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public String getNs() {
        return ns;
    }

    public void setNs(String ns) {
        this.ns = ns;
    }

    public List<T> findPage(Page page) {
        List<T> oList = sqlSessionFactory.openSession().selectList(ns + ".findPage", page);
        return oList;
    }

    public List<T> find(Map map) {
        List<T> oList = sqlSessionFactory.openSession().selectList(ns + ".find", map);
        return oList;
    }

    public T get(Serializable id) {
        return sqlSessionFactory.openSession().selectOne(ns + ".get", id);
    }

    public void insert(T entity) {
        sqlSessionFactory.openSession().insert(ns + ".insert", entity);
    }

    public void update(T entity) {
        sqlSessionFactory.openSession().update(ns + ".update", entity);
    }

    public void deleteById(Serializable id) {
        sqlSessionFactory.openSession().delete(ns + ".deleteById", id);
    }

    public void delete(Serializable[] ids) {
        sqlSessionFactory.openSession().delete(ns + ".delete", ids);
    }
}
