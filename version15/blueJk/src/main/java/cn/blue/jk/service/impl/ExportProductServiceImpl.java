package cn.blue.jk.service.impl;

import cn.blue.jk.domain.ExportProduct;
import cn.blue.jk.exception.MapperException;
import cn.blue.jk.exception.ServiceException;
import cn.blue.jk.mapper.ExportProductMapper;
import cn.blue.jk.service.ExportProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "exportProductService")
public class ExportProductServiceImpl implements ExportProductService {

    @Lazy
    @Autowired
    private ExportProductMapper mapper;

    @Cacheable(cacheNames = {"exportProductServiceCache"}, keyGenerator = "keyGenerator")
    @Override
    public List<ExportProduct> find(Map<String, Object> map) throws ServiceException {
        return mapper.find(map);
    }

    @Cacheable(cacheNames = {"exportProductServiceCache"}, keyGenerator = "keyGenerator")
    @Override
    public ExportProduct get(String id) throws ServiceException {
        return mapper.get(id);
    }

    @Override
    public void insert(ExportProduct exportProduct) throws ServiceException {
        mapper.insert(exportProduct);
    }

    @Override
    public void update(ExportProduct exportProduct) throws ServiceException {
        mapper.update(exportProduct);
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
