package org.seckill;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA.
 * Description:Dao 测试基类
 *
 * 配置Spring和Junit整合,junit启动时加载springIOC容器
 * spring-test,junit
 *
 * User: ray.wang
 * Date: 16/5/21 下午4:34
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public abstract class BaseTest {

}
