package cn.blue.jk.domain.other;

import cn.blue.jk.domain.Contract;
import cn.blue.jk.service.ContractService;
import cn.blue.jk.vo.ContractVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContractBMapper implements RowMapper<ContractB> {
    private ContractService contractService;

    public ContractBMapper(ContractService contractService) {
        this.contractService = contractService;
    }

    @Override
    public ContractB mapRow(ResultSet rs, int rowNum) throws SQLException {
        ContractB contractB = new ContractB();
        ContractVO contract = contractService.view(rs.getString("contractId"));
        contractB.setName(contract.getCustomName());
        contractB.setSumnum(rs.getInt("sumnum"));
        return contractB;
    }
}
