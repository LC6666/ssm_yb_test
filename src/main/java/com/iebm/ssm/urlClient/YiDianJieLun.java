package com.iebm.ssm.urlClient;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.collections.Lists;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iebm.ssm.util.Constant;
import com.iebm.ssm.util.JsonUtil;
import com.iebm.ssm.util.MyCookieStore;
import com.iebm.ssm.util.MysqlUtil;

public class YiDianJieLun {

	private String processAuditAction_url = "/app/process/processAuditAction.action";
	private String startCreateTime = "", endCreateTime = "";

	public YiDianJieLun(String startCreateTime, String endCreateTime) {
    	MysqlUtil.getConn();
		this.startCreateTime = startCreateTime;
		this.endCreateTime = endCreateTime;
	}

	protected List<NameValuePair> setDefaultValuePair(int pageNo) {
		List<NameValuePair> nameValuePairList = Lists.newArrayList();
		nameValuePairList.add(new BasicNameValuePair("method", "loadEndAuditAll"));
		nameValuePairList.add(new BasicNameValuePair("institutionName", ""));
		nameValuePairList.add(new BasicNameValuePair("institutionId", ""));
		nameValuePairList.add(new BasicNameValuePair("institutionLevelKey", ""));
		nameValuePairList.add(new BasicNameValuePair("diseaseName", ""));
		nameValuePairList.add(new BasicNameValuePair("diseaseId", ""));
		nameValuePairList.add(new BasicNameValuePair("startCreateTime", this.startCreateTime));
		nameValuePairList.add(new BasicNameValuePair("endCreateTime", this.endCreateTime));
		nameValuePairList.add(new BasicNameValuePair("siCode", ""));
		nameValuePairList.add(new BasicNameValuePair("insuredAreaName", ""));
		nameValuePairList.add(new BasicNameValuePair("insuredAreaCode", ""));
		nameValuePairList.add(new BasicNameValuePair("doctorName", ""));
		nameValuePairList.add(new BasicNameValuePair("ruleName", ""));
		nameValuePairList.add(new BasicNameValuePair("ruleId", ""));
		nameValuePairList.add(new BasicNameValuePair("ssmName", ""));
		nameValuePairList.add(new BasicNameValuePair("galMemo", ""));
		nameValuePairList.add(new BasicNameValuePair("institutionLevel", ""));
		nameValuePairList.add(new BasicNameValuePair("illegalClass", ""));
		nameValuePairList.add(new BasicNameValuePair("illegalResult", ""));
		nameValuePairList.add(new BasicNameValuePair("insuranceType", ""));
		nameValuePairList.add(new BasicNameValuePair("undefined", ""));
		nameValuePairList.add(new BasicNameValuePair("state", ""));

		if (pageNo > 0) {
			nameValuePairList.add(new BasicNameValuePair("orderInfo", "-1,asc"));
			nameValuePairList.add(new BasicNameValuePair("gridbox", "app.audit.conclusionAudit.query.grid"));
			nameValuePairList.add(new BasicNameValuePair("title", ""));
			nameValuePairList.add(new BasicNameValuePair("undefined", ""));
			nameValuePairList.add(new BasicNameValuePair("currentPage", String.valueOf(pageNo)));
		}

		return nameValuePairList;
	}

	public String getPerPages(List<NameValuePair> nameValuePairList)
			throws ClassNotFoundException, URISyntaxException, IOException {
		String response = DoRequest.dopost(Constant.url + processAuditAction_url, nameValuePairList,
				MyCookieStore.readCookieStore("cookie"));
		return response;
	}

	public void savePerPages(String response) throws Exception {
//	    	int illegalcount=0,normalcount=0;
		if (JsonUtil.isJson(response)) {
//	    		System.out.println(response);
			JsonNode page = new ObjectMapper().readTree(response).get("page");
			int totalPages = page.get("totalPages").asInt();
			JsonNode rows = new ObjectMapper().readTree(response).get("rows");
			this.savePerRecord(response);
			if (totalPages > 1) {
				int pageNo = 2;
				for (; pageNo <= totalPages; pageNo++) {
					this.savePerRecord(this.getPerPages(this.setDefaultValuePair(pageNo)));
				}

			}

		}
	}

	public void savePerRecord(String response) throws Exception {

		JsonNode rows = new ObjectMapper().readTree(response).get("rows");
		if (rows.isArray()) {
			for (JsonNode row : rows) {
				JsonNode data = row.get("data");
				String sicode= data.get(2).asText();
				String incode= data.get(3).asText();
				String institutionName= data.get(4).asText();
				String insuredName= data.get(5).asText();
				String diseaseName= data.get(6).asText();
				String galMemo= data.get(7).asText();
				String indate= data.get(9).asText();
				String outdate= data.get(10).asText();
				String dischargedate= data.get(11).asText();
				String doctor= data.get(12).asText();
				String departmentName= data.get(13).asText();
				String dswgje= data.get(14).asText();
				String dswgs= data.get(15).asText();
				String yswgje= data.get(16).asText();
				String yswgs= data.get(17).asText();
				String zwgje= data.get(18).asText();
				String zwgs= data.get(19).asText();
				String illegalClass= data.get(20).asText();
				String handleState= data.get(21).asText();
				String illegalResult= data.get(22).asText();
				String insuredAreaName= data.get(23).asText();

//	                保存病例信息到数据库
				String sql = "INSERT INTO yidianjielun (sicode, incode, institutionName, insuredName, diseaseName, galMemo, indate, outdate, dischargedate, doctor, departmentName, dswgje, dswgs, yswgje, yswgs, zwgje, zwgs, illegalClass, handleState, illegalResult, insuredAreaName) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//	                System.out.println(sql);
				Object[] value = { sicode, incode, institutionName, insuredName, diseaseName, galMemo, 
									indate, outdate, dischargedate, doctor, departmentName, dswgje, dswgs, 
									yswgje, yswgs, zwgje, zwgs, illegalClass, handleState, illegalResult, insuredAreaName};
				MysqlUtil.executesql(sql, value);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Login login = new Login();
		login.openLoginPage();
		if (login.loginURL()) {
			YiDianJieLun y = new YiDianJieLun("2020-06-01", "2020-06-30");
            y.savePerPages(y.getPerPages(y.setDefaultValuePair(0)));
		} else {
			System.out.println("登录失败!退出请求!");
		}

	}

}
