package cn.blue.jk.service.impl;

import cn.blue.common.other.ExportEnum;
import cn.blue.jk.domain.Export;
import cn.blue.jk.domain.ExportProduct;
import cn.blue.jk.domain.ExtEproduct;
import cn.blue.jk.domain.Factory;
import cn.blue.jk.exception.MapperException;
import cn.blue.jk.exception.ServiceException;
import cn.blue.jk.mapper.ContractMapper;
import cn.blue.jk.mapper.ExportMapper;
import cn.blue.jk.mapper.ExportProductMapper;
import cn.blue.jk.mapper.ExtEproductMapper;
import cn.blue.jk.service.ExportService;
import cn.blue.jk.util.UtilFuns;
import cn.blue.jk.vo.ContractVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service(value = "exportService")
public class ExportServiceImpl implements ExportService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Lazy
    @Autowired
    private ExportMapper exportMapper;

    @Lazy
    @Autowired
    private ContractMapper contractMapper;

    @Lazy
    @Autowired
    private ExportProductMapper exportProductMapper;

    @Lazy
    @Autowired
    private ExtEproductMapper extEproductMapper;

    @Override
    public List<Export> find(Map<String, Object> map) throws ServiceException {
        return exportMapper.find(map);
    }

    @Override
    public List<ContractVO> getContractList() throws ServiceException {
        String state = ExportEnum.EXPORT_ENUM_END.getVar();
        Map<String, Object> map = new HashMap<>();
        map.put("state", Integer.parseInt(state));
        return contractMapper.find(map);
    }

    @Override
    public String getMrecordData(String id) throws ServiceException {
        Map paraMap = new HashMap();
        paraMap.put("exportId", id);
        List<ExportProduct> oList = exportProductMapper.find(paraMap);
        StringBuilder sBuf = new StringBuilder(1024);
        for (ExportProduct ep : oList) {
            sBuf.append("addTRRecord(\"mRecordTable\", \"").append(ep.getId()).append("\", \"").append(ep.getProductNo()).append("\", \"").append(ep.getCnumber()).append("\", \"").append(UtilFuns.convertNull(ep.getGrossWeight())).append("\", \"").append(UtilFuns.convertNull(ep.getNetWeight())).append("\", \"").append(UtilFuns.convertNull(ep.getSizeLength())).append("\", \"").append(UtilFuns.convertNull(ep.getSizeWidth())).append("\", \"").append(UtilFuns.convertNull(ep.getSizeHeight())).append("\", \"").append(UtilFuns.convertNull(ep.getExPrice())).append("\", \"").append(UtilFuns.convertNull(ep.getTax())).append("\");");
        }
        return sBuf.toString();
    }

    @Override
    public void updateStop(String... ids) throws ServiceException {
        String state = ExportEnum.EXPORT_ENUM_END.getVar();
        if (ids != null) {
            for (String id : ids) {
                Map<String, Object> map = new HashMap<>();
                map.put("state", state);
                map.put("id", id);
                exportMapper.updateState(map);
            }
        }
    }

    @Override
    public void updateStart(String... ids) throws ServiceException {
        String state = ExportEnum.EXPORT_ENUM_Start.getVar();
        if (ids != null) {
            for (String id : ids) {
                Map<String, Object> map = new HashMap<>();
                map.put("state", state);
                map.put("id", id);
                exportMapper.updateState(map);
            }
        }
    }

    @Override
    public Export get(String id) throws ServiceException {
        return exportMapper.get(id);
    }

    @Override
    public void insert(String... contractIds) throws ServiceException {
        String state = ExportEnum.EXPORT_ENUM_END.getVar();
        /*
         * 步骤：
         * 1、根据合同id获得合同对象，获取合同号
         * 2、将合同下的货物信息搬家到报运下的货物表中
         * 3、将合同下的附件信息搬家到报运下的附件表中
         */

        //拼接合同号，报运号
        Export export = new Export();
        export.setId(UUID.randomUUID().toString());
        export.setInputDate(new Date(System.currentTimeMillis()));
        //拼接合同号，报运号
        String contractNos = "";
        String contractIds_ = "";
        for (int i = 0; i < contractIds.length; i++) {
            ContractVO contractVO = contractMapper.view(contractIds[i]); //以空格作为分隔符
            if (i != (contractIds.length - 1)) {//非最后一个
                contractNos += contractVO.getContractNo() + " ";
                contractIds_ += contractIds[i] + ",";
            } else {//最后一个不加空格符号,以及不加,
                contractNos += contractVO.getContractNo();
                contractIds_ += contractIds[i];
            }
        }
        export.setContractIds(contractIds_);//合同id
        export.setCustomerContract(contractNos);//合同号
        export.setState(Integer.parseInt(state));
        exportMapper.insert(export);

        //处理货物信息
        for (int i = 0; i < contractIds.length; i++) {
            ContractVO contract = contractMapper.view(contractIds[i]);
            contract.getContractProducts().stream().parallel().forEach((cp -> {
                ExportProduct ep = new ExportProduct();
                ep.setId(UUID.randomUUID().toString());
                ep.setExportId(export.getId()); //绑定外键
                //数据搬家，将合同下的对应的货物信息写入到报运下的货物信息中
                if (cp != null) {
                    Factory factory = cp.getFactory();
                    if (factory != null) {
                        ep.setFactoryId(factory.getId());
                        ep.setFactoryName(factory.getFactoryName());
                    }
                    ep.setProductNo(cp.getProductNo());
                    ep.setPackingUnit(cp.getPackingUnit());
                    ep.setCnumber(cp.getCnumber());
                    ep.setBoxNum(cp.getBoxNum());
                    ep.setPrice(cp.getPrice());
                    try {
                        exportProductMapper.insert(ep);
                    } catch (MapperException e) {
                        logger.error("异常! " + e.getLocalizedMessage());
                        e.printStackTrace();
                    }
                }
                //处理附件信息
                cp.getExtCproducts().stream().parallel().forEach(extcp -> {
                    ExtEproduct extep = new ExtEproduct();
                    if (extcp != null) {
                        extep.setAmount(extcp.getAmount());
                        extep.setProductImage(extcp.getProductImage());
                        extep.setProductDesc(extcp.getProductDesc());
                        extep.setProductNo(extcp.getProductNo());
                        extep.setPrice(extcp.getPrice());
                        extep.setPackingUnit(extcp.getPackingUnit());
                        Factory factory = extcp.getFactory();
                        if (factory != null) {
                            extep.setFactoryId(factory.getId());
                            extep.setFactoryName(factory.getFactoryName());
                        }
                        extep.setCtype(extcp.getCtype());
                        extep.setOrderNo(extcp.getOrderNo());
                        extep.setProductRequest(extcp.getProductRequest());
                    }


                    extep.setExportProductId(ep.getId());
                    extep.setId(UUID.randomUUID().toString());
                    extep.setExportProductId(ep.getId());        //绑定外键
                    try {
                        extEproductMapper.insert(extep);
                    } catch (MapperException e) {
                        logger.error("异常:" + e.getLocalizedMessage());
                        e.printStackTrace();
                    }
                });
            }));
        }

    }

    @Override
    public void update(Export export) throws ServiceException {
        exportMapper.update(export);
    }

    @Override
    public void delete(String... ids) throws ServiceException {
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        if (ids.length == 1 && ids != null) {
            String id = ids[0];
            exportMapper.deleteBy(id);
        } else if (ids.length > 1 && ids != null) {
            exportMapper.delete(map);
        } else {
            throw new MapperException();
        }
    }

}
