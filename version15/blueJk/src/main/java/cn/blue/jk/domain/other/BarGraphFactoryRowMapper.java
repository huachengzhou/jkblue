package cn.blue.jk.domain.other;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BarGraphFactoryRowMapper implements RowMapper<BarGraphFactory> {
    @Override
    public BarGraphFactory mapRow(ResultSet rs, int rowNum) throws SQLException {
        BarGraphFactory bar = new BarGraphFactory();
        bar.setfId(rs.getString("fId"));
        bar.setfNumber(rs.getInt("fNumber"));
        bar.setfName(rs.getString("fName"));
        return bar;
    }
}
