import dao.IUserDao;
import domain.user;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * User: Russell
 * Date: 2019-05-02
 * Time: 14:25
 */
public class test {

    @Test
   public void findAll() throws Exception{

        //读取配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建sqlsession工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //创建sqlsession对象
        SqlSession sqlSession = factory.openSession();
        //创建dao接口的代理对象
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        //执行方法
        List<user> users = mapper.findAll();
        users.forEach(System.out::println);
        //释放资源
        sqlSession.close();
        in.close();
    }
}
