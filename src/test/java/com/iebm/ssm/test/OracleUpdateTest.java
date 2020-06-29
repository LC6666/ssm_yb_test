package com.iebm.ssm.test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Auther: LC
 * @Date: 2019/7/19 12:49
 * @Description:
 */

public class OracleUpdateTest {

	/**
	 * 数据库配置
	 * @return
	 */
	private static String[][] getDBinfo(){
        String[][] dbinfo = {
        		{"jdbc:oracle:thin:@192.168.29.139:1521:orcl","yf_ssm_test01","yf_ssm_test01","139","240"},
        		
        		{"jdbc:oracle:thin:@192.168.29.171:1521:orcl","elht_ssm_test","elht_ssm_test","171","223"},               
                {"jdbc:oracle:thin:@192.168.29.171:1521:orcl","nm_mzl_ssm_test","nm_mzl_ssm_test","171","223"},
                {"jdbc:oracle:thin:@192.168.29.171:1521:orcl","nm_local_ssm_test","nm_local_ssm_test","171","185"},
                {"jdbc:oracle:thin:@192.168.29.171:1521:orcl","wh_ssm_test","wh_ssm_test","171","223"},
                {"jdbc:oracle:thin:@192.168.29.171:1521:orcl","wlcb_ssm_test","wlcb_ssm_test","171","185"},
                {"jdbc:oracle:thin:@192.168.29.171:1521:orcl","wlcb_drgs_ssm_test","wlcb_drgs_ssm_test","171","240"},
                {"jdbc:oracle:thin:@192.168.29.171:1521:orcl","tc_ssm_test","tc_ssm_test","171"},

                {"jdbc:oracle:thin:@192.168.29.240:1521:orcl","als_ssm_test","als_ssm_test","240","240"},
                {"jdbc:oracle:thin:@192.168.29.240:1521:orcl","byze_ssm_test","byze_ssm_test","240","240"},
                {"jdbc:oracle:thin:@192.168.29.240:1521:orcl","hhht_ssm_test","hhht_ssm_test","240","240"},
                {"jdbc:oracle:thin:@192.168.29.240:1521:orcl","hlbe_ssm_test","hlbe_ssm_test","240","240"},
                {"jdbc:oracle:thin:@192.168.29.240:1521:orcl","rules_ssm_test","rules_ssm_test"},
                
                {"jdbc:oracle:thin:@192.168.29.223:1521:orcl","bt_ssm_test","bt_ssm_test","223","185"},
                {"jdbc:oracle:thin:@192.168.29.223:1521:orcl","cf_ssm_test","cf_ssm_test","223","223"},
                {"jdbc:oracle:thin:@192.168.29.223:1521:orcl","eeds_ssm_test","eeds_ssm_test","223","223"},
                {"jdbc:oracle:thin:@192.168.29.223:1521:orcl","tl_ssm_test","tl_ssm_test","223","223"},
                {"jdbc:oracle:thin:@192.168.29.223:1521:orcl","xlgl_ssm_test","xlgl_ssm_test","223","223"},
                {"jdbc:oracle:thin:@192.168.29.223:1521:orcl","xam_ssm_test","xam_ssm_test","223","185"},
                
                {"jdbc:oracle:thin:@192.168.29.249:1521:orcl","bj_ssm_test","bj_ssm_test","249"},
//                {"jdbc:oracle:thin:@192.168.29.249:1521:orcl","tc_ssm_test","tc_ssm_test","249"},
                {"jdbc:oracle:thin:@192.168.29.249:1521:orcl","sy_drgs_ssm","sy_drgs_ssm","249","249"},
                {"jdbc:oracle:thin:@192.168.29.223:1521:orcl","yf_ssm_test02","yf_ssm_test02","223","240"}
                
                
//                
//                {"jdbc:oracle:thin:@192.168.29.171:1521:orcl","nm_local_ssm2_test","nm_local_ssm2_test"},                
//                {"jdbc:oracle:thin:@192.168.29.139:1521:orcl","ssm_sy_new","ssm_sy_new"},                
//                {"jdbc:oracle:thin:@192.168.29.115:1521:orcl","ssm_sy_new","ssm_sy_new"},
//                {"jdbc:oracle:thin:@192.168.29.115:1521:orcl","wlcb_ssm_test","wlcb_ssm_test"},



//                {"jdbc:oracle:thin:@192.168.29.249:1521:orcl","bt_ssm_test","bt_ssm_test"},宸插純鐢�
//                {"jdbc:oracle:thin:@192.168.29.249:1521:orcl","wh_ssm_test","wh_ssm_test"},宸插純鐢�
                
//                {"jdbc:oracle:thin:@192.168.29.249:1521:orcl","yf_ssm_test01","yf_ssm_test01"},
                

        };

        return dbinfo;
    }

    public String setSQL(){

        String sql ="INSERT INTO \"FW_SCHEDULE_IP\"(\"ID_\", \"SCHEDULEID_\", \"SERVERIP_\", \"CREATEBY_\", \"CREATETIME_\", \"LASTUPDATEBY_\", \"LASTUPDATETIME_\", \"ENABLE_\") VALUES ('1164', '1001', '192.168.29.%s', '10000', TO_TIMESTAMP('2020-06-02 14:17:20.997000', 'SYYYY-MM-DD HH24:MI:SS:FF6'), '10000', TO_TIMESTAMP('2020-06-02 14:17:20.997000', 'SYYYY-MM-DD HH24:MI:SS:FF6'), '1')";
		
        
        return sql;
    }

    public String[] setSQLs(){
        String[] sqls = {
        		"alter table SI_MEDICAL_INFORMATION_HIS_TMP add sing_dis_set_flag varchar2(10)",
        		"alter table SI_MEDICAL_INFORMATION_HIS_TMP add complications_flag varchar2(10)",
        		"alter table SI_MEDICAL_INFORMATION_HIS_TMP add quit_sing_dis_flag varchar2(10)",
        		"alter table SI_MEDICAL_INFORMATION_HIS_TMP add quit_sing_dis_dept varchar2(20)",
        		"alter table SI_MEDICAL_INFORMATION_HIS_TMP add quit_sing_dis_cause varchar2(500)",
        		"comment on column SI_MEDICAL_INFORMATION_HIS_TMP.sing_dis_set_flag is '普通住院单病种结算标志（1：是，其他不是）'",
        		"comment on column SI_MEDICAL_INFORMATION_HIS_TMP.complications_flag is '0 无 1 存在合并症 2 存在并发症(手术过程中) 3 同时存在合并症、并发症(手术过程中) '",
        		"comment on column SI_MEDICAL_INFORMATION_HIS_TMP.quit_sing_dis_flag is '退出单病种结算标志（1：是，其他不是）'",
        		"comment on column SI_MEDICAL_INFORMATION_HIS_TMP.quit_sing_dis_dept is '申请退出单病种结算科室'",
        		"comment on column SI_MEDICAL_INFORMATION_HIS_TMP.quit_sing_dis_cause is '申请退出单病种结算原因'"
        		
        		
        		
        };
        return sqls;
    }
    
    /**
     * 代入参数生成导入语句
     * @return
     */
    public String[] newSqls(){
//    	String impdp_str = "impdp %s/%s directory=DUMP_DIR transform=segment_attributes:n dumpfile=rule_filrs.dmp remap_schema=bj_ssm_test:%s remap_tablespace=bj_ssm_test:%s;";
//    	String imp_str = "imp system/abc-123@192.168.29.249:1521:orcl file=/opt/oracle/dump/rule_filrs.dmp fromuser=bj_ssm_test touser=%s full=y ignore=y;";
    	String imp_str = "imp %s/%s@ORCL_%s file=C:\\rule_files.dmp fromuser=bj_ssm_test ignore=y";
    	String[] str_arrs = new String[20];
    	for(int i=0 ;i<20;i++){
    		str_arrs[i] = String.format(imp_str, getDBinfo()[i][1],getDBinfo()[i][2],getDBinfo()[i][3]);
    		System.out.println(str_arrs[i]);
    	}
    	return str_arrs;
    }

//    单一sql语句执行
    public void updateSql() throws SQLException{

        String sql = this.setSQL();
        OracleJDBCTest ora = new OracleJDBCTest();
        String[][] dbinfo = getDBinfo();
        for (int i = 0;i<dbinfo.length;i++){
            Connection conn = ora.getConn(dbinfo[i][0],dbinfo[i][1] , dbinfo[i][2]);
            System.out.println(dbinfo[i][1]);
//            String new_sql = sql.format(sql, dbinfo[i][4]);
//            System.out.println(new_sql);
            ora.executesql(sql);
            ora.closeCon(conn);

        }

    }


//    多sql语句执行
    public void updateSqls() throws SQLException{

        String[] sqls = this.setSQLs();
        OracleJDBCTest ora = new OracleJDBCTest();
        String[][] dbinfo = getDBinfo();
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
//        update.newSqls();


    }
}
