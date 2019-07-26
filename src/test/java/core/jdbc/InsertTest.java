package core.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.Test;

import java.sql.*;

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
    public void test1() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://139.224.14.200:3306/soul");
        config.setUsername("root");
        config.setPassword("root");
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
}
