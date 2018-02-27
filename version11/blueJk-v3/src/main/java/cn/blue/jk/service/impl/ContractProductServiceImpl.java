package cn.blue.jk.service.impl;

import cn.blue.jk.domain.ContractProduct;
import cn.blue.jk.exception.ServiceException;
import cn.blue.jk.mapper.ContractProductMapper;
import cn.blue.jk.pagination.Page;
import cn.blue.jk.service.ContractProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "contractProductService")
public class ContractProductServiceImpl implements ContractProductService {

    @Lazy //延迟加载
    @Autowired(required = true)//必须注入
    private ContractProductMapper contractProductMapper;

    @Cacheable(cacheNames = {"ContractProductServiceCache"}, keyGenerator = "keyGenerator")
    @Override
    public List<ContractProduct> findPage(Page page) {
        return null;
    }

    @Cacheable(cacheNames = {"ContractProductServiceCache"}, keyGenerator = "keyGenerator")
    @Override
    public List<ContractProduct> find(Map map) throws ServiceException {
        return contractProductMapper.find(map);
    }

    @Cacheable(cacheNames = {"ContractProductServiceCache"}, keyGenerator = "keyGenerator")
    @Override
    public List<ContractProduct> findContractId(String contractId) throws ServiceException {
        Map<String, Object> map = new HashMap<>();
        map.put("contractId",contractId);
        return contractProductMapper.find(map);
    }

    @Cacheable(cacheNames = {"ContractProductServiceCache"}, keyGenerator = "keyGenerator")
    @Override
    public ContractProduct get(Serializable id) throws ServiceException {
        return contractProductMapper.get(id);
    }

    @CacheEvict(cacheNames = {"ContractProductServiceCache"}, allEntries = true, keyGenerator = "keyGenerator")
    @Override
    public void insert(ContractProduct contractProduct) throws ServiceException {
        contractProductMapper.insert(contractProduct);
    }

    @CacheEvict(cacheNames = {"ContractProductServiceCache"}, allEntries = true, keyGenerator = "keyGenerator")
    @Override
    public void update(ContractProduct contractProduct) throws ServiceException {
        contractProductMapper.update(contractProduct);
    }

    @CacheEvict(cacheNames = {"ContractProductServiceCache"}, allEntries = true, keyGenerator = "keyGenerator")
    @Override
    public void deleteById(Serializable id) throws ServiceException {
        contractProductMapper.deleteById(id);
    }

    @CacheEvict(cacheNames = {"ContractProductServiceCache"}, allEntries = true, keyGenerator = "keyGenerator")
    @Override
    public void delete(Serializable[] ids) throws ServiceException {
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        contractProductMapper.delete(map);
    }
}
