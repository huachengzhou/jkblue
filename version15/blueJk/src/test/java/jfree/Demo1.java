package jfree;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.general.DefaultKeyedValuesDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.TableOrder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;

public class Demo1 {
    private final String path = "/home/zhou/";
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 多重饼图
     * 要想使用多重饼图，必须先把PieDataset改成CategoryDataset。
     */
    @Test
    public void isMultiplePieChart(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(100,"Spring　Security","Jan");
        dataset.addValue(200,"jBPM　4","Jan");
        dataset.addValue(300,"Ext　JS","Jan");
        dataset.addValue(100,"JFreeChart","Jan");
        dataset.addValue(60,"Spring　Security","Fer");
        dataset.addValue(100,"jBPM　4","Fer");
        dataset.addValue(340,"Ext　JS","Fer");
        dataset.addValue(130,"JFreeChart","Fer");
        JFreeChart chart;
        chart = ChartFactory.createMultiplePieChart(
                "chart",
                dataset,
                TableOrder.BY_COLUMN,//　按列分割饼图，addValue中的第三个参数
                true,
                false,
                false
        );
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(path+"多重饼图.png");
            ChartUtilities.writeChartAsPNG(out,chart,700,400);
            logger.info("success");
        }catch (Exception e){
            logger.error("异常:"+e.getLocalizedMessage());
        }
    }

    /**
     * 三维饼图 有一些问题
     */
    @Test
    public void is3DC(){
        //将createPieChart替换为createPieChart3D就可以实现三维饼图。

        PieDataset dataset =new DefaultKeyedValuesDataset();
        dataset.setGroup(new DatasetGroup("xx"));
        dataset.setGroup(new DatasetGroup("yy"));
        JFreeChart chart = ChartFactory.createPieChart3D(
            "title",
                dataset,
                true,
                false,
                false
        );
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(path+"jfree3DC.png");
            ChartUtilities.writeChartAsPNG(out,chart,700,400);
            logger.info("success");
        }catch (Exception e){
            logger.error("异常:"+e.getLocalizedMessage());
        }
    }

    /**
     * 炸开的饼图
     */
    @Test
    public void isC2(){
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Spring　Security",100);
        dataset.setValue("jBPM　4",200);//这次我们使用setValue向dataset中添加数据，第一个参数是数据的名称，第二个数据是数据的值。
        dataset.setValue("Ext　JS",300);
        dataset.setValue("JFreeChart",100);

        JFreeChart chart = ChartFactory.createPieChart(
                "chart",//　标题
                dataset,//　数据
                true,//　是否使用legend
                false,//　是否使用tooltip
                false//　是否使用url链接
        );
        //处理空值和负值
        //如果设置了值为0或null的值，图表中会显示标签，但是我们看不到数值。
        dataset.setValue("null",null);
        dataset.setValue("zero",0);


        PiePlot piePlot = (PiePlot)chart.getPlot();
        piePlot.setExplodePercent("JFreeChart",0.3);//对 key做处理

        //空值和负值
        //如果不希望在图表中显示为空的数据，需要调用PiePlot的两个方法。(ps不建议设置,设置之后41行处就无效了)
//        piePlot.setIgnoreZeroValues(true);
//        piePlot.setIgnoreNullValues(true);
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(path+"jfreeC2.png");
            ChartUtilities.writeChartAsPNG(out,chart,700,400);
            logger.info("success");
        }catch (Exception e){
            logger.error("异常:"+e.getLocalizedMessage());
        }
    }

    /**
     * 饼图
     */
    @Test
    public void isC(){
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Spring　Security",100);
        dataset.setValue("jBPM　4",200);//这次我们使用setValue向dataset中添加数据，第一个参数是数据的名称，第二个数据是数据的值。
        dataset.setValue("Ext　JS",300);
        dataset.setValue("JFreeChart",100);

        JFreeChart chart = ChartFactory.createPieChart(
                "chart",//　标题
                dataset,//　数据
                true,//　是否使用legend
                false,//　是否使用tooltip
                false//　是否使用url链接
        );

        FileOutputStream out = null;
        try {
            out = new FileOutputStream(path+"jfreeC.png");
            ChartUtilities.writeChartAsPNG(out,chart,700,400);
            logger.info("success");
        }catch (Exception e){
            logger.error("异常:"+e.getLocalizedMessage());
        }
    }

    /**
     * 分组柱状图
     */
    @Test
    public void isB(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(100,"Spring　Security","Jan");
        dataset.addValue(200,"jBPM　4","Jan");
//        dataset.addValue(300,"Ext　JS","Jan");//假如是负向坐标　那么即使不注释掉也可以因为会覆盖
        dataset.addValue(100,"JFreeChart","Jan");
        dataset.addValue(60,"Spring　Security","Fer");
        dataset.addValue(100,"jBPM　4","Fer");
        dataset.addValue(340,"Ext　JS","Fer");
        dataset.addValue(130,"JFreeChart","Fer");
        //负向坐标
        dataset.addValue(-20,"Ext　JS","Jan");
        JFreeChart chart = ChartFactory.createBarChart3D( // createBarChart3D三维,createBarChart普通
                "chart",//　标题
                "num",//　横轴名称
                "type",//　纵轴名称
                dataset,//　数据
                PlotOrientation.VERTICAL,//　使用垂直柱状图VERTICAL ,水平柱状图HORIZONTAL
                true,//　是否使用legend　
                false,//　是否使用tooltip
                false//　是否使用url链接
        );
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(path+"jfreeB.png");
            ChartUtilities.writeChartAsPNG(out,chart,700,400);
            logger.info("success");
        }catch (Exception e){
            logger.error("异常:"+e.getLocalizedMessage());
        }
    }
    /**
     * 简单柱状图
     */
    @Test
    public void isA() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(100, "Spring　Security", "Jan1");
        dataset.addValue(200, "jBPM　4", "Jan2");
        dataset.addValue(300, "Ext　JS", "Jan3");
        dataset.addValue(400, "JFreeChart", "Jan4");

        JFreeChart chart = ChartFactory.createBarChart3D( // createBarChart3D三维,createBarChart普通
                "chart",//　标题
                "num",//　横轴名称
                "type",//　纵轴名称
                dataset,//　数据
                PlotOrientation.VERTICAL,//　使用垂直柱状图VERTICAL ,水平柱状图HORIZONTAL
                true,//　是否使用legend　
                false,//　是否使用tooltip
                false//　是否使用url链接
        );
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(path+"jfree.png");
            ChartUtilities.writeChartAsPNG(out,chart,700,400);
            logger.info("success");
        }catch (Exception e){
            logger.error("异常:"+e.getLocalizedMessage());
        }
    }


}
