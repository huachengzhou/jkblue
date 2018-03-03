package me.spring;

import cn.blue.jk.domain.other.BarGraphFactory;
import cn.blue.jk.domain.other.BarGraphFactoryRowMapper;
import cn.blue.jk.util.SqlDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;
import java.util.logging.Logger;

public class Demo1 {
    private Logger logger = Logger.getLogger("" + this);
    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    private SqlDao sqlDao;
    private JdbcTemplate jdbcTemplate;


    @Test
    public void isA(){
        String sql = "select f.FACTORY_NAME as fName,cpc.countnum as fNumber,cpc.factoryId as fId from factory_c f RIGHT JOIN\n" +
                "  (select factoryId,count(*) AS countnum from contract_product_c GROUP BY factoryId)\n" +
                "  cpc ON cpc.factoryId=f.FACTORY_PRODUCT_ID";
        List<BarGraphFactory> factories = jdbcTemplate.query(sql,new BarGraphFactoryRowMapper());
        factories.forEach((barGraphFactory -> logger.info(barGraphFactory+"")));
    }

    @Test
    public void isB(){
        String sql = "SELECT\n" +
                "  (\n" +
                "    select count(*) from login_log_p\n" +
                "    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 00:00:00')) AND\n" +
                "          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 01:00:00'))\n" +
                "  ) as '1', #00:00-01:00\n" +
                "  (\n" +
                "    select count(*) from login_log_p\n" +
                "    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 01:00:00')) AND\n" +
                "          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 02:00:00'))\n" +
                "  ) as '2', #01:00-02:00\n" +
                "  (\n" +
                "    select count(*) from login_log_p\n" +
                "    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 02:00:00')) AND\n" +
                "          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 03:00:00'))\n" +
                "  ) as '3', #02:00-03:00\n" +
                "  (\n" +
                "    select count(*) from login_log_p\n" +
                "    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 03:00:00')) AND\n" +
                "          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 04:00:00'))\n" +
                "  ) as '4', #03:00-04:00\n" +
                "  (\n" +
                "    select count(*) from login_log_p\n" +
                "    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 04:00:00')) AND\n" +
                "          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 05:00:00'))\n" +
                "  ) as '5', #04:00-05:00\n" +
                "  (\n" +
                "    select count(*) from login_log_p\n" +
                "    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 05:00:00')) AND\n" +
                "          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 06:00:00'))\n" +
                "  ) as '6', #05:00-06:00\n" +
                "  (\n" +
                "    select count(*) from login_log_p\n" +
                "    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 06:00:00')) AND\n" +
                "          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 07:00:00'))\n" +
                "  ) as '7', #06:00-07:00\n" +
                "  (\n" +
                "    select count(*) from login_log_p\n" +
                "    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 07:00:00')) AND\n" +
                "          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 08:00:00'))\n" +
                "  ) as '8', #07:00-08:00\n" +
                "  (\n" +
                "    select count(*) from login_log_p\n" +
                "    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 08:00:00')) AND\n" +
                "          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 09:00:00'))\n" +
                "  ) as '9', #08:00-09:00\n" +
                "  (\n" +
                "    select count(*) from login_log_p\n" +
                "    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 09:00:00')) AND\n" +
                "          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 10:00:00'))\n" +
                "  ) as '10', #09:00-10:00\n" +
                "  (\n" +
                "    select count(*) from login_log_p\n" +
                "    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 10:00:00')) AND\n" +
                "          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 11:00:00'))\n" +
                "  ) as '11', #10:00-11:00\n" +
                "  (\n" +
                "    select count(*) from login_log_p\n" +
                "    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 11:00:00')) AND\n" +
                "          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 12:00:00'))\n" +
                "  ) as '12', #11:00-12:00\n" +
                "  (\n" +
                "    select count(*) from login_log_p\n" +
                "    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 12:00:00')) AND\n" +
                "          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 13:00:00'))\n" +
                "  ) as '13', #12:00-13:00\n" +
                "  (\n" +
                "    select count(*) from login_log_p\n" +
                "    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 13:00:00')) AND\n" +
                "          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 14:00:00'))\n" +
                "  ) as '14', #13:00-14:00\n" +
                "  (\n" +
                "    select count(*) from login_log_p\n" +
                "    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 14:00:00')) AND\n" +
                "          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 15:00:00'))\n" +
                "  ) as '15', #14:00-15:00\n" +
                "  (\n" +
                "    select count(*) from login_log_p\n" +
                "    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 15:00:00')) AND\n" +
                "          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 16:00:00'))\n" +
                "  ) as '16', #15:00-16:00\n" +
                "  (\n" +
                "    select count(*) from login_log_p\n" +
                "    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 16:00:00')) AND\n" +
                "          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 17:00:00'))\n" +
                "  ) as '17', #16:00-17:00\n" +
                "  (\n" +
                "    select count(*) from login_log_p\n" +
                "    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 17:00:00')) AND\n" +
                "          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 18:00:00'))\n" +
                "  ) as '18', #17:00-18:00\n" +
                "  (\n" +
                "    select count(*) from login_log_p\n" +
                "    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 18:00:00')) AND\n" +
                "          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 19:00:00'))\n" +
                "  ) as '19', #18:00-19:00\n" +
                "  (\n" +
                "    select count(*) from login_log_p\n" +
                "    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 19:00:00')) AND\n" +
                "          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 20:00:00'))\n" +
                "  ) as '20', #19:00-20:00\n" +
                "  (\n" +
                "    select count(*) from login_log_p\n" +
                "    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 20:00:00')) AND\n" +
                "          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 21:00:00'))\n" +
                "  ) as '21', #20:00-21:00\n" +
                "  (\n" +
                "    select count(*) from login_log_p\n" +
                "    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 21:00:00')) AND\n" +
                "          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 22:00:00'))\n" +
                "  ) as '22', #21:00-22:00\n" +
                "  (\n" +
                "    select count(*) from login_log_p\n" +
                "    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 22:00:00')) AND\n" +
                "          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 23:00:00'))\n" +
                "  ) as '23', #22:00-23:00\n" +
                "  (\n" +
                "    select count(*) from login_log_p\n" +
                "    where login_log_p.LOGIN_TIME>=(select concat((select CURDATE()),' 23:00:00')) AND\n" +
                "          login_log_p.LOGIN_TIME<(select concat((select CURDATE()),' 24:00:00'))\n" +
                "  ) as '24' #23:00-24:00";
        jdbcTemplate.queryForList(sql).forEach((map -> {
            Set<Map.Entry<String,Object>> set = map.entrySet();
            Iterator<Map.Entry<String,Object>> it = set.iterator();
            int i = 0;
            Map<String,Integer> m = new HashMap<>();
            while (it.hasNext()){
                Map.Entry<String,Object> entry = it.next();
                String key = entry.getKey();
                Object value = entry.getValue();
                m.put(key,Integer.parseInt(value.toString()));
//              logger.info("index:"+(i++) + "key:" + key + "; value:"+value);
            }
            Set<Map.Entry<String,Integer>> entrySet = m.entrySet();
            Iterator<Map.Entry<String,Integer>> iterator = entrySet.iterator();
            i = 0;
            while (iterator.hasNext()){
                Map.Entry<String,Integer> entry = iterator.next();
                String key = entry.getKey();
                Integer value = entry.getValue();
                System.out.println("index:"+(i++) + "key:" + key + "; value:"+value);
            }
        }));
    }

    @Before
    public void init(){
        sqlDao = context.getBean(SqlDao.class);
        jdbcTemplate = context.getBean(JdbcTemplate.class);
    }
}
