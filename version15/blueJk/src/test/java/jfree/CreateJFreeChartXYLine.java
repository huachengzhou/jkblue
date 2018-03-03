package jfree;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;

public class CreateJFreeChartXYLine {
    private final String path = "/home/zhou/";
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 创建JFreeChart LineXY Chart（折线图）
     */
    @Test
    public void init(){
        //步骤1：创建XYDataset对象（准备数据）
        XYDataset dataset = createXYDataset();
        //步骤2：根据Dataset 生成JFreeChart对象，以及做相应的设置
        JFreeChart freeChart = createChart(dataset);
        //步骤3：将JFreeChart对象输出到文件，Servlet输出流等
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(path+"折线图.png");
            ChartUtilities.writeChartAsPNG(out,freeChart,700,400);
            logger.info("success");
        }catch (Exception e){
            logger.error("异常:"+e.getLocalizedMessage());
        }
    }

    /**
     * 根据XYDataset创建JFreeChart对象
     * @param dataset
     * @return
     */
    public static JFreeChart createChart(XYDataset dataset) {
        // 创建JFreeChart对象：ChartFactory.createXYLineChart
        JFreeChart jfreechart = ChartFactory.createXYLineChart("XYLine Chart Demo", // 标题
                "年分", // categoryAxisLabel （category轴，横轴，X轴标签）
                "数量", // valueAxisLabel（value轴，纵轴，Y轴的标签）
                dataset, // dataset
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
        return jfreechart;
    }

    /**
     * 创建XYDataset对象
     * @return
     */
    private static XYDataset createXYDataset() {
        XYSeries xyseries1 = new XYSeries("One");

        xyseries1.add(1987, 50);

        xyseries1.add(1997, 20);

        xyseries1.add(2007, 30);

        XYSeries xyseries2 = new XYSeries("Two");

        xyseries2.add(1987, 20);

        xyseries2.add(1997, 10D);

        xyseries2.add(2007, 40D);

        XYSeries xyseries3 = new XYSeries("Three");

        xyseries3.add(1987, 40);

        xyseries3.add(1997, 30.0008);

        xyseries3.add(2007, 38.24);

        XYSeriesCollection xySeriesCollection = new XYSeriesCollection();

        xySeriesCollection.addSeries(xyseries1);

        xySeriesCollection.addSeries(xyseries2);

        xySeriesCollection.addSeries(xyseries3);
        return xySeriesCollection;

    }

}
