package com.iebm.ssm.test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Auther: LC
 * @Date: 2019/7/19 12:49
 * @Description:
 */

public class OracleUpdateTest {

    public String[][] getDBinfo(){
        String[][] dbinfo = {
//                185

                {"jdbc:oracle:thin:@192.168.29.240:1521:orcl","als_ssm_test","als_ssm_test"},
                {"jdbc:oracle:thin:@192.168.29.240:1521:orcl","byze_ssm_test","byze_ssm_test"},
                {"jdbc:oracle:thin:@192.168.29.223:1521:orcl","bt_ssm_test","bt_ssm_test"},
                {"jdbc:oracle:thin:@192.168.29.223:1521:orcl","cf_ssm_test","cf_ssm_test"},
                {"jdbc:oracle:thin:@192.168.29.223:1521:orcl","eeds_ssm_test","eeds_ssm_test"},
                {"jdbc:oracle:thin:@192.168.29.171:1521:orcl","elht_ssm_test","elht_ssm_test"},
                {"jdbc:oracle:thin:@192.168.29.240:1521:orcl","hhht_ssm_test","hhht_ssm_test"},
                {"jdbc:oracle:thin:@192.168.29.240:1521:orcl","hlbe_ssm_test","hlbe_ssm_test"},
                {"jdbc:oracle:thin:@192.168.29.171:1521:orcl","nm_mzl_ssm_test","nm_mzl_ssm_test"},
                {"jdbc:oracle:thin:@192.168.29.171:1521:orcl","nm_local_ssm_test","nm_local_ssm_test"},
//                涓嶇煡鐢ㄦ埛搴�
//                {"jdbc:oracle:thin:@192.168.29.171:1521:orcl","nm_local_ssm2_test","nm_local_ssm2_test"},
                {"jdbc:oracle:thin:@192.168.29.249:1521:orcl","bj_ssm_test","bj_ssm_test"},
                {"jdbc:oracle:thin:@192.168.29.223:1521:orcl","tl_ssm_test","tl_ssm_test"},
                {"jdbc:oracle:thin:@192.168.29.171:1521:orcl","wh_ssm_test","wh_ssm_test"},
                {"jdbc:oracle:thin:@192.168.29.171:1521:orcl","wlcb_ssm_test","wlcb_ssm_test"},
                {"jdbc:oracle:thin:@192.168.29.223:1521:orcl","xlgl_ssm_test","xlgl_ssm_test"},
                {"jdbc:oracle:thin:@192.168.29.223:1521:orcl","xam_ssm_test","xam_ssm_test"},
//                {"jdbc:oracle:thin:@192.168.29.240:1521:orcl","rules_ssm_test","rules_ssm_test"},
//                {"jdbc:oracle:thin:@192.168.29.139:1521:orcl","ssm_sy_new","ssm_sy_new"},
                {"jdbc:oracle:thin:@192.168.29.139:1521:orcl","yf_ssm_test01","yf_ssm_test01"},
//                {"jdbc:oracle:thin:@192.168.29.115:1521:orcl","ssm_sy_new","ssm_sy_new"},
//                {"jdbc:oracle:thin:@192.168.29.115:1521:orcl","wlcb_ssm_test","wlcb_ssm_test"},


                {"jdbc:oracle:thin:@192.168.29.249:1521:orcl","tc_ssm_test","tc_ssm_test"},
//                {"jdbc:oracle:thin:@192.168.29.249:1521:orcl","bt_ssm_test","bt_ssm_test"},宸插純鐢�
//                {"jdbc:oracle:thin:@192.168.29.249:1521:orcl","wh_ssm_test","wh_ssm_test"},宸插純鐢�
                {"jdbc:oracle:thin:@192.168.29.249:1521:orcl","sy_drgs_ssm","sy_drgs_ssm"},
//                {"jdbc:oracle:thin:@192.168.29.249:1521:orcl","yf_ssm_test01","yf_ssm_test01"},
                {"jdbc:oracle:thin:@192.168.29.223:1521:orcl","yf_ssm_test02","yf_ssm_test02"}

        };

        return dbinfo;
    }

    public String setSQL(){

        String sql ="create table si_extra_appeal_time (oid  NUMBER(18) not null, si_code   VARCHAR2(100), medical_information_id NUMBER(18), appeal_days             NUMBER(2), appeal_seq  NUMBER(2), finish_flag  NUMBER(1) )" ;
        return sql;
    }

    public String[] setSQLs(){
        String[] sqls = {
                "alter table si_billing_info_detail modify(QUANTITY NUMBER(26,4))",
                "alter table  SI_OTHER_DETAIL modify(QUANTITY NUMBER(26,4))",
                "alter table SI_TREATMENT_DETAIL modify(QUANTITY NUMBER(26,4))",
                "alter table SI_INSPECTION_DETAIL modify(QUANTITY NUMBER(26,4))",
                "alter table SI_MATERIALS_DETAIL modify(QUANTITY NUMBER(26,4))"
                };
        return sqls;
    }

    public void updateSql() throws SQLException{

        String sql = this.setSQL();
        OracleJDBCTest ora = new OracleJDBCTest();
        String[][] dbinfo = this.getDBinfo();
        for (int i = 0;i<dbinfo.length;i++){
            Connection conn = ora.getConn(dbinfo[i][0],dbinfo[i][1] , dbinfo[i][2]);
            System.out.println(dbinfo[i][1]);
//            System.out.println(sql);
            ora.executesql(sql);
            ora.closeCon(conn);

        }

    }


    public void updateSqls() throws SQLException{

        String[] sqls = this.setSQLs();
        OracleJDBCTest ora = new OracleJDBCTest();
        String[][] dbinfo = this.getDBinfo();
        for (int i = 0;i<dbinfo.length;i++){
            System.out.println(dbinfo[i][1]);
            Connection conn = ora.getConn(dbinfo[i][0],dbinfo[i][1] , dbinfo[i][2]);
            for(int x = 0;x<sqls.length;x++){
//                System.out.println(sqls[x]);
                ora.executesql(sqls[x]);
            }
            ora.closeCon(conn);

        }

    }

    public static void main(String[] args) throws SQLException {
        OracleUpdateTest update = new OracleUpdateTest();
        update.updateSqls();
//        update.updateSql();


    }
}