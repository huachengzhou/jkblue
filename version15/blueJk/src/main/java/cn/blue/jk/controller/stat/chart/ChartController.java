package cn.blue.jk.controller.stat.chart;

import cn.blue.common.view.VIEW;
import cn.blue.jk.domain.other.*;
import cn.blue.jk.service.ContractService;
import cn.blue.jk.util.SqlDao;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

@Controller
public class ChartController {

    /**
     * 产品图
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/stat/chart/productSale.action", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    public String productSale(HttpServletRequest request,HttpServletResponse response){
        String servletPath = VIEW.Pages.getVar()+"/stat/chart/";
        servletPath +="jFreeChart.jsp";
        String sql = "select sum(cnumber) as sumnum ,contractId\n" +
                "from contract_product_c cpc GROUP BY cpc.contractId\n";
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/png");
            pieChart(sql,"productsale",response.getOutputStream());//不能传入中文
        }catch (Exception e){
            logger.error("异常:"+e.getLocalizedMessage());
            e.printStackTrace();
        }
        return servletPath;
    }

    /**
     * 工厂图
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/stat/chart/factorySale.action", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    public String factorySale(HttpServletRequest request,HttpServletResponse response){
        String path = request.getSession().getServletContext().getRealPath("/");	//真实路径
        
        String sql = "select f.FACTORY_NAME as fName,cpc.countnum as fNumber,cpc.factoryId as fId from factory_c f RIGHT JOIN\n" +
                "  (select factoryId,count(*) AS countnum from contract_product_c GROUP BY factoryId)\n" +
                "  cpc ON cpc.factoryId=f.FACTORY_PRODUCT_ID";
        String servletPath = VIEW.Pages.getVar()+"/stat/chart/";
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/png");
            getBarGraph(sql,response.getOutputStream(),"Factory","JFreeChart");//不能传入中文
        }catch (Exception e){
            logger.error("异常:"+e.getLocalizedMessage());
            e.printStackTrace();
        }
        servletPath +="jFreeChart.jsp";
        return servletPath;
    }

    /**
     * 系统压力测试图
     * @return
     */
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/stat/chart/onlineInfo.action",method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    public String onlineInfo(HttpServletRequest request,HttpServletResponse response){
        String servletPath = VIEW.Pages.getVar()+"/stat/chart/";
        servletPath +="jFreeChart.jsp";
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
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/png");
            xy(sql,"login test",response.getOutputStream());//不能传入中文
        }catch (Exception e){
            logger.error("异常:"+e.getLocalizedMessage());
            e.printStackTrace();
        }
        return servletPath;
    }

    /**
     * 饼图
     * @param sql
     * @param title
     * @param out
     */
    public void pieChart(String sql,String title,OutputStream out){
        DefaultPieDataset dataset = new DefaultPieDataset();
        List<ContractB> contractBS = jdbcTemplate.query(sql,new ContractBMapper(contractService));
        contractBS.forEach((contractB -> {
            dataset.setValue(contractB.getName(),contractB.getSumnum());
        }));
        JFreeChart chart = ChartFactory.createPieChart(
                ""+title,//　标题
                dataset,//　数据
                true,//　是否使用legend
                false,//　是否使用tooltip
                false//　是否使用url链接
        );
        try {
            ChartUtilities.writeChartAsPNG(out,chart,750,400);
        }catch (IOException e){
            logger.error("异常信息!"+e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    /**
     * 柱状图
     * @param sql
     * @return
     */
    public void getBarGraph(String sql,OutputStream out,String titleX,String title){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        List<BarGraphFactory> factories = jdbcTemplate.query(sql,new BarGraphFactoryRowMapper());
        factories.forEach(barGraphFactory -> {
            dataset.setValue(barGraphFactory.getfNumber(),barGraphFactory.getfName(),"");
        });
        JFreeChart chart = ChartFactory.createBarChart3D( // createBarChart3D三维,createBarChart普通
                ""+title,//　标题
                titleX,//　横轴名称
                "data type",//　纵轴名称
                dataset,//　数据
                PlotOrientation.VERTICAL,//　使用垂直柱状图VERTICAL ,水平柱状图HORIZONTAL
                true,//　是否使用legend　
                false,//　是否使用tooltip
                false//　是否使用url链接
        );
        //乱码解决
        Font font=new Font("微软雅黑", Font.BOLD,18);
        chart.getTitle().setFont(font);
        CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象
        CategoryAxis domainAxis=plot.getDomainAxis();
        //水平底部列表
        domainAxis.setLabelFont(new Font("微软雅黑",Font.BOLD,14));
        //水平底部标题
        domainAxis.setTickLabelFont(new Font("微软雅黑",Font.BOLD,12));
        //垂直标题
        ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状
        rangeAxis.setLabelFont(new Font("微软雅黑",Font.BOLD,15));
        chart.getLegend().setItemFont(new Font("微软雅黑", Font.BOLD, 15));

        try {
            ChartUtilities.writeChartAsPNG(out,chart,750,400);
        }catch (IOException e){
            logger.error("异常信息!"+e.getLocalizedMessage());
            e.printStackTrace();
        }

    }

    /**
     * 折线图
     * @param sql
     * @param title
     */
    public void xy(String sql,String title,OutputStream out){
        XYSeries xyseries1 = new XYSeries("One");
        jdbcTemplate.queryForList(sql).forEach((map -> {
            Set<Map.Entry<String,Object>> set = map.entrySet();
            Iterator<Map.Entry<String,Object>> it = set.iterator();
            Map<String,Integer> m = new HashMap<>();
            while (it.hasNext()){
                Map.Entry<String,Object> entry = it.next();
                String key = entry.getKey();
                Object value = entry.getValue();
                m.put(key,Integer.parseInt(value.toString()));
            }
            Set<Map.Entry<String,Integer>> entrySet = m.entrySet();
            Iterator<Map.Entry<String,Integer>> iterator = entrySet.iterator();
            while (iterator.hasNext()){
                Map.Entry<String,Integer> entry = iterator.next();
                String key = entry.getKey();
                Integer value = entry.getValue();
                xyseries1.add(Integer.parseInt(key),value);
            }
        }));
        XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
        xySeriesCollection.addSeries(xyseries1);
        JFreeChart jfreechart = ChartFactory.createXYLineChart(""+title, // 标题
                "Hour", // categoryAxisLabel （category轴，横轴，X轴标签）
                "login people number", // valueAxisLabel（value轴，纵轴，Y轴的标签）
                xySeriesCollection, // dataset
                PlotOrientation.VERTICAL,
                true, // legend
                false, // tooltips
                false); // URLs
        // 使用CategoryPlot设置各种参数。以下设置可以省略。
        XYPlot plot = (XYPlot) jfreechart.getPlot();
        // 背景色 透明度
        plot.setBackgroundAlpha(0.5f);
        // 前景色 透明度
        plot.setForegroundAlpha(0.5f);
        // 其它设置可以参考XYPlot类
        try {
            ChartUtilities.writeChartAsPNG(out,jfreechart,750,400);
        }catch (IOException e){
            logger.error("异常信息!"+e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private SqlDao sqlDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ContractService contractService;

    //获取数据
    public List<String> getData(String sql){
        return sqlDao.executeSQL(sql);			//List<String>
    }

}
