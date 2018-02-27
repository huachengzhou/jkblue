package cn.blue.jk.service.impl;

import cn.blue.jk.domain.Contract;
import cn.blue.jk.mapper.ContractMapper;
import cn.blue.jk.pagination.Page;
import cn.blue.jk.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Service(value = "contractService")
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractMapper contractMapper;

    @Override
    public List<Contract> findPage(Page page) throws Exception {
        return null;
    }

    @Override
    public List<Contract> find(Map paraMap) throws Exception {
        return null;
    }

    @Override
    public Contract get(Serializable id) throws Exception {
        return contractMapper.get(id);
    }

    @Override
    public void insert(Contract contract) throws Exception {

    }

    @Override
    public void update(Contract contract) throws Exception {

    }

    @Override
    public void deleteById(Serializable id) throws Exception {

    }

    @Override
    public void delete(Serializable[] ids) throws Exception {

    }

    @Override
    public void submit(Serializable[] ids) throws Exception {

    }

    @Override
    public void cancel(Serializable[] ids) throws Exception {

    }
}
