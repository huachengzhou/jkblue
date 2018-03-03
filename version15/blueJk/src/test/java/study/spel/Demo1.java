package study.spel;

import cn.blue.jk.domain.User;
import cn.blue.jk.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class Demo1 {
    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private UserService userService = null;
    ExpressionParser parse = null;

    @Test
    public void isA() throws Exception {
        Expression exp = parse.parseExpression("'hello'+'world'");
        String message = (String) exp.getValue();
        System.out.println(message);
        message = exp.getValue(String.class);//这样就不用转换了
        System.out.println(message);
    }

    @Test
    public void isB() throws Exception {
        String id = "d7314519-cbc2-4ae2-84ca-6df5adf984d0";
        User user = userService.get(id);
        EvaluationContext context = new StandardEvaluationContext(user);
        String username = (String) parse.parseExpression("username").getValue(context);
        logger.info(username);
    }

    @Before
    public void init() {
        userService = (UserService) context.getBean("userService");
        parse = new SpelExpressionParser();
    }
}
