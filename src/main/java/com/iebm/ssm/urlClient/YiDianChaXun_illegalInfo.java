package com.iebm.ssm.urlClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.collections.Lists;
import com.iebm.ssm.util.Constant;
import com.iebm.ssm.util.JsonUtil;
import com.iebm.ssm.util.MyCookieStore;
import com.iebm.ssm.util.MysqlUtil;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YiDianChaXun_illegalInfo {

	private String loadDoubtDetail_url = "/app/diagnoseRelevant/view/diagnoseRelevantAction.action";
	private Map infoMap;
	
	public YiDianChaXun_illegalInfo(Map infoMap) {
		// TODO Auto-generated constructor stub
		this.infoMap = infoMap;
		MysqlUtil.getConn();
	}

	private List<NameValuePair> setDefaultValuePair(String illegalId) {

		List<NameValuePair> nameValuePairList = Lists.newArrayList();
		nameValuePairList.add(new BasicNameValuePair("method", "loadDoubtDetail"));
		nameValuePairList.add(new BasicNameValuePair("pageRecords", "100"));
		nameValuePairList.add(new BasicNameValuePair("illegalId", illegalId));
		nameValuePairList.add(new BasicNameValuePair("pageRecords", "undefined"));
		return nameValuePairList;
	}

	/**
	 * 查询疑点信息
	 * 
	 * @param infoMap
	 * @throws URISyntaxException
	 * @throws IOException
	 */

	public void getIllegalInfo() throws IOException, ClassNotFoundException, URISyntaxException {

		String illegalId = infoMap.get("illegalId").toString();
		String response = DoRequest.dopost(Constant.url+loadDoubtDetail_url, this.setDefaultValuePair(illegalId),
				MyCookieStore.readCookieStore("cookie"));
		if (JsonUtil.isJson(response)) {
			JsonNode page = new ObjectMapper().readTree(response);

			int totalPages = page.get("page").get("totalPages").asInt();
			JsonNode rows = new ObjectMapper().readTree(response).get("rows");
			this.savePerRecord(response);
		}
	}

	
	public void savePerRecord(String response) throws IOException {
    	JsonNode rows = new ObjectMapper().readTree(response).get("rows");
    	String sql = "INSERT INTO yidianchaxun_ydxx (si_code, ruleinfo, rulefile, rulelevel, wgtype, endstatus, wgprice, yswgprice, ydms, jswg, jsydms,discharge_date) VALUES ";
		String setchar = "(?,?,?,?,?,?,?,?,?,?,?,?)";
		String s = "";
		String si_code = infoMap.get("si_code").toString();
		List value_arr = new ArrayList<>();
        for (JsonNode row :rows ) {
            JsonNode data = row.get("data");
            String ruleinfo = data.get(1).asText();
            String rulefile = data.get(2).asText();
            String rulelevel = data.get(3).asText();
            String wgtype = data.get(4).asText();
            String endstatus = data.get(5).asText();
            String wgprice = data.get(6).asText();
            String yswgprice = data.get(7).asText();
            String ydms = data.get(8).asText();
            String jswg = data.get(9).asText();
            String jsydms = data.get(10).asText();
            
            s = s.concat(setchar).concat(",");
			Object[] value = { si_code, ruleinfo, rulefile, rulelevel, wgtype, endstatus, wgprice, yswgprice, ydms, jswg, jsydms,infoMap.get("discharge_date")};
			value_arr.add(value);
            }
        String newSql = sql.concat(s);
		MysqlUtil.executesql(newSql.substring(0, newSql.length() - 1), value_arr);
    }
	
	
	public static void main(String[] args) throws URISyntaxException, IOException, ClassNotFoundException {
		Login login = new Login();
        login.openLoginPage();
        if(login.loginURL()){
        	Map infoMap = new HashMap();
        	infoMap.put("si_code", "1298262");
			infoMap.put("illegalId", "622806");
			infoMap.put("discharge_date", "2020-05-05");
            YiDianChaXun_illegalInfo yi = new YiDianChaXun_illegalInfo(infoMap);
            yi.getIllegalInfo();
        }else {
            System.out.println("登录失败!退出请求!");
        }

	}
	
}
