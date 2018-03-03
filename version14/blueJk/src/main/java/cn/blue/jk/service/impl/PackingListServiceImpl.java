package cn.blue.jk.service.impl;

import cn.blue.common.factory.FactoryState;
import cn.blue.jk.domain.Export;
import cn.blue.jk.domain.PackingList;
import cn.blue.jk.exception.MapperException;
import cn.blue.jk.exception.ServiceException;
import cn.blue.jk.mapper.PackingListMapper;
import cn.blue.jk.service.ExportService;
import cn.blue.jk.service.PackingListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "packingListService")
public class PackingListServiceImpl implements PackingListService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Lazy
    @Autowired
    private PackingListMapper mapper;

    @Lazy
    @Autowired
    private ExportService exportService;

    @Cacheable(value = "packingListServiceCache",keyGenerator = "keyGenerator")
    @Override
    public List<PackingList> find(Map<String, Object> map) throws ServiceException {
        return mapper.find(map);
    }

    @CacheEvict(value = "packingListServiceCache",key = "ids+'updateStop'")
    @Override
    public void updateStop(String... ids) throws ServiceException {
        String state = FactoryState.FACTORY_STATE_STOP.getState();
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        map.put("state", state);
        mapper.moreUpdate(map);
    }

    @CacheEvict(value = "packingListServiceCache",key = "ids+'updateStart'")
    @Override
    public void updateStart(String... ids) throws ServiceException {
        String state = FactoryState.FACTORY_STATE_START.getState();
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        map.put("state", state);
        mapper.moreUpdate(map);
    }

    @Cacheable(value = "packingListServiceCache",condition = "#id.length()>3")
    @Override
    public PackingList get(String id) throws ServiceException {
        return mapper.get(id);
    }

    @CacheEvict(value = "packingListServiceCache",key = "#packingList.id+'insert'")
    @Override
    public void insert(PackingList packingList) throws ServiceException {
        mapper.insert(packingList);
    }

    @CacheEvict(value = "packingListServiceCache",key = "#packingList.id+ 'update'")
    @Override
    public void update(PackingList packingList) throws ServiceException {
        mapper.update(packingList);
    }

    @CacheEvict(value = "packingListServiceCache",key = "ids+'delete'")
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

    @Cacheable(value = "packingListServiceCache",condition = "#id.length()>3")
    @Override
    public String toExportNos(String id) throws ServiceException {
        StringBuilder exportNos = new StringBuilder(1024);
        String[] ids = id.split(",");
        for (int i = 0; i < ids.length; i++) {
            Export export = exportService.get(ids[i]);
            if (i!=ids.length-1){
                if (export!=null){
                    exportNos.append(export.getCustomerContract()).append("|");
                }
            }else {
                exportNos.append(export.getCustomerContract());
            }
        }
        return exportNos.toString();
    }
}
