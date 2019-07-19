package com.iebm.ssm.test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Auther: LC
 * @Date: 2019/7/19 12:49
 * @Description:
 */

public class OracleUpdateTest {

    public static void main(String[] args) throws SQLException {
        String[][] dbinfo = {
                {"jdbc:oracle:thin:@192.168.29.171:1521:orcl","wlcb_ssm_test","wlcb_ssm_test"},
                {"jdbc:oracle:thin:@192.168.29.223:1521:orcl","bt_ssm_test","bt_ssm_test"},
                {"jdbc:oracle:thin:@192.168.29.171:1521:orcl","nm_local_ssm_test","nm_local_ssm_test"},
                {"jdbc:oracle:thin:@192.168.29.223:1521:orcl","xam_ssm_test","xam_ssm_test"},
                {"jdbc:oracle:thin:@192.168.29.171:1521:orcl","nm_mzl_ssm_test","nm_mzl_ssm_test"},
                {"jdbc:oracle:thin:@192.168.29.223:1521:orcl","cf_ssm_test","cf_ssm_test"},
                {"jdbc:oracle:thin:@192.168.29.171:1521:orcl","elht_ssm_test","elht_ssm_test"},
                {"jdbc:oracle:thin:@192.168.29.223:1521:orcl","tl_ssm_test","tl_ssm_test"},
                {"jdbc:oracle:thin:@192.168.29.171:1521:orcl","wh_ssm_test","wh_ssm_test"},
                {"jdbc:oracle:thin:@192.168.29.223:1521:orcl","xlgl_ssm_test","xlgl_ssm_test"},
                {"jdbc:oracle:thin:@192.168.29.223:1521:orcl","eeds_ssm_test","eeds_ssm_test"},
                {"jdbc:oracle:thin:@192.168.29.240:1521:orcl","als_ssm_test","als_ssm_test"},
                {"jdbc:oracle:thin:@192.168.29.240:1521:orcl","byze_ssm_test","byze_ssm_test"},
                {"jdbc:oracle:thin:@192.168.29.240:1521:orcl","hlbe_ssm_test","hlbe_ssm_test"},
                {"jdbc:oracle:thin:@192.168.29.240:1521:orcl","hhht_ssm_test","hhht_ssm_test"}

        };

//        String sql = "SELECT * FROM  (  SELECT t.*, ROWNUM RN FROM (SELECT * FROM MR_DISEASE) t  WHERE ROWNUM <= 25  )  WHERE RN >= 21";
        String sql = "insert into fw_menu (ID_, PARENTID_, CODE_, NAME_, URL_, DESCRIPTION_, ORDER_, TYPE_, LEVEL_, LEVELINDEX_, HIBERARCHY_, ISLEAF_, ISDEFAULTQUERY_, DEFAULTQUERYMODE_, CREATEBY_, CREATETIME_, LASTUPDATEBY_, LASTUPDATETIME_, ENABLE_) values (1182, 1181, '00170301', '药品说明书查询', '/app/standard/drugInstruction.jsp', '', '1', 'user', 3, 1, '1000-1017-1003-1001', 1, 1, 'block', 1, sysdate, 1, sysdate, 1)";
        OracleJDBCTest ora = new OracleJDBCTest();
        for (int i = 0;i<dbinfo.length;i++){
            Connection conn = ora.getConn(dbinfo[i][0],dbinfo[i][1] , dbinfo[i][2]);
//            System.out.println(sql);
            ora.executesql(sql);
            ora.closeCon(conn);
            System.out.println(dbinfo[i][1]);
        }

    }
}
