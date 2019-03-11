import com.springbach.demo.domain.Book;
import com.springbach.demo.mapper.BookMapper;
import com.springbach.demo.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.util.List;

/**
 * Title:PACKAGE_NAME
 * Description:
 * Copyright: Copyright (c) 2018
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/09/13  18:10
 */
public class JunitTest {

    private ApplicationContext applicationContext;

    @Before
    public void initq(){
        applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
    }


    @Test
    public void test1(){
        DataSource ds = applicationContext.getBean("ds", DataSource.class);
        System.out.println(ds);
    }

    @Test
    public void test2(){
        SqlSession session = MyBatisUtil.getSession();
        BookMapper mapper = session.getMapper(BookMapper.class);
        List<Book> books = mapper.selectBook();
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
