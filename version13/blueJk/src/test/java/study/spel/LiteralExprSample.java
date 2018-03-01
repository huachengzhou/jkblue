package study.spel;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class LiteralExprSample {
    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    ExpressionParser parse = null;

    /**
     * 解析字符串
     *
     * @throws Exception
     */
    @Test
    public void isA() throws Exception {
        String hello_world = parse.parseExpression("'helloworld'").getValue(String.class);
        logger.info(hello_world);
    }

    /**
     * 解析双精度
     * @throws Exception
     */
    @Test
    public void isB() throws Exception {
        double num = parse.parseExpression("6.022E+23").getValue(Double.class);
        logger.info(num + "");
    }


    @Before
    public void init() {
        parse = new SpelExpressionParser();
    }
}
