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
	
	
	private void getMysql(String sql) {
		myu.getConn();
		myu.executesql(sql);
	}
	
	

    public int getTotalPage() throws IOException, ClassNotFoundException, URISyntaxException {
        //        获取分页信息
        String url = Constant.url + "/app/illegalMedical/illegalMedicalAllotAction.action?method=queryAllRecord";
        List<NameValuePair> nameValuePairList = Lists.newArrayList();
        nameValuePairList.add(new BasicNameValuePair("institutionName",""));
        nameValuePairList.add(new BasicNameValuePair("institutionId",""));
        nameValuePairList.add(new BasicNameValuePair("institutionLevelKey",""));
        nameValuePairList.add(new BasicNameValuePair("diseaseName",""));
        nameValuePairList.add(new BasicNameValuePair("diseaseId",""));
        nameValuePairList.add(new BasicNameValuePair("startCreateTime","2020-05-01"));
        nameValuePairList.add(new BasicNameValuePair("endCreateTime","2020-08-31"));
        nameValuePairList.add(new BasicNameValuePair("siCode",""));
        nameValuePairList.add(new BasicNameValuePair("insuredName",""));
        nameValuePairList.add(new BasicNameValuePair("undefined",""));
        nameValuePairList.add(new BasicNameValuePair("pageRecords","200"));


        String response = DoRequest.dopost(url, nameValuePairList,MyCookieStore.readCookieStore("cookie"));

        if(JsonUtil.isJson(response)){
            JsonNode page = new ObjectMapper().readTree(response).get("page");
            int totalPages = page.get("totalPages").asInt();
            return totalPages;
        }
        return 0;

    }


//    
    /**
     * 分页遍历查询
     * @param totalPages 总页数
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws URISyntaxException
     */
    public void getPerPage(int totalPages) throws IOException, ClassNotFoundException, URISyntaxException {
        if(totalPages>0){
            String url = Constant.url + "/app/illegalMedical/illegalMedicalAllotAction.action?method=queryAllRecord";
            int illegalcount=0,normalcount=0;
            for(int pageNum=1;pageNum<=totalPages;pageNum++){
                List<NameValuePair> nameValuePairList = Lists.newArrayList();
                nameValuePairList.add(new BasicNameValuePair("pageRecords","200"));
                nameValuePairList.add(new BasicNameValuePair("orderInfo","-1,asc"));
                nameValuePairList.add(new BasicNameValuePair("gridbox","app.suspicion.allrecord.query.grid"));
                nameValuePairList.add(new BasicNameValuePair("title",""));
                nameValuePairList.add(new BasicNameValuePair("institutionName",""));
                nameValuePairList.add(new BasicNameValuePair("institutionId",""));
                nameValuePairList.add(new BasicNameValuePair("institutionLevelKey",""));
                nameValuePairList.add(new BasicNameValuePair("diseaseName",""));
                nameValuePairList.add(new BasicNameValuePair("diseaseId",""));
                nameValuePairList.add(new BasicNameValuePair("startCreateTime","2020-05-01"));
                nameValuePairList.add(new BasicNameValuePair("endCreateTime","2020-08-31"));
                nameValuePairList.add(new BasicNameValuePair("siCode",""));
                nameValuePairList.add(new BasicNameValuePair("insuredName",""));
                nameValuePairList.add(new BasicNameValuePair("institutionLevel",""));
                nameValuePairList.add(new BasicNameValuePair("undefined",""));
                nameValuePairList.add(new BasicNameValuePair("currentPage",String.valueOf(pageNum)));
                String PageResponse = DoRequest.dopost(url, nameValuePairList,MyCookieStore.readCookieStore("cookie"));
                if(JsonUtil.isJson(PageResponse)){
                    JsonNode rows = new ObjectMapper().readTree(PageResponse).get("rows");
                    if(rows.isArray()){
                        for (JsonNode row:rows){
                            JsonNode data = row.get("data");
                            String flag = data.get(22).asText();
                            String institutionName = data.get(5).asText();
                            String si_code = data.get(3).asText();
                            String diseaseName = data.get(7).asText();
                            String illegalFee_price = data.get(19).asText();
                            if(flag.equals("")){
//                            	正常病例计数
                            	normalcount++;                            
                            }else{
//                            	违规病例计数
                            	illegalcount++;
                            }
                            String miid = row.get("id").asText();
                            Map infoMap = new HashMap<>();
                            
//                          病例信息查看，获取费用信息
                            infoMap.put("miid", miid);
                            infoMap.put("institutionName", institutionName);
                            infoMap.put("si_code", si_code);
                            infoMap.put("diseaseName", diseaseName);
                            infoMap.put("illegalFee_price", illegalFee_price);
                            
                            infoMap = this.getAllFee(infoMap);
                            
                        }
                    }

                }else{
                    System.out.println("病例查询异常！");
                }
            }
            System.out.println("总病例中，正常病例有"+normalcount+"   违规病例有"+illegalcount);

        }

    }
    
    public Map getAllFee(Map infoMap) throws ClassNotFoundException, URISyntaxException, IOException {
//    	基本信息
    	infoMap = bii.cureInfoJointforHis(infoMap);
//    	System.out.println("总住院费用="+infoMap.get("totalFee_str")+	
//				"药品费用="+infoMap.get("drugFee_str")+	
//				"检查费用="+infoMap.get("inspectionFee_str")+
//				"治疗费用="+infoMap.get("treatmentFee_str")+ 
//				"其他费用="+infoMap.get("otherFee_str")+
//				"违规费用="+infoMap.get("ownExpense_str")+
//				"最终违规金额(元)"+infoMap.get("initialIllegalFee_str"));
    	
//    	统计费用
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
        sum_initialIllegalFee_price = sum_initialIllegalFee_price.add(initialIllegalFee_price);
        String sql = "insert into binglichaxun (si_code, miid, totalFee_price, drugFee_price, inspectionFee_price, treatmentFee_price, otherFee_price, initialIllegalFee_price,institutionName,diseaseName,illegalFee_price) values ('"
        			+infoMap.get("si_code")+"','"
        			+infoMap.get("miid")+"','"
        			+infoMap.get("totalFee_str")+"','"
        			+infoMap.get("drugFee_str")+"','"
        			+infoMap.get("inspectionFee_str")+"','"
        			+infoMap.get("treatmentFee_str")+"','"
        			+infoMap.get("otherFee_str")+"','"
        			+infoMap.get("initialIllegalFee_str")+"','"
					+infoMap.get("institutionName")+"','"
        			+infoMap.get("diseaseName")+"','"
        			+infoMap.get("illegalFee_price")+"')";
//        System.out.println(sql);
        this.getMysql(sql);
    	return infoMap;
    }
    
    

    public static void main(String[] args) throws IOException, URISyntaxException, ClassNotFoundException {
        Login login = new Login();
        login.openLoginPage();
        if(login.loginURL()){
            BingLiChaXun bc = new BingLiChaXun();
            int totalpage = bc.getTotalPage();
            bc.getPerPage(totalpage);
            System.out.println(bc.sum_totalFee_price.toString());
        }else {
            System.out.println("登录失败!退出请求!");
        }
    }
}
