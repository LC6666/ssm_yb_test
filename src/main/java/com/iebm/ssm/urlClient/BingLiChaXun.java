package com.iebm.ssm.urlClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iebm.ssm.util.Constant;
import com.iebm.ssm.util.JsonUtil;
import com.iebm.ssm.util.MyCookieStore;
import com.iebm.ssm.util.MysqlUtil;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.collections.Lists;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  TODO: 2018/12/29  病历查询
 */
public class BingLiChaXun {
	
	String illegalMedicalAll_url = "/app/illegalMedical/illegalMedicalAllotAction.action";
	
	BingLiChaXun_info bii = new BingLiChaXun_info();

	DecimalFormat df = new DecimalFormat("0.00");
	MysqlUtil myu = new MysqlUtil();
//	总住院费用
	String sum_totalFee_str = "";
	BigDecimal sum_totalFee_price = new BigDecimal("0.00");
//	药品费用
	String sum_drugFee_str = "";
	BigDecimal sum_drugFee_price = new BigDecimal("0.00");
//	检查费用
	String sum_inspectionFee_str = "";
	BigDecimal sum_inspectionFee_price = new BigDecimal("0.00");
//	治疗费用
	String sum_treatmentFee_str = "";
	BigDecimal sum_treatmentFee_price = new BigDecimal("0.00");
//	其他费用
	String sum_otherFee_str = "";
	BigDecimal sum_otherFee_price = new BigDecimal("0.00");
//	违规费用
	String sum_ownExpense_str = "";
	BigDecimal sum_ownExpense_price = new BigDecimal("0.00");
//	最终违规金额(元)
	String sum_initialIllegalFee_str = "";
	BigDecimal sum_initialIllegalFee_price = new BigDecimal("0.00");
	
	
	private String startCreateTime="",endCreateTime="" ;
	
	public BingLiChaXun(String startCreateTime,String endCreateTime) {
		// TODO Auto-generated constructor stub
//		nameValuePairList.add(new BasicNameValuePair("startCreateTime",startCreateTime));
//        nameValuePairList.add(new BasicNameValuePair("endCreateTime",endCreateTime));
//        this.setDefaultValuePair(0);
        this.startCreateTime=startCreateTime;
        this.endCreateTime=endCreateTime;
        MysqlUtil.getConn();
	}
	
	
	private void getMysql(String sql, Object[] value) {
		MysqlUtil.executesql(sql,value);
	}
	
	
	
	public List<NameValuePair> setDefaultValuePair(int pageNo) {
		List<NameValuePair> nameValuePairList = Lists.newArrayList();
		nameValuePairList.add(new BasicNameValuePair("method","queryAllRecord"));
		nameValuePairList.add(new BasicNameValuePair("institutionName",""));
        nameValuePairList.add(new BasicNameValuePair("institutionId",""));
        nameValuePairList.add(new BasicNameValuePair("institutionLevelKey",""));
        nameValuePairList.add(new BasicNameValuePair("diseaseName",""));
        nameValuePairList.add(new BasicNameValuePair("diseaseId",""));
        nameValuePairList.add(new BasicNameValuePair("startCreateTime",startCreateTime));
        nameValuePairList.add(new BasicNameValuePair("endCreateTime",endCreateTime));
//        nameValuePairList.add(new BasicNameValuePair("startCreateTime","2020-05-01"));
//        nameValuePairList.add(new BasicNameValuePair("endCreateTime","2020-08-31"));
        nameValuePairList.add(new BasicNameValuePair("siCode",""));
        nameValuePairList.add(new BasicNameValuePair("insuredName",""));
        nameValuePairList.add(new BasicNameValuePair("undefined",""));
        nameValuePairList.add(new BasicNameValuePair("pageRecords","200"));
		if(pageNo>0) {
			nameValuePairList.add(new BasicNameValuePair("orderInfo","-1,asc"));
            nameValuePairList.add(new BasicNameValuePair("gridbox","app.suspicion.allrecord.query.grid"));
            nameValuePairList.add(new BasicNameValuePair("title",""));
            nameValuePairList.add(new BasicNameValuePair("undefined",""));
            nameValuePairList.add(new BasicNameValuePair("currentPage",String.valueOf(pageNo)));			
		}
        
		return nameValuePairList;
	}
	
	
    
    public String getPerPages(List<NameValuePair> nameValuePairList) throws ClassNotFoundException, URISyntaxException, IOException {
		String response = DoRequest.dopost(Constant.url+illegalMedicalAll_url, nameValuePairList, MyCookieStore.readCookieStore("cookie"));
//		System.out.println(response);
		return response;
	}

    
    
    public void savePerPages(String response) throws Exception {
//    	int illegalcount=0,normalcount=0;
    	if(JsonUtil.isJson(response)){
            JsonNode page = new ObjectMapper().readTree(response).get("page");
            int totalPages = page.get("totalPages").asInt();
            JsonNode rows = new ObjectMapper().readTree(response).get("rows");
            this.savePerRecord(response);
            if(totalPages>1) {
            	int pageNo=2;
            	for(;pageNo<=totalPages;pageNo++) {
            		this.savePerRecord(this.getPerPages(this.setDefaultValuePair(pageNo)));
            	}	            	               	                
	                
            }            	
            
        }
    }
    
    
    public void savePerRecord(String response) throws Exception {
    	int illegalcount=0,normalcount=0;
    	JsonNode rows = new ObjectMapper().readTree(response).get("rows");
        if(rows.isArray()){
            for (JsonNode row:rows){
                JsonNode data = row.get("data");
                String flag = data.get(22).asText();
                String institutionName = data.get(5).asText();
                String discharge_date = data.get(10).asText();
                String si_code = data.get(3).asText();
                String diseaseName = data.get(7).asText();
                String illegalFee_price = data.get(19).asText();
                String totalWgCount = data.get(20).asText();
                String wglevel = data.get(21).asText();
                String doctor_name = data.get(11).asText();
                if(flag.equals("")){
//                	正常病例计数
                	normalcount++;                            
                }else{
//                	违规病例计数
                	illegalcount++;
                }
                String miid = row.get("id").asText();
                Map infoMap = new HashMap<>();
                
//             
                infoMap.put("miid", miid);
                infoMap.put("institutionName", institutionName);
                infoMap.put("si_code", si_code);
                infoMap.put("diseaseName", diseaseName);
                infoMap.put("illegalFee_price", illegalFee_price);
                infoMap.put("discharge_date", discharge_date);
                infoMap.put("totalWgCount", totalWgCount);
                infoMap.put("wglevel", wglevel);
                infoMap.put("doctor_name", doctor_name);
//              病例信息查看，获取费用信息
                infoMap = this.getAllFee(infoMap);
            }
        }
    }


    public Map getAllFee(Map infoMap) throws Exception {
//    	基本信息
    	infoMap = bii.cureInfoJointforHis(infoMap);
//    	测试打印
//    	===========================================================================
//    	System.out.println("总住院费用="+infoMap.get("totalFee_str")+	
//				"药品费用="+infoMap.get("drugFee_str")+	
//				"检查费用="+infoMap.get("inspectionFee_str")+
//				"治疗费用="+infoMap.get("treatmentFee_str")+ 
//				"其他费用="+infoMap.get("otherFee_str")+
//				"违规费用="+infoMap.get("ownExpense_str")+
//				"最终违规金额(元)"+infoMap.get("initialIllegalFee_str"));
//    	============================================================================
    	
//    	统计费用（需统计进可取消注释）
//    	=================================================================================
    	/**
    	BigDecimal totalFee_price = new BigDecimal(((String)infoMap.get("totalFee_str")));
    	sum_totalFee_price = sum_totalFee_price.add(totalFee_price);
        BigDecimal drugFee_price = new BigDecimal((String)infoMap.get("drugFee_str"));
        sum_drugFee_price = sum_drugFee_price.add(drugFee_price);
        BigDecimal inspectionFee_price = new BigDecimal((String)infoMap.get("inspectionFee_str"));
        sum_inspectionFee_price = sum_inspectionFee_price.add(inspectionFee_price);
        BigDecimal treatmentFee_price = new BigDecimal((String)infoMap.get("treatmentFee_str"));
        sum_treatmentFee_price = sum_treatmentFee_price.add(treatmentFee_price);
        BigDecimal otherFee_price  = new BigDecimal((String)infoMap.get("otherFee_str"));
        sum_otherFee_price = sum_otherFee_price.add(otherFee_price);
        BigDecimal initialIllegalFee_price  = new BigDecimal((String)infoMap.get("initialIllegalFee_str"));
        sum_initialIllegalFee_price = sum_initialIllegalFee_price.add(initialIllegalFee_price);**/
//    	=================================================================================
//    	保存病例信息到数据库
        String sql = "insert into binglichaxun (si_code, miid, totalFee_price, drugFee_price, inspectionFee_price, treatmentFee_price, otherFee_price, initialIllegalFee_price,institutionName,diseaseName,illegalFee_price,discharge_date,levelText,totalWgCount,wglevel,doctor_name) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//        System.out.println(sql);
        Object[] value = {infoMap.get("si_code"),infoMap.get("miid"),infoMap.get("totalFee_str"),infoMap.get("drugFee_str"),infoMap.get("inspectionFee_str"),
    					 infoMap.get("treatmentFee_str"),infoMap.get("otherFee_str"),infoMap.get("initialIllegalFee_str"),infoMap.get("institutionName"),infoMap.get("diseaseName"),
    					 infoMap.get("illegalFee_price"),infoMap.get("discharge_date"),infoMap.get("levelText"),infoMap.get("totalWgCount"),infoMap.get("wglevel"),infoMap.get("doctor_name")};
        this.getMysql(sql,value);
        
        BingLiChaXun_FeesDetail bfd = new BingLiChaXun_FeesDetail(infoMap);
//        bfd.getAllFeesDetail();
        Thread thread1 = new BingLiChaXun_Thread(bfd,1);
        Thread thread2 = new BingLiChaXun_Thread(bfd,2);
        Thread thread3 = new BingLiChaXun_Thread(bfd,3);
        Thread thread4 = new BingLiChaXun_Thread(bfd,4);
        Thread thread5 = new BingLiChaXun_Thread(bfd,5);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        
    	return infoMap;
    }
    

	
	
	public static void main(String[] args) throws Exception {
        Login login = new Login();
        login.openLoginPage();
        if(login.loginURL()){
            
        	BingLiChaXun binglichaxu = new BingLiChaXun("2020-07-01","2020-07-1");
        	binglichaxu.savePerPages(binglichaxu.getPerPages(binglichaxu.setDefaultValuePair(0)));
            
//            System.out.println(bc.sum_totalFee_price.toString());
        }else {
            System.out.println("登录失败!退出请求!");
        }
    }

	
	
}
