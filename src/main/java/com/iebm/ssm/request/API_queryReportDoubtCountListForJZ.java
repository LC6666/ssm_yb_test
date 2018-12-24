package com.iebm.ssm.request;

import java.io.UnsupportedEncodingException;

import com.iebm.ssm.util.HttpRequest;

/*
 *TODO
 *LC
 *下午1:36:02
*/

public class API_queryReportDoubtCountListForJZ {

	/**
	 * @param url
	 * @param cookie
	 * @throws UnsupportedEncodingException
	 * TODO
	 *   总体统计按月份统计数量疑点病例数
	 * 	  医疗就诊病例
	 * 
	 * LC
	 * 上午10:54:53
	 */
	public static void test(String url, String cookie) throws UnsupportedEncodingException {
		// System.out.println(url);
		// 发送 POST 请求
		String[] month = { "201801", "201802", "201803", "201804", "201805", "201806", "201807", "201808", "201809",
				"201810", "201811", "201812" };
		// String param = "isTotal=total&fromYM=201801&xInfo=Mon&toYM=201801&type=count&pageRecords=200";
		String param = "currentPage=1&pageRecords=200&orderInfo=-1%2Casc&gridbox=app.rpt.violationcount.query.grid&title=&isTotal=total&fromYM=201802&xInfo=Mon&toYM=201802&type=count";

		String path = "/app/illegalMedical/illegalMedicalAllotAction.action?method=queryReportDoubtCountListForJZ";

		String response = HttpRequest.sendPost(url + path, cookie, param);

		System.out.println(response);

	}

}
