package com.iebm.ssm.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 读取mysql数据
 * @Auther: LC
 * @Date: 2019/3/8 17:19
 * @Description:
 */

public class TestDataDrivenByMysql {

    public static Object[][] getTestData(String tablename) throws ClassNotFoundException {
//      声明Mysql数据库的驱动
        String driver = "com.mysql.cj.jdbc.Driver";
//      声明本地数据库的IP地址和数据库名称
        String url = "jdbc:mysql://127.0.0.1:3306/ssm_yb_test?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
//      声明数据库的用户名。为简化数据库权限设定等操作，本例使用数据库的root用户进行操作
//      在正式对外服务的生产数据库中，建议使用非root的用户账户进行自动化测试的相关操作
        String user="root";
        String password="root";
//      声明存储测试数据的list对象
        List<Object[]> records = new ArrayList<Object[]>();
//      设定驱动
        Class.forName(driver);
        try {
            Connection conn = DriverManager.getConnection(url,user,password);
            if(!conn.isClosed()){
//                System.out.println("连接数据库成功！");
                //          创建statement对象
                Statement statement = conn.createStatement();
//          使用函数参数拼接要执行的sql语句，此语句用来获取数据表的所有行
                String sql ="select * from "+tablename;
//          声明一个ResultSet对象，存取执行SQL语句后返回的数据结果集
                ResultSet resultSet = statement.executeQuery(sql);
//          声明一个ResultSetMetaData对象
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
//          调用ResultSetMetaData对象的getColumnCount方法，获取数据行的列数
                int cols = resultSetMetaData.getColumnCount();
//          使用next方法遍历数据结果集中的所有数据行
                while (resultSet.next()){
//              声明一个字符型数组，数组大小使用数据行的列个数进行声明
                    String fileds[] = new String[cols];
                    int col=0;
//              遍历所有数据行中的所有列数据，并存储在字符数组中
                    for(int colindex=0;colindex<cols;colindex++){
                        fileds[col] = resultSet.getString(colindex+1);
                        col++;
                    }
//              将每一行的数据存储到字符数组之后，存储到records中
                    records.add(fileds);
//              输出数据行中的前三列内容，用于验证数据库内容是否正确取出
//                System.out.println(resultSet.getString(1)+"   "+resultSet.getString(2)+"   "+resultSet.getString(3));

                }
//            关闭数据结果集对象
                resultSet.close();
                conn.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        Object[][] results = new Object[records.size()][];
        for(int i=0;i<records.size();i++){
            results[i] = records.get(i);
        }

        return results;

    }
}
