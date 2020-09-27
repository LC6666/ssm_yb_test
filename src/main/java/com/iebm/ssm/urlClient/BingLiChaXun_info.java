package com.iebm.ssm.urlClient;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.collections.Lists;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iebm.ssm.util.Constant;
import com.iebm.ssm.util.JsonUtil;
import com.iebm.ssm.util.MyCookieStore;

/**
 * 病例信息查看
 * @author Administrator
 *
 */
public class BingLiChaXun_info {

	/**
	 * 基本信息
	 * @param infoMap
	 * @return
	 * @throws ClassNotFoundException
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	public Map cureInfoJointforHis(Map infoMap) throws ClassNotFoundException, URISyntaxException, IOException {
		String miid = infoMap.get("miid").toString();
		// 病例信息查看
		String url = Constant.url + "/app/common/cureInfoJointforHis.jsp";
		List<NameValuePair> nameValuePairList = Lists.newArrayList();
		nameValuePairList.add(new BasicNameValuePair("miid", miid));
		nameValuePairList.add(new BasicNameValuePair("zclcsofttimestamp", "1600670163150"));

		String response = DoRequest.doget(url, nameValuePairList, MyCookieStore.readCookieStore("cookie"));
//		System.out.println(response);
		Document doc = Jsoup.parseBodyFragment(response);
//		总住院费用
		String totalFee_str = "";
//		药品费用
		String drugFee_str = "";
//		检查费用
		String inspectionFee_str = "";
//		治疗费用
		String treatmentFee_str = "";
//		其他费用
		String otherFee_str = "";
//		违规费用
		String ownExpense_str = "";
//		最终违规金额(元)
		String initialIllegalFee_str = "";
//		医院等级
		String levelText =  doc.getElementById("app.common.diagnosis.detailedInfo.form2.levelText").attr("value");
		
		totalFee_str = doc.getElementById("app.common.diagnosis.basicInfo.form0.totalFee").attr("value").replace(",",
				"");
		drugFee_str = doc.getElementById("app.common.diagnosis.basicInfo.form0.drugFee").attr("value").replace(",", "");
		inspectionFee_str = doc.getElementById("app.common.diagnosis.basicInfo.form0.inspectionFee").attr("value")
				.replace(",", "");
		treatmentFee_str = doc.getElementById("app.common.diagnosis.basicInfo.form0.treatmentFee").attr("value")
				.replace(",", "");

		otherFee_str = doc.getElementById("app.common.diagnosis.basicInfo.form0.otherFee").attr("value").replace(",",
				"");
		ownExpense_str = doc.getElementById("app.common.diagnosis.basicInfo.form0.ownExpense").attr("value")
				.replace(",", "");
		initialIllegalFee_str = doc.getElementById("app.common.diagnosis.basicInfo.form0.initialIllegalFee")
				.attr("value").replace(",", "");
		
//		页面显示费用校验（需要校验时去掉注释即可）
//		===============================================================================================
//		BigDecimal drugFee = BigDecimal.ZERO;
//		BigDecimal inspectionFee = BigDecimal.ZERO;
//		BigDecimal treatmentFee = BigDecimal.ZERO;
//		BigDecimal otherFee = BigDecimal.ZERO;
//		BigDecimal totalFee1 = BigDecimal.ZERO;
//		
//		drugFee = drugFee_str.equals("") ? drugFee : new BigDecimal(drugFee_str);
//		inspectionFee = inspectionFee_str.equals("") ? inspectionFee : new BigDecimal(inspectionFee_str);
//		treatmentFee = treatmentFee_str.equals("") ? treatmentFee : new BigDecimal(treatmentFee_str);
//		otherFee = otherFee_str.equals("") ? otherFee : new BigDecimal(otherFee_str);
//		totalFee1 = totalFee_str.equals("") ? totalFee1 : new BigDecimal(totalFee_str);
//
//		BigDecimal totalFee2 = inspectionFee.add(treatmentFee).add(otherFee).add(drugFee);
//		DecimalFormat df = new DecimalFormat("0.00");
//		df.setRoundingMode(RoundingMode.HALF_UP);
//		String str = df.format(totalFee2);
//		if (totalFee1.compareTo(new BigDecimal(str)) != 0) {
//			System.out.println("就诊编号【" + miid + "】基本信息总费用计算不正确   基本信息显示总费用=" + totalFee1 + " 页面计算总费用=" + totalFee2);
//		}
		
//		=====================================================================================================================================

				
//		System.out.println("总住院费用="+totalFee_str+	
//				"药品费用="+drugFee_str+	
//				"检查费用="+inspectionFee_str+
//				"治疗费用="+treatmentFee_str+ 
//				"其他费用="+otherFee_str+
//				"违规费用="+ownExpense_str+
//				"最终违规金额(元)"+initialIllegalFee_str);



//	      总费用
		infoMap.put("totalFee_str", totalFee_str);
//	      药品费用
		infoMap.put("drugFee_str", drugFee_str);
//	      检查费用
		infoMap.put("inspectionFee_str", inspectionFee_str);
//	      治疗费用
		infoMap.put("treatmentFee_str", treatmentFee_str);
//	      其他费用
		infoMap.put("otherFee_str", otherFee_str);
//	      违规费用
		infoMap.put("ownExpense_str", ownExpense_str);
//	      最终违规金额
		infoMap.put("initialIllegalFee_str", initialIllegalFee_str);
		
		infoMap.put("levelText", levelText);
		
		return infoMap;

	}
	
	public static void main(String[] args) throws URISyntaxException, IOException, ClassNotFoundException {
		Login login = new Login();
        login.openLoginPage();
        if(login.loginURL()){
        	BingLiChaXun_info bc = new BingLiChaXun_info();
        	Map infoMap = new HashMap();
        	infoMap.put("miid", "1297248");
            bc.cureInfoJointforHis(infoMap);
        }else {
            System.out.println("登录失败!退出请求!");
        }
    }

}
