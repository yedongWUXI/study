package core.jdbc;

import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.sql.*;
import java.util.List;
import java.util.Map;

/**
 * @Description: java类作用描述
 * @Author: yedong
 * @Date: 2019/7/8 9:32
 * @Modified by:
 */

public class InsertTest {

    /**
     * 连接信息
     */
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";
    private final static String URL = "jdbc:mysql://139.224.14.200:3306/soul";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获得连接
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "INSERT INTO monitor (id,ip) VALUES (?,?)";

            //加载sql
            statement = connection.prepareStatement(sql);
            statement.setString(1, "2");
            statement.setString(2, "ip");
            //执行sql语句
            statement.executeUpdate();
            ResultSet resultSet = statement.executeQuery();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭连接
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testInsert() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://148.70.213.66:3306/soul");
        config.setUsername("root");
        config.setPassword("Root1234!");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource ds = new HikariDataSource(config);


        Connection conn = null;
        Statement statement;
        try {
            conn = ds.getConnection();
            statement = conn.createStatement();
            statement.execute("INSERT INTO monitor (id,ip) VALUES ('1','2')");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void testSelect() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://148.70.213.66:3306/soul");
        config.setUsername("root");
        config.setPassword("Root1234!");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource ds = new HikariDataSource(config);


        Connection conn = null;
        try {
            conn = ds.getConnection();
            String sql = "SELECT * FROM selector WHERE name = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, "test");
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                System.out.println(name);
            }

            System.out.println(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    /**
     * jdbc使用 mybatis 和xml
     *
     * @throws Exception
     */
    @Test
    public void jdbc() throws Exception {
        System.out.println(111111);
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://148.70.213.66:3306/soul");
        dataSource.setUsername("root");
        dataSource.setPassword("Root1234!");

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath:/mapper/MySQLGeneratorDao.xml");

        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setMapperLocations(resources);
        sqlSessionFactoryBean.setDataSource(dataSource);

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();

        SqlSession sqlsession = sqlSessionFactory.openSession();

        // 调用数据库操作方法


        MySQLGeneratorDao mapper = sqlsession.getMapper(MySQLGeneratorDao.class);
        List<Map<String, String>> selector = mapper.queryColumns("selector");


        sqlsession.close();


    }
}
