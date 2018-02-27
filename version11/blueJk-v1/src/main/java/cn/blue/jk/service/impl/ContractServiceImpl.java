package cn.blue.jk.service.impl;

import cn.blue.common.other.ContractEnum;
import cn.blue.jk.domain.Contract;
import cn.blue.jk.mapper.ContractMapper;
import cn.blue.jk.pagination.Page;
import cn.blue.jk.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "contractService")
public class ContractServiceImpl implements ContractService {

    @Lazy //延迟加载
    @Autowired(required = true)//必须注入
    private ContractMapper contractMapper;

    @Cacheable(cacheNames = {"ContractServiceCache"}, keyGenerator = "keyGenerator")
    @Override
    public List<Contract> findPage(Page page) throws Exception {
        return null;
    }

    @Cacheable(cacheNames = {"ContractServiceCache"}, keyGenerator = "keyGenerator")
    @Override
    public List<Contract> find(Map paraMap) throws Exception {
        return contractMapper.find(paraMap);
    }

    @Cacheable(cacheNames = {"ContractServiceCache"}, keyGenerator = "keyGenerator")
    @Override
    public Contract get(Serializable id) throws Exception {
        return contractMapper.get(id);
    }

    @CacheEvict(cacheNames = {"ContractServiceCache"}, allEntries = true, keyGenerator = "keyGenerator")
    @Override
    public void insert(Contract contract) throws Exception {
        contractMapper.insert(contract);
    }

    @CacheEvict(cacheNames = {"ContractServiceCache"}, allEntries = true, keyGenerator = "keyGenerator")
    @Override
    public void update(Contract contract) throws Exception {
        contractMapper.update(contract);
    }

    @CacheEvict(cacheNames = {"ContractServiceCache"}, allEntries = true, keyGenerator = "keyGenerator")
    @Override
    public void deleteById(Serializable id) throws Exception {
        contractMapper.deleteById(id);
    }

    @CacheEvict(cacheNames = {"ContractServiceCache"}, allEntries = true, keyGenerator = "keyGenerator")
    @Override
    public void delete(Serializable[] ids) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ids", ids);
        contractMapper.delete(map);
    }

    @CacheEvict(cacheNames = {"ContractServiceCache"}, allEntries = true, keyGenerator = "keyGenerator")
    @Override
    public void submit(Serializable[] ids) throws Exception {
        String state = ContractEnum.CONTRACT_ENUM_submit.getVar();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ids", ids);
        map.put("state", state);
        contractMapper.updateState(map);
    }

    @CacheEvict(cacheNames = {"ContractServiceCache"}, allEntries = true, keyGenerator = "keyGenerator")
    @Override
    public void cancel(Serializable[] ids) throws Exception {
        String state = ContractEnum.CONTRACT_ENUM_cancel.getVar();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ids", ids);
        map.put("state", state);
        contractMapper.updateState(map);
    }
}
