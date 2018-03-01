package cn.blue.jk.service;

import cn.blue.jk.exception.ServiceException;
import cn.blue.jk.vo.OutProductVO;

import java.util.List;

public interface OutProductService {

    public List<OutProductVO> outProducts(String var)throws ServiceException;

}
