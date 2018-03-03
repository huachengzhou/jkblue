package cn.blue.jk.service.impl;

import cn.blue.jk.exception.ServiceException;
import cn.blue.jk.mapper.OutProductMapper;
import cn.blue.jk.service.OutProductService;
import cn.blue.jk.vo.OutProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "outProductService")
public class OutProductServiceImpl implements OutProductService {
    @Autowired
    private OutProductMapper productMapper;

    @Cacheable(cacheNames = {"outProductServiceCache"}, keyGenerator = "keyGenerator")
    @Override
    public List<OutProductVO> outProducts(String var) throws ServiceException {
        var = "%"+var+"%";
        Map<String,Object> map = new HashMap<>();
        map.put("id",var);
        return productMapper.find(map);
    }
}
