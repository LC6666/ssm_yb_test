package com.iebm.ssm.request;

import java.io.IOException;
import java.util.Map;


import com.iebm.ssm.util.HttpRequest;

/*
 *TODO
 *LC
 *下午5:04:44
*/

public class CaseQuery {

	public static void querycase(String url, Map params, String cookies) {
		// TODO Auto-generated method stub
		String param = "";
		// 查询所有疑点病例
		if (params == null) {
			param = "institutionName=&institutionId=&institutionLevelKey=&diseaseName=&diseaseId=&startCreateTime=2012-12-31&endCreateTime=2020-03-26&siCode=&insuredName=&undefined=&pageRecords=200";

			// 按条件查询疑点病例
		} else {
			param = "institutionName=" + params.get("institutionName") + "&institutionId=" + params.get("institutionId")
					+ "&institutionLevelKey=" + params.get("institutionLevelKey") + "&diseaseName="
					+ params.get("diseaseName") + "&diseaseId=" + params.get("diseaseId") + "&startCreateTime="
					+ params.get("startCreateTime") + "&endCreateTime=" + params.get("endCreateTime") + "&siCode="
					+ params.get("siCode") + "&insuredName=" + params.get("insuredName") + "&undefined="
					+ params.get("undefined") + "&pageRecords=" + params.get("pageRecords");
		}
		
		String path ="/app/illegalMedical/illegalMedicalAllotAction.action?method=queryAllRecord";
		String response = HttpRequest.sendPost( url+path, cookies, param);
		String totalPage = "0";
		/*try {
			totalPage =  new ObjectMapper().readTree(response).get("page").get("totalPages").toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println(totalPage);
		
		
	}

}



