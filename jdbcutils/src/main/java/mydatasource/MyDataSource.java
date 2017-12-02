package mydatasource;



import mydatasource.conf.ConfigurationManager;
import mydatasource.constants.Constants;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: yangzhaoyunfei
 * Time: 2017/12/2 13:17
 * To change this template use File | Settings | File and Code Templates.
 */
public class MyDataSource implements DataSource {

    private static final Integer datasourcesize = ConfigurationManager.getInteger(Constants.JDBC_DATASOURCE_SIZE);
    // 链表 --- 实现 栈结构 、队列 结构
    private LinkedList<Connection> datasource = new LinkedList<Connection>();

    public MyDataSource() {
        // 一次性创建固定数量个连接
        for (int i = 0; i < datasourcesize; i++) {
            try {
                Connection conn = this.getConnection();
                // 将连接加入连接池中
                datasource.add(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public Connection getConnection() throws SQLException {
        // 取出连接池中一个连接
        final Connection conn = datasource.removeFirst(); // 删除第一个连接返回
        System.out.println("取出一个连接剩余 " + datasource.size() + "个连接！");
        // 将目标Connection对象进行增强
        Connection connProxy = (Connection) Proxy.newProxyInstance(conn
                .getClass().getClassLoader(), conn.getClass().getInterfaces(), new InvocationHandler() {
            // 执行代理对象任何方法 都将执行 invoke

            public Object invoke(Object proxy, Method method,
                                 Object[] args) throws Throwable {
                if (method.getName().equals("close")) {
                    // 需要加强的方法
                    // 不将连接真正关闭，将连接放回连接池
                    releaseConnection(conn);
                    return null;
                } else {
                    // 不需要加强的方法
                    return method.invoke(conn, args); // 调用真实对象方法
                }
            }
        });
        return connProxy;
    }


    // 将连接放回连接池
    public void releaseConnection(Connection conn) {
        datasource.add(conn);
        System.out.println("将连接 放回到连接池中 数量:" + datasource.size());
    }

    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    public void setLoginTimeout(int seconds) throws SQLException {

    }

    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }


    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
