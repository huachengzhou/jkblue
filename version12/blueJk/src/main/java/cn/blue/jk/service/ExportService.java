package cn.blue.jk.service;

import cn.blue.jk.domain.Export;
import cn.blue.jk.exception.ServiceException;
import cn.blue.jk.vo.ContractVO;

import java.util.List;
import java.util.Map;

public interface ExportService {
    public List<Export> find(Map<String, Object> map) throws ServiceException;

    public void updateStop(String...ids) throws ServiceException;

    public void updateStart(String...ids) throws ServiceException;

    public Export get(String id) throws ServiceException;

    public void insert(String...contractIds) throws ServiceException;

    public void update(Export export) throws ServiceException;

    public void delete(String... ids) throws ServiceException;

    public List<ContractVO> getContractList() throws ServiceException;

    public String getMrecordData(String id)throws ServiceException;


}
