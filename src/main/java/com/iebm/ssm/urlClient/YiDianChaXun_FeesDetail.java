package com.iebm.ssm.urlClient;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.compress.utils.Lists;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iebm.ssm.util.Constant;
import com.iebm.ssm.util.MyCookieStore;
import com.iebm.ssm.util.MysqlUtil;

public class YiDianChaXun_FeesDetail {

	private String getDetail_url = "/app/diagnoseRelevant/view/diagnoseRelevantAction.action";
	private String drugMethod_name = "loadDrugInfo";
	private String inspectionMethod_name = "loadInspectionDetail";
	private String cureInfoMethod_name = "loadCureInfo";
	private String MaterialsInfoMethod_name = "loadMaterialsInfo";
	private String otherMethod_name = "loadOtherInfo";

	private Map infoMap = new HashMap();

	public YiDianChaXun_FeesDetail(Map infoMap) {
			// TODO Auto-generated constructor stub
			this.infoMap = infoMap;
			MysqlUtil.getConn();
		}

	public void getAllFeesDetail() throws Exception {
		this.getDrugFeesDetail();
		this.getInspectionFeesDetail();
		this.getCureFeesDetail();
		this.getMaterialsFeesDetail();
		this.getOtherFeesDetail();
	}

	public void getDrugFeesDetail() throws Exception {
//			药品费用
		List<NameValuePair> nameValuePairList = this.setBasicNameValuePair(drugMethod_name, 0);
		String getDrugTotalPages = this.getPerPages(nameValuePairList);
		this.getFeesDetail_Drug(getDrugTotalPages);
	}

	public void getInspectionFeesDetail() throws Exception {
//			检查费用
		List<NameValuePair> nameValuePairList = this.setBasicNameValuePair(inspectionMethod_name, 0);
		String getInspectionTotalPages = this.getPerPages(nameValuePairList);
		this.getFeesDetail_Inspection(getInspectionTotalPages);
	}

	public void getCureFeesDetail() throws Exception {
//			治疗费用		
		List<NameValuePair> nameValuePairList = this.setBasicNameValuePair(cureInfoMethod_name, 0);
		String getCureTotalPages = this.getPerPages(nameValuePairList);
		this.getFeesDetail_Cure(getCureTotalPages);
	}

	public void getMaterialsFeesDetail() throws Exception {
//			材料费用		
		List<NameValuePair> nameValuePairList = this.setBasicNameValuePair(MaterialsInfoMethod_name, 0);
		String getMaterialsTotalPages = this.getPerPages(nameValuePairList);
		this.getFeesDetail_Materials(getMaterialsTotalPages);
	}

	public void getOtherFeesDetail() throws Exception {
//			其他费用		
		List<NameValuePair> nameValuePairList = this.setBasicNameValuePair(otherMethod_name, 0);
		String getOtherTotalPages = this.getPerPages(nameValuePairList);
		this.getFeesDetail_Other(getOtherTotalPages);
	}

	/**
	 * 获取药品收费
	 * 
	 * @param response
	 * @throws Exception
	 */
	public void getFeesDetail_Drug(String response) throws Exception {

		JsonNode drugpage = new ObjectMapper().readTree(response);
		int drugtotalPages = drugpage.get("page").get("totalPages").asInt();
		saveDrugFees(response);
		if (drugtotalPages > 1) {

			for (int pageNo = 2; pageNo <= drugtotalPages; pageNo++) {
				List<NameValuePair> nameValuePairList = this.setBasicNameValuePair(drugMethod_name, pageNo);
				saveDrugFees(getPerPages(nameValuePairList));
			}
		}

	}

	/**
	 * 保存药品数据
	 * 
	 * @param response
	 * @throws IOException
	 * @throws SQLException
	 */
	public void saveDrugFees(String response) throws IOException {
		String type_feeds = "药品";
		JsonNode drugrows = new ObjectMapper().readTree(response).get("rows");

		if (drugrows.isArray()) {
			String sql = "INSERT INTO yidianchaxun_feeds_yp (sicode,pid,name_hos,name_yb,name_bz,ybcode,bzjx,num,price,type_bx,type_feeds,type_wg,discharge_date) VALUES ";
			String setchar = "(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			String s = "";
			List value_arr = new ArrayList<>();
			for (JsonNode drugrow : drugrows) {
				JsonNode drugdata = drugrow.get("data");
				String name_hos = drugdata.get(2).asText();
				String name_yb = drugdata.get(4).asText();
				String name_bz = drugdata.get(16).asText();
				String ybcode = drugdata.get(5).asText();
				String bzjx = drugdata.get(17).asText();
				String num = drugdata.get(12).asText();
				String price = drugdata.get(11).asText();
				String type_bx = drugdata.get(13).asText();
				String type_wg = drugdata.get(14).asText();

				s=s.concat(setchar).concat(",");
				Object[] value = { infoMap.get("si_code"), infoMap.get("miid"), name_hos, name_yb, name_bz,ybcode,bzjx,num, price,
						type_bx, type_feeds, type_wg, infoMap.get("discharge_date") };
				value_arr.add(value);

			}
			String newSql = sql.concat(s);
			MysqlUtil.executesql(newSql.substring(0, newSql.length() - 1), value_arr);
		}

	}

	/**
	 * 检查
	 * 
	 * @param response
	 * @throws Exception
	 */
	public void getFeesDetail_Inspection(String response) throws Exception {

		JsonNode drugpage = new ObjectMapper().readTree(response);
		int drugtotalPages = drugpage.get("page").get("totalPages").asInt();
		saveInspectionFees(response);
		if (drugtotalPages > 1) {

			for (int pageNo = 2; pageNo <= drugtotalPages; pageNo++) {
				List<NameValuePair> nameValuePairList = this.setBasicNameValuePair(inspectionMethod_name, pageNo);
				saveInspectionFees(getPerPages(nameValuePairList));
			}
		}

	}

	public void saveInspectionFees(String response) throws IOException, SQLException {
		String type_feeds = "检查";
		JsonNode drugrows = new ObjectMapper().readTree(response).get("rows");
		if (drugrows.isArray()) {
			String sql = "INSERT INTO yidianchaxun_feeds_inspection (sicode,pid, name_hos, name_yb,name_bz,num, price, type_bx, type_feeds,type_wg,discharge_date) VALUES ";
			String setchar = "(?,?,?,?,?,?,?,?,?,?,?)";
			String s = "";
			List value_arr = new ArrayList<>();
			for (JsonNode drugrow : drugrows) {
				JsonNode drugdata = drugrow.get("data");
				String name_hos = drugdata.get(2).asText();
				String name_yb = drugdata.get(4).asText();
				String num = drugdata.get(7).asText();
				String price = drugdata.get(6).asText();
				String type_bx = drugdata.get(8).asText();

				String name_bz = drugdata.get(11).asText();
				String type_wg = drugdata.get(9).asText();

				s=s.concat(setchar).concat(",");
				Object[] value = { infoMap.get("si_code"), infoMap.get("miid"), name_hos, name_yb, name_bz, num, price,
						type_bx, type_feeds, type_wg, infoMap.get("discharge_date") };
				value_arr.add(value);
			}
			String newSql = sql.concat(s);
			MysqlUtil.executesql(newSql.substring(0, newSql.length() - 1), value_arr);
		}

	}

	public void getFeesDetail_Cure(String response) throws Exception {

		JsonNode drugpage = new ObjectMapper().readTree(response);
		int drugtotalPages = drugpage.get("page").get("totalPages").asInt();
		saveCureFees(response);
		if (drugtotalPages > 1) {

			for (int pageNo = 2; pageNo <= drugtotalPages; pageNo++) {
				List<NameValuePair> nameValuePairList = this.setBasicNameValuePair(cureInfoMethod_name, pageNo);
				saveCureFees(getPerPages(nameValuePairList));
			}
		}

	}

	public void saveCureFees(String response) throws IOException, SQLException {
		String type_feeds = "治疗";
		JsonNode drugrows = new ObjectMapper().readTree(response).get("rows");
		if (drugrows.isArray()) {
			String sql = "INSERT INTO yidianchaxun_feeds_cure (sicode,pid, name_hos, name_yb,name_bz,num, price, type_bx, type_feeds,type_wg,discharge_date) VALUES ";
			String setchar = "(?,?,?,?,?,?,?,?,?,?,?)";
			String s = "";
			List value_arr = new ArrayList<>();
			for (JsonNode drugrow : drugrows) {
				JsonNode drugdata = drugrow.get("data");
				String name_hos = drugdata.get(2).asText();
				String name_yb = drugdata.get(4).asText();
				String num = drugdata.get(7).asText();
				String price = drugdata.get(6).asText();
				String type_bx = drugdata.get(8).asText();

				String name_bz = drugdata.get(11).asText();
				String type_wg = drugdata.get(9).asText();

				s = s.concat(setchar).concat(",");
				Object[] value = { infoMap.get("si_code"), infoMap.get("miid"), name_hos, name_yb, name_bz, num, price,
						type_bx, type_feeds, type_wg, infoMap.get("discharge_date") };
				value_arr.add(value);
			}
			String newSql = sql.concat(s);
			MysqlUtil.executesql(newSql.substring(0, newSql.length() - 1), value_arr);
		}

	}

	public void getFeesDetail_Materials(String response) throws Exception {

		JsonNode drugpage = new ObjectMapper().readTree(response);
		int drugtotalPages = drugpage.get("page").get("totalPages").asInt();
		saveMaterialsFees(response);
		if (drugtotalPages > 1) {

			for (int pageNo = 2; pageNo <= drugtotalPages; pageNo++) {
				List<NameValuePair> nameValuePairList = this.setBasicNameValuePair(MaterialsInfoMethod_name, pageNo);
				saveMaterialsFees(getPerPages(nameValuePairList));
			}
		}

	}

	public void saveMaterialsFees(String response) throws IOException, SQLException {
		String type_feeds = "材料";
		JsonNode drugrows = new ObjectMapper().readTree(response).get("rows");
		if (drugrows.isArray()) {
			String sql = "INSERT INTO yidianchaxun_feeds_materials (sicode,pid, name_hos, name_yb,name_bz,num, price, type_bx, type_feeds,type_wg,discharge_date) VALUES ";
			String setchar = "(?,?,?,?,?,?,?,?,?,?,?)";
			String s = "";
			List value_arr = new ArrayList<>();
			for (JsonNode drugrow : drugrows) {
				JsonNode drugdata = drugrow.get("data");
				String name_hos = drugdata.get(2).asText();
				String name_yb = drugdata.get(4).asText();
				String num = drugdata.get(7).asText();
				String price = drugdata.get(6).asText();
				String type_bx = drugdata.get(8).asText();

				String name_bz = drugdata.get(10).asText();
				String type_wg = drugdata.get(9).asText();

				s = s.concat(setchar).concat(",");
				Object[] value = { infoMap.get("si_code"), infoMap.get("miid"), name_hos, name_yb, name_bz, num, price,
						type_bx, type_feeds, type_wg, infoMap.get("discharge_date") };
				value_arr.add(value);
			}
			String newSql = sql.concat(s);
			MysqlUtil.executesql(newSql.substring(0, newSql.length() - 1), value_arr);
		}

	}

	// 其它
	public void getFeesDetail_Other(String response) throws Exception {

		JsonNode drugpage = new ObjectMapper().readTree(response);
		int drugtotalPages = drugpage.get("page").get("totalPages").asInt();
		saveMaterialsFees(response);
		if (drugtotalPages > 1) {

			for (int pageNo = 2; pageNo <= drugtotalPages; pageNo++) {
				List<NameValuePair> nameValuePairList = this.setBasicNameValuePair(otherMethod_name, pageNo);
//	    		saveMaterialsFees(getPerPages(nameValuePairList));
			}
		} else {
			if (drugtotalPages == 1)
				System.out.println(infoMap.get("si_code"));
		}

	}

	/**
	 * 设置请求头
	 * 
	 * @param method_name
	 * @param pageNo
	 * @return
	 */
	private List setBasicNameValuePair(String method_name, int pageNo) {
		List<NameValuePair> nameValuePairList = Lists.newArrayList();
		nameValuePairList.add(new BasicNameValuePair("method", method_name));
		nameValuePairList.add(new BasicNameValuePair("pageRecords", "200"));
		nameValuePairList.add(new BasicNameValuePair("a_dhx_rSeed", "1600822603715"));
		nameValuePairList.add(new BasicNameValuePair("pid", infoMap.get("miid").toString()));
		nameValuePairList.add(new BasicNameValuePair("ssmLevel", ""));

		if (pageNo != 0) {
			nameValuePairList.add(new BasicNameValuePair("currentPage", String.valueOf(pageNo)));
			nameValuePairList.add(new BasicNameValuePair("orderInfo", "-1,asc"));
			nameValuePairList.add(new BasicNameValuePair("title", ""));

			if (method_name == drugMethod_name) {
				nameValuePairList.add(new BasicNameValuePair("gridbox", "app.common.diagnosis.recipeInfo.gridA"));
			}
			if (method_name == inspectionMethod_name) {
				nameValuePairList.add(new BasicNameValuePair("gridbox", "app.common.diagnosis.recipeInfo.gridB"));

			}
			if (method_name == cureInfoMethod_name) {
				nameValuePairList.add(new BasicNameValuePair("gridbox", "app.common.diagnosis.recipeInfo.gridC"));
			}
			if (method_name == MaterialsInfoMethod_name) {
				nameValuePairList.add(new BasicNameValuePair("gridbox", "app.common.diagnosis.recipeInfo.gridD"));
			}
			if (method_name == otherMethod_name) {
				nameValuePairList.add(new BasicNameValuePair("gridbox", "app.common.diagnosis.recipeInfo.gridE"));
			}
		}

		return nameValuePairList;
	}

	public String getPerPages(List<NameValuePair> nameValuePairList)
			throws ClassNotFoundException, URISyntaxException, IOException {
		String response = DoRequest.dopost(Constant.url + getDetail_url, nameValuePairList,
				MyCookieStore.readCookieStore("cookie"));
//		System.out.println(response);
		return response;
	}

	public static void main(String[] args) throws Exception {
		Login login = new Login();
		login.openLoginPage();
		if (login.loginURL()) {
			Map infoMap = new HashMap();
			infoMap.put("si_code", "1298262");
			infoMap.put("miid", "1298262");
			infoMap.put("discharge_date", "2020-05-05");
			YiDianChaXun_FeesDetail yf = new YiDianChaXun_FeesDetail(infoMap);
			yf.getAllFeesDetail();
		} else {
			System.out.println("登录失败!退出请求!");
		}
	}

}
