package test;

import com.design.demo.DemoSpringBootApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description: java类作用描述
 * @Author: wxzhangyd
 * @Date: 2018/8/20 10:44
 * @Modified by:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoSpringBootApplication.class)// 指定spring-boot的启动类

public class SpringBootCommonTest {
}
