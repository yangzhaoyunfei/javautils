package mydatasource.conf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 配置加载管理类
 */

public class ConfigurationManager {

    // 配置属性
    private static Properties properties = new Properties();

    static {
        InputStream in = ConfigurationManager.class.getClassLoader().getResourceAsStream("my.properties");
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //测试
    public static void main(String[] args) {
        System.out.println(properties);
        System.out.println(getProperty("kafka.topics"));

    }

    /**
     * 获取关键字对应的配置项
     *
     * @param key
     * @return
     */
    private static String getProperty(String key) {
        return properties.getProperty(key);
    }


    /**
     * 获取String配置项
     *
     * @param key
     * @return
     */
    public static String getString(String key) {
        return getProperty(key);
    }

    /**
     * 获取Integer型配置项
     *
     * @param key
     * @return
     */
    public static Integer getInteger(String key) {
        String value = getProperty(key);
        try {
            return Integer.valueOf(value);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * 获取Boolean型配置项
     *
     * @param key
     * @return
     */
    public static Boolean getBoolean(String key) {
        String value = getProperty(key);
        try {
            return Boolean.valueOf(value);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 获取Long型配置项
     *
     * @param key
     * @return
     */
    public static Long getLong(String key) {
        String value = getProperty(key);
        try {
            return Long.valueOf(value);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0L;
    }

    /**
     * 获取Double型配置项
     *
     * @param key
     * @return
     */
    public static Double getDouble(String key) {
        String value = getProperty(key);
        try {
            return Double.valueOf(value);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0.0D;
    }
}
