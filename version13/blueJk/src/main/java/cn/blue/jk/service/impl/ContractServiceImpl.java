package cn.blue.jk.service.impl;

import cn.blue.common.other.ContractEnum;
import cn.blue.jk.domain.Contract;
import cn.blue.jk.exception.ServiceException;
import cn.blue.jk.mapper.ContractMapper;
import cn.blue.jk.pagination.Page;
import cn.blue.jk.service.ContractService;
import cn.blue.jk.vo.ContractVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

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
    public List<Contract> findPage(Page page) throws ServiceException {
        return null;
    }

    @Cacheable(cacheNames = {"ContractServiceCache"}, keyGenerator = "keyGenerator")
    @Override
    public List<ContractVO> find(Map paraMap) throws ServiceException {
        return contractMapper.find(paraMap);
    }

    @Cacheable(cacheNames = {"ContractServiceCache"}, keyGenerator = "keyGenerator")
    @Override
    public ContractVO get(String id) throws ServiceException {
        return contractMapper.get(id);
    }

    @CacheEvict(cacheNames = {"ContractServiceCache"}, allEntries = true, keyGenerator = "keyGenerator")
    @Override
    public void insert(Contract contract) throws ServiceException {
        contractMapper.insert(contract);
    }

    @CacheEvict(cacheNames = {"ContractServiceCache"}, allEntries = true, keyGenerator = "keyGenerator")
    @Override
    public void update(Contract contract) throws ServiceException {
        contractMapper.update(contract);
    }

    @CacheEvict(cacheNames = {"ContractServiceCache"}, allEntries = true, keyGenerator = "keyGenerator")
    @Override
    public void deleteById(String id) throws ServiceException {
        contractMapper.deleteById(id);
        String s = (String) id;
        contractMapper.deleteByExtCproduct(s);
        contractMapper.deleteByContractProduct(s);
    }

    @CacheEvict(cacheNames = {"ContractServiceCache"}, allEntries = true, keyGenerator = "keyGenerator")
    @Override
    public void delete(String[] ids) throws ServiceException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ids", ids);
        contractMapper.delete(map);
        for(String s:ids){
            String id = (String)s;
            contractMapper.deleteByExtCproduct(id);
            contractMapper.deleteByContractProduct(id);
        }
    }

    @CacheEvict(cacheNames = {"ContractServiceCache"}, allEntries = true, keyGenerator = "keyGenerator")
    @Override
    public void submit(String[] ids) throws ServiceException {
        String state = ContractEnum.CONTRACT_ENUM_submit.getVar();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ids", ids);
        map.put("state", state);
        contractMapper.updateState(map);
    }

    @CacheEvict(cacheNames = {"ContractServiceCache"}, allEntries = true, keyGenerator = "keyGenerator")
    @Override
    public void cancel(String[] ids) throws ServiceException {
        String state = ContractEnum.CONTRACT_ENUM_cancel.getVar();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ids", ids);
        map.put("state", state);
        contractMapper.updateState(map);
    }

    @Cacheable(cacheNames = {"ContractServiceCache"}, keyGenerator = "keyGenerator")
    @Override
    public ContractVO view(String id) throws ServiceException {
        return contractMapper.view(id);
    }
}
