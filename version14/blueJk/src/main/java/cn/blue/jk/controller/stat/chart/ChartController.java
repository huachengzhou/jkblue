package cn.blue.jk.controller.stat.chart;

import cn.blue.common.view.VIEW;
import cn.blue.jk.util.SqlDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Controller
public class ChartController {

    @RequestMapping(value = "/stat/chart/factorySale.action")
    public String factorySale(HttpServletRequest request){
        String path = request.getSession().getServletContext().getRealPath("/");	//真实路径
        
        String sql ="select f.FACTORY_NAME,cpc.countnum,cpc.factoryId from factory_c f RIGHT JOIN\n" +
                "  (select factoryId,count(*) AS countnum from contract_product_c GROUP BY factoryId)\n" +
                "  cpc ON cpc.factoryId=f.FACTORY_PRODUCT_ID";
        String dir = "factorysale";
        writeXMLN(path,getPieXml(getData(sql)),"factorysale");
        return VIEW.Pages.getVar()+"/stat/chart/jStat.jsp?forward="+dir;
    }

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private SqlDao sqlDao;

    //获取数据
    public List<String> getData(String sql){
        return sqlDao.executeSQL(sql);			//List<String>
    }

    //拼接饼形图xml
    public String getPieXml(List<String> dataList){
        //拼接数据位一个xml字符串
        StringBuffer sBuf = new StringBuffer();
        sBuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        sBuf.append("<pie>");
        for(int i=0;i<dataList.size();){
            //在for循环内部控制当前记录标识
            sBuf.append("  <slice title=\"").append(dataList.get(i++)).append("\">").append(dataList.get(i++)).append("</slice>");
        }
        sBuf.append("</pie>");

        return sBuf.toString();
    }

    //获得柱状图xml
    public String getColumnAndLineXml(List<String> dataList){
        StringBuffer sBuf = new StringBuffer();
        sBuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        sBuf.append("<chart>");
        sBuf.append("<series>");

        int xid = 0;			//对应标识
        for(int i=0;i<dataList.size();){
            sBuf.append("<value xid=\"").append(xid++).append("\">").append(dataList.get(i++)).append("</value>");
            i++;		//skip
        }
        sBuf.append("</series>");
        sBuf.append("<graphs>");
        sBuf.append("<graph gid=\"30\" color=\"#FFCC00\" gradient_fill_colors=\"#111111, #1A897C\">");

        xid = 0;
        for(int i=0;i<dataList.size();){
            i++;		//skip
            sBuf.append("<value xid=\"").append(xid++).append("\">").append(dataList.get(i++)).append("</value>");
        }

        sBuf.append("</graph>");
        sBuf.append("</graphs>");
        sBuf.append("</chart>");

        return sBuf.toString();
    }


    private void writeXMLN(String path,String context,String dir){
        try {
            String filePath = path+"stat/chart"+"/"+dir+"/data.xml";
            File file = new File(filePath+"");
            if (file.isFile()){
                file.delete();
                logger.info("yes");
            }
            BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream(filePath,false));
            buffer.write(context.getBytes("UTF-8"));
            buffer.flush();
            buffer.close();
            logger.info(filePath);
            logger.info(context);
        }catch (Exception e){
            logger.error("异常:"+e.getLocalizedMessage());
        }
    }
}
