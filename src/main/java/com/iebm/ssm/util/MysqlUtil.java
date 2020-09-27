package com.iebm.ssm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class MysqlUtil {
	
	private static Connection connect = null;
    private static Statement statement = null;
    private ResultSet resultSet = null;
    private PreparedStatement ps = null;
    private static String url = "jdbc:mysql://127.0.0.1:3306/ssm_yb_test?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
    private static String user = "root";
    private static String passowrd = "root";


    public static Connection getConn(){
    	if(connect==null) {
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
    	}
        
        return connect;

    }

    
//  更新函数
  public static void executesql(String sql, Object[] value){
      try {
//      	System.out.println(sql);
    	  
//          statement = connect.createStatement();
//          statement.executeUpdate(sql);
//          statement.close();
          PreparedStatement pstmt = connect.prepareStatement(sql);
          for(int i=0;i<value.length;i++) {
        	  pstmt.setString(i+1,value[i].toString());
          }
          
          pstmt.executeUpdate();
      } catch (SQLException e) {
          e.printStackTrace();
      }
  }
  
  
//更新函数
public static void executesql(String sql, List<Object[]> value){
    try {
    	if(value.size()>0) {
    		PreparedStatement pstmt = connect.prepareStatement(sql);
            int size = value.size();
            int len = value.get(0).length;
            int k=1;
            for(int i=0;i<size;i++) {
            	for(int j=0;j<len;j++) {
            		pstmt.setString(k, value.get(i)[j].toString());
            		k++;
            	}
            	
            }
            pstmt.executeUpdate();
    	}
    	else {
//    		System.out.println(sql);
    	}
        
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
//  public void closeCon(Connection con) throws SQLException {
//      if (con != null)
//          con.close();
//  }
  
  public static void closeCon() throws SQLException {
	  if(statement!=null){
		statement.close();  
	  }
      if (connect != null)
    	  connect.close();
  }


}
