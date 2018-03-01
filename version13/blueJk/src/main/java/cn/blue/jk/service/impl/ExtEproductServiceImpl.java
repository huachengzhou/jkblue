package cn.blue.jk.service.impl;

import cn.blue.jk.domain.ExtEproduct;
import cn.blue.jk.exception.MapperException;
import cn.blue.jk.exception.ServiceException;
import cn.blue.jk.mapper.ExtEproductMapper;
import cn.blue.jk.service.ExtEproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "extEproductService")
public class ExtEproductServiceImpl implements ExtEproductService {

    @Lazy
    @Autowired
    private ExtEproductMapper mapper;

    @Cacheable(cacheNames = {"extEproductServiceCache"}, keyGenerator = "keyGenerator")
    @Override
    public List<ExtEproduct> find(Map<String, Object> map) throws ServiceException {
        return mapper.find(map);
    }

    @Cacheable(cacheNames = {"extEproductServiceCache"}, keyGenerator = "keyGenerator")
    @Override
    public ExtEproduct get(String id) throws ServiceException {
        return mapper.get(id);
    }

    @Override
    public void insert(ExtEproduct extEproduct) throws ServiceException {
        mapper.insert(extEproduct);
    }

    @Override
    public void update(ExtEproduct extEproduct) throws ServiceException {
        mapper.update(extEproduct);
    }

    @Override
    public void delete(String... ids) throws ServiceException {
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        if (ids.length == 1 && ids != null) {
            String id = ids[0];
            mapper.deleteBy(id);
        } else if (ids.length > 1 && ids != null) {
            mapper.delete(map);
        } else {
            throw new MapperException();
        }
    }
}
