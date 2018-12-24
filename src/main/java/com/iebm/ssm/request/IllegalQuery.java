package com.iebm.ssm.request;

import java.util.Map;

import com.iebm.ssm.util.HttpRequest;

/*
 *TODO
 *疑点查询接口功能分析数据
 *
 *LC
 *下午3:59:12
*/

public class IllegalQuery {

	public static void queryIllegal(String url,Map params, String cookies) {
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
		System.out.println(param);
		String path ="/app/illegalMedical/illegalMedicalAllotAction.action?method=queryAllRecord";
		String response = HttpRequest.sendPost( url+path, cookies, param);
		System.out.println(response);
	}

}
