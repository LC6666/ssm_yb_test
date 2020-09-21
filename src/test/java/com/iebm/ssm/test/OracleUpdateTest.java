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
        		{"jdbc:oracle:thin:@192.168.29.50:1521:orcl","zmd_ssm_test","zmd_ssm_test","50","240"},
        		{"jdbc:oracle:thin:@192.168.29.50:1521:orcl","nc_ssm_test","nc_ssm_test","50","185"},
//        		{"jdbc:oracle:thin:@192.168.29.139:1521:orcl","yf_ssm_test01","yf_ssm_test01","139","240"},--已弃用
        		{"jdbc:oracle:thin:@192.168.29.144:1521:orcl","bz_ssm_test","bz_ssm_test","144","144"},
        		{"jdbc:oracle:thin:@192.168.29.144:1521:orcl","bt_ssm_test","bt_ssm_test","144","144"},//包头中医院
//        		{"jdbc:oracle:thin:@192.168.29.144:1521:orcl","sqsz_ssm_test","sqsz_ssm_test","144","144"},//事前事中
        		
        		
        		{"jdbc:oracle:thin:@192.168.29.171:1521:orcl","elht_ssm_test","elht_ssm_test","171","223"},               
                {"jdbc:oracle:thin:@192.168.29.171:1521:orcl","nm_mzl_ssm_test","nm_mzl_ssm_test","171","223"},
                {"jdbc:oracle:thin:@192.168.29.171:1521:orcl","nm_local_ssm_test","nm_local_ssm_test","171","185"},
                {"jdbc:oracle:thin:@192.168.29.171:1521:orcl","wh_ssm_test","wh_ssm_test","171","223"},
                {"jdbc:oracle:thin:@192.168.29.171:1521:orcl","wlcb_ssm_test","wlcb_ssm_test","171","185"},
                {"jdbc:oracle:thin:@192.168.29.171:1521:orcl","wlcb_drgs_ssm_test","wlcb_drgs_ssm_test","171","240"},
//                {"jdbc:oracle:thin:@192.168.29.171:1521:orcl","tc_ssm_test","tc_ssm_test","171"},

                {"jdbc:oracle:thin:@192.168.29.240:1521:orcl","als_ssm_test","als_ssm_test","240","240"},
                {"jdbc:oracle:thin:@192.168.29.240:1521:orcl","byze_ssm_test","byze_ssm_test","240","240"},
                {"jdbc:oracle:thin:@192.168.29.240:1521:orcl","hhht_ssm_test","hhht_ssm_test","240","240"},
                {"jdbc:oracle:thin:@192.168.29.240:1521:orcl","hlbe_ssm_test","hlbe_ssm_test","240","240"},
//                {"jdbc:oracle:thin:@192.168.29.240:1521:orcl","rules_ssm_test","rules_ssm_test","240","240"},
                
                
                {"jdbc:oracle:thin:@192.168.29.223:1521:orcl","bt_ssm_test","bt_ssm_test","223","185"},
                {"jdbc:oracle:thin:@192.168.29.223:1521:orcl","cf_ssm_test","cf_ssm_test","223","223"},
                {"jdbc:oracle:thin:@192.168.29.223:1521:orcl","eeds_ssm_test","eeds_ssm_test","223","223"},
                {"jdbc:oracle:thin:@192.168.29.223:1521:orcl","tl_ssm_test","tl_ssm_test","223","223"},
                {"jdbc:oracle:thin:@192.168.29.223:1521:orcl","xlgl_ssm_test","xlgl_ssm_test","223","223"},
                {"jdbc:oracle:thin:@192.168.29.223:1521:orcl","xam_ssm_test","xam_ssm_test","223","185"},
                {"jdbc:oracle:thin:@192.168.29.223:1521:orcl","yf_ssm_test02","yf_ssm_test02","223","240"},
                
                {"jdbc:oracle:thin:@192.168.29.249:1521:orcl","nm_clean_ssm","nm_clean_ssm","249"},
                {"jdbc:oracle:thin:@192.168.29.249:1521:orcl","bj_ssm_test","bj_ssm_test","249"},
//                {"jdbc:oracle:thin:@192.168.29.249:1521:orcl","tc_ssm_test","tc_ssm_test","249"},
                {"jdbc:oracle:thin:@192.168.29.249:1521:orcl","sy_drgs_ssm","sy_drgs_ssm","249","249"}
                
                
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


    public String[] setSQLs(){
        String[] sqls = {
        		"update mr_rule_drug t set re_code = (select re_code from amr_relation a where a.new_code = t.re_code and enable_ = 1)",
        		"update mr_disease t set t.enable_ = 0 where not exists (select '' from si_medical_information a where a.disease_code = t.dis_code)"
        };
        return sqls;
    }
    
    /**
     * 代入参数生成导入语句
     * @return
     */
    public String[] newSqls(){
    	int size = getDBinfo().length;
//    	String impdp_str = "impdp %s/%s directory=DUMP_DIR transform=segment_attributes:n dumpfile=rule_filrs.dmp remap_schema=bj_ssm_test:%s remap_tablespace=bj_ssm_test:%s;";
//    	String imp_str = "imp system/abc-123@192.168.29.249:1521:orcl file=/opt/oracle/dump/rule_filrs.dmp fromuser=bj_ssm_test touser=%s full=y ignore=y;";
    	String imp_str = "sqlldr userid=%s/%s@orcl_%s control=load1.ctl";
    	String[] str_arrs = new String[size];
    	for(int i=0 ;i<size;i++){
    		str_arrs[i] = String.format(imp_str, getDBinfo()[i][1],getDBinfo()[i][1],getDBinfo()[i][3]);
    		System.out.println(str_arrs[i]);
    	}
    	return str_arrs;
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
//        update.newSqls();


    }
}
