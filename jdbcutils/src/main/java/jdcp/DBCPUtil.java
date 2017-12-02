package jdcp;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: yangzhaoyunfei
 * Time: 2017/12/1 14:43
 * To change this template use File | Settings | File and Code Templates.
 */

public class DBCPUtil {
    private static DataSource datasource = null;

    // 得到池子
    static {
        Properties properties = new Properties();
        try {
            //加载配置文件
            properties.load(DBCPUtil.class.getClassLoader().getResourceAsStream("dbcp.properties"));

            datasource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取连接，return 跳出它所在的方法
    public static Connection getConnection() {
        try {
            return datasource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //释放连接资源，在DBCP方法里，普通关闭方法应该已经被代理为放回连接池了，就像使用普通连接一样
    public static void releaseConnection(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }
}
