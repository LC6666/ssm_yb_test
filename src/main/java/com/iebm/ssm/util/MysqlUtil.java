package com.iebm.ssm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlUtil {
	
	private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private PreparedStatement ps = null;
    private String url = "jdbc:mysql://127.0.0.1:3306/ssm_yb_test?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
    private String user = "root";
    private String passowrd = "root";


    public Connection getConn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //本机，服务名，用户，密码
            connect= DriverManager.getConnection(url,user,passowrd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return connect;

    }

    
//  更新函数
  public void executesql(String sql){
      try {
//      	System.out.println(sql);
          statement = connect.createStatement();
          statement.executeUpdate(sql);
          statement.close();
      } catch (SQLException e) {
          e.printStackTrace();
      }
  }

  // 查询函数
  public void query(Connection conn,String sql) {
      try {
          statement = connect.createStatement();
          resultSet = statement.executeQuery(sql);
          while (resultSet.next()) {
              System.out.println(resultSet.getString(1) + "\t"
                      + resultSet.getString(2) + "\t" + resultSet.getString(3));
          }
      } catch (Exception e) {
          e.printStackTrace();
      }

  }


  /*关闭数据库连接*/
  public void closeCon(Connection con) throws SQLException {
      if (con != null)
          con.close();
  }

}
