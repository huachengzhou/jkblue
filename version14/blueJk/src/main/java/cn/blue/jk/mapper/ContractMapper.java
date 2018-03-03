package cn.blue.jk.mapper;

import cn.blue.jk.domain.Contract;
import cn.blue.jk.exception.MapperException;
import cn.blue.jk.pagination.Page;
import cn.blue.jk.vo.ContractVO;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface ContractMapper {
    public List<Contract> findPage(Page page) throws MapperException;                //分页查询

    public List<ContractVO> find(Map paraMap) throws MapperException;                //带条件查询，条件可以为null，既没有条件；返回list对象集合

    public ContractVO get(String id) throws MapperException;                    //只查询一个，常用于修改

    public ContractVO view(String id)throws MapperException;

    public void insert(Contract entity) throws MapperException;                    //插入，用实体作为参数

    public void update(Contract entity) throws MapperException;                    //修改，用实体作为参数

    public void deleteById(Serializable id) throws MapperException;        //按id删除，删除一条；支持整数型和字符串类型ID

    /**
     * param ids
     *
     * @throws MapperException
     */
    public void delete(Map<String, Object> map) throws MapperException;

    /**
     * param ids and state
     *
     * @param map
     * @throws MapperException
     */
    public void updateState(Map<String, Object> map) throws MapperException;

    public void deleteByContractProduct(String id) throws MapperException;

    public void deleteByExtCproduct(String id) throws MapperException;
}
