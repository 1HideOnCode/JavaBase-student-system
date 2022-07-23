package com.HZ_A9.utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class jdbcUtils {
    //mysql连接和关闭资源的工具类
    //因为只需要一份，需要static
    private static String user;
    private static String password;
    private static String url;
    private static String driver;

    //在static代码块去初始化
    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\mysql.properties"));

            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
            Class.forName(driver);
        } catch (IOException e) {
            //1.将编译异常转为运行一场
            //2.可以选择捕获异常或者默认处理
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //连接数据库
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /*
        关闭资源：
            1.ResultSet 结果集
            2.Statement 或者 PreparedStatement（父级接口：Statement）
            3.Connection
            4.如果需要关闭救出阿如对象，否则传入空
     */
    public static void close(ResultSet set, Statement statement, Connection connection){
        try {
            if(set != null){
                set.close();
            }
            if(statement!=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
