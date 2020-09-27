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

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class YiDianChaXun {
	
	private String illegalMedicalAllotAction_url = "/app/illegalMedical/illegalMedicalAllotAction.action";
	
	private String startCreateTime="",endCreateTime="" ;

    YiDianChaXun_BasicInfo basicInfo = new YiDianChaXun_BasicInfo();
    YiDianChaXun_DrugReport drugReport = new YiDianChaXun_DrugReport();
    DiseaseSelect diseaseSelect = new DiseaseSelect();
    HospitalSelect hospitalSelect = new HospitalSelect();
    DecimalFormat df = new DecimalFormat("0.00");
    
    
    public YiDianChaXun(String startCreateTime,String endCreateTime) {
    	MysqlUtil.getConn();
        df.setRoundingMode(RoundingMode.HALF_UP);
        this.startCreateTime = startCreateTime;
        this.endCreateTime = endCreateTime;
    }
    
    
    protected List<NameValuePair> setDefaultValuePair(int pageNo) {
    	List<NameValuePair> nameValuePairList = Lists.newArrayList();
    	nameValuePairList.add(new BasicNameValuePair("method","queryAll"));
		nameValuePairList.add(new BasicNameValuePair("institutionName",""));
        nameValuePairList.add(new BasicNameValuePair("institutionId",""));
        nameValuePairList.add(new BasicNameValuePair("institutionLevelKey",""));
        nameValuePairList.add(new BasicNameValuePair("institutionLevel",""));
        nameValuePairList.add(new BasicNameValuePair("diseaseName",""));
        nameValuePairList.add(new BasicNameValuePair("diseaseId",""));
        nameValuePairList.add(new BasicNameValuePair("startCreateTime",this.startCreateTime));
        nameValuePairList.add(new BasicNameValuePair("endCreateTime",this.endCreateTime));
        nameValuePairList.add(new BasicNameValuePair("siCode",""));
        nameValuePairList.add(new BasicNameValuePair("insuredName",""));
        nameValuePairList.add(new BasicNameValuePair("insuredAreaName",""));
        nameValuePairList.add(new BasicNameValuePair("insuredAreaCode",""));
        nameValuePairList.add(new BasicNameValuePair("handleState",""));
        nameValuePairList.add(new BasicNameValuePair("ruleNum",""));
        nameValuePairList.add(new BasicNameValuePair("illegalClass",""));
        nameValuePairList.add(new BasicNameValuePair("undefined",""));
        nameValuePairList.add(new BasicNameValuePair("pageRecords","200"));
         

		if(pageNo>0) {
			nameValuePairList.add(new BasicNameValuePair("orderInfo","-1,asc"));
            nameValuePairList.add(new BasicNameValuePair("gridbox","app.suspicion.doubtful.query.grid"));
            nameValuePairList.add(new BasicNameValuePair("title",""));
            nameValuePairList.add(new BasicNameValuePair("undefined",""));
            nameValuePairList.add(new BasicNameValuePair("currentPage",String.valueOf(pageNo)));			
		}
        
		return nameValuePairList;
	}
    
    
    
    /**
     * 疑点查询
     * @param nameValuePairList
     * @return
     * @throws ClassNotFoundException
     * @throws URISyntaxException
     * @throws IOException
     */
    public String getPerPages(List<NameValuePair> nameValuePairList) throws ClassNotFoundException, URISyntaxException, IOException {
		String response = DoRequest.dopost(Constant.url+illegalMedicalAllotAction_url, nameValuePairList, MyCookieStore.readCookieStore("cookie"));
//		System.out.println(response);
		return response;
	}
    
    
    public void savePerPages(String response) throws Exception {
//    	int illegalcount=0,normalcount=0;
    	if(JsonUtil.isJson(response)){
//    		System.out.println(response);
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
    	
    	JsonNode rows = new ObjectMapper().readTree(response).get("rows");
        if(rows.isArray()){
            for (JsonNode row:rows){
                JsonNode data = row.get("data");
                String illegalId = row.get("id").asText();
                String miid = data.get(2).asText();
                String pid=data.get(2).asText();
                String sicode=data.get(3).asText();
                String inhos_code=data.get(2).asText();
                String orgname=data.get(5).asText();
                String disname=data.get(7).asText();
                String indate=data.get(8).asText();
                String outdate=data.get(9).asText();
                String dischargedate=data.get(10).asText();
                String doctor=data.get(11).asText();
                String keshi=data.get(12).asText();
                String yidian=data.get(14).asText();
                String dswgj=data.get(15).asText();
                String dswgs=data.get(16).asText();
                String yswgj=data.get(17).asText();
                String yswgs=data.get(18).asText();
                String zwgj=data.get(19).asText();
                String zwgs=data.get(20).asText();
                String wglevel=data.get(21).asText();
                String area=data.get(23).asText();
                
//                保存病例信息到数据库
                String sql = "insert into yidianchaxun (si_code,pid, inhos_code, orgname, disname, indate, outdate, dischargedate,"
                		                  + "doctor,keshi,yidian,dswgj,dswgs,yswgj,yswgs,zwgj,zwgs,wglevel,area) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//                System.out.println(sql);
                Object[] value = {sicode, pid, inhos_code, orgname, disname, indate, outdate, dischargedate,doctor,keshi,yidian,dswgj,dswgs,yswgj,yswgs,zwgj,zwgs,wglevel,area};
                MysqlUtil.executesql(sql,value);
                
                Map infoMap = new HashMap<>();
                infoMap.put("miid", miid);
                infoMap.put("illegalId", illegalId);
                infoMap.put("si_code", sicode);
                infoMap.put("discharge_date", dischargedate);
                
                
                Thread thread1 = new YiDianChaXun_Thread(infoMap, 1);
                Thread thread2 = new YiDianChaXun_Thread(infoMap, 2);
                Thread thread3 = new YiDianChaXun_Thread(infoMap, 3);
                Thread thread4 = new YiDianChaXun_Thread(infoMap, 4);
                Thread thread5 = new YiDianChaXun_Thread(infoMap, 5);
                Thread thread6 = new YiDianChaXun_Thread(infoMap, 6);
                Thread thread7 = new YiDianChaXun_Thread(infoMap, 7);
                thread1.start();
                thread2.start();
                thread3.start();
                thread4.start();
                thread5.start();
                thread6.start();
                thread7.start();
              
            }
        }
    }
    
    
    public void getYiDianDetail(Map infoMap) {
    	YiDianChaXun_FeesDetail feesDetail = new YiDianChaXun_FeesDetail(infoMap);
    }


    public static void main(String[ ] args) throws Exception {
        Login login = new Login();
        login.openLoginPage();
        if(login.loginURL()){
            YiDianChaXun y = new YiDianChaXun("2020-07-01","2020-07-31");
            y.savePerPages(y.getPerPages(y.setDefaultValuePair(0)));
        }else {
            System.out.println("登录失败!退出请求!");
        }

    }

}
