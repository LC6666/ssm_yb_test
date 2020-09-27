package com.iebm.ssm.urlClient;

import org.testng.collections.Lists;
import com.iebm.ssm.util.Constant;
import com.iebm.ssm.util.MyCookieStore;
import com.iebm.ssm.util.MysqlUtil;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YiDianChaXun_BasicInfo {
	
	private String cureInfoJoint_url = "/app/common/cureInfoJoint.jsp";
	private String miid="";
	
	
	
	
	
	private List<NameValuePair> setDefaultValuePair(String miid) {
		this.miid=miid;
		List<NameValuePair> nameValuePairList = Lists.newArrayList();
		nameValuePairList.add(new BasicNameValuePair("zclcsofttimestamp","1601050291392"));
		nameValuePairList.add(new BasicNameValuePair("miid",miid));
		return nameValuePairList;
	}
	
	public String getBasiInfo(String miid) throws ClassNotFoundException, URISyntaxException, IOException {
		String s = DoRequest.dopost(Constant.url+cureInfoJoint_url, this.setDefaultValuePair(miid), MyCookieStore.readCookieStore("cookie"));
		return s;
	}
	
	public YiDianChaXun_BasicInfo() {
		// TODO Auto-generated constructor stub
		MysqlUtil.getConn();
	}
	
	public Map saveBasiInfo(String response) {
		Map bascinfo = new HashMap<>();
		Document doc = Jsoup.parseBodyFragment(response);
		String si_code = doc.getElementById("app.common.diagnosis.basicInfo.form0.code").attr("value");
//		bascinfo.put("si_code", si_code);
		String insuredName = doc.getElementById("app.common.diagnosis.basicInfo.form0.insuredName").attr("value");
//		bascinfo.put("insuredName", insuredName);
		String diseaseName = doc.getElementById("app.common.diagnosis.basicInfo.form0.diseaseName").attr("value");
//		bascinfo.put("diseaseName", diseaseName);
		String admissionDate = doc.getElementById("app.common.diagnosis.basicInfo.form0.admissionDate").attr("value");
//		bascinfo.put("admissionDate", admissionDate);
		String totalFee = doc.getElementById("app.common.diagnosis.basicInfo.form0.totalFee").attr("value");
//		bascinfo.put("totalFee", totalFee);
		String settlementDate = doc.getElementById("app.common.diagnosis.basicInfo.form0.settlementDate").attr("value");
//		bascinfo.put("settlementDate", settlementDate);
		String drugFee=doc.getElementById("app.common.diagnosis.basicInfo.form0.drugFee").attr("value");
//		bascinfo.put("drugFee", drugFee);
		String hospitalDays = doc.getElementById("app.common.diagnosis.basicInfo.form0.hospitalDays").attr("value");
//		bascinfo.put("hospitalDays", hospitalDays);
		String inspectionFee = doc.getElementById("app.common.diagnosis.basicInfo.form0.inspectionFee").attr("value");
//		bascinfo.put("inspectionFee", inspectionFee);
		String dischargeDate = doc.getElementById("app.common.diagnosis.basicInfo.form0.dischargeDate").attr("value");
//		bascinfo.put("dischargeDate", dischargeDate);
		String treatmentFee = doc.getElementById("app.common.diagnosis.basicInfo.form0.treatmentFee").attr("value");
//		bascinfo.put("treatmentFee", treatmentFee);
		String ownExpense = doc.getElementById("app.common.diagnosis.basicInfo.form0.ownExpense").attr("value");
//		bascinfo.put("ownExpense", ownExpense);
		String otherFee = doc.getElementById("app.common.diagnosis.basicInfo.form0.otherFee").attr("value");
//		bascinfo.put("otherFee", otherFee);
		String initialIllegalFee = doc.getElementById("app.common.diagnosis.basicInfo.form0.initialIllegalFee").attr("value");
//		bascinfo.put("initialIllegalFee", initialIllegalFee);
		String stdphgrade = doc.getElementById("app.common.diagnosis.basicInfo.form0.STDPHGRADE").attr("value");
//		bascinfo.put("stdphgrade", stdphgrade);
//		System.out.println(si_code+insuredName+diseaseName+admissionDate+totalFee+settlementDate
//				+drugFee+hospitalDays+inspectionFee+dischargeDate+treatmentFee+ownExpense+otherFee+initialIllegalFee+stdphgrade);
//      保存病例信息到数据库
		String sql = "insert into yidianchaxun_bascinfo (si_code, miid, insuredName, diseaseName, admissionDate, totalFee, settlementDate, drugFee, hospitalDays, "
				+ "inspectionFee, dischargeDate, treatmentFee, ownExpense, otherFee, initialIllegalFee, stdphgrade) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//      System.out.println(sql);
      Object[] value = {si_code, miid, insuredName, diseaseName, admissionDate, totalFee, settlementDate, drugFee, hospitalDays, inspectionFee, dischargeDate, treatmentFee, ownExpense, otherFee, initialIllegalFee, stdphgrade};
      MysqlUtil.executesql(sql,value);
      
      return bascinfo;
	}
	
	
	
	public static void main(String[] args) throws ClassNotFoundException, URISyntaxException, IOException {
		Login login = new Login();
        login.openLoginPage();
        if(login.loginURL()){
        	YiDianChaXun_BasicInfo b = new YiDianChaXun_BasicInfo();
    		String s = b.getBasiInfo("1280420");
    		b.saveBasiInfo(s);
//    		b.getBasicInfo(b.saveBasiInfo(s));
        }else {
            System.out.println("登录失败!退出请求!");
        }
    }

    /**
     * 查询病例基本信息
     * @param infoMap
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws URISyntaxException
     */
    public Map getBasicInfo(Map infoMap) throws IOException, ClassNotFoundException, URISyntaxException {

        //获取疑点病例详情------基本信息

//        String id = infoMap.get("id").toString();
        String code = infoMap.get("si_code").toString();
        
        BigDecimal drugFee = BigDecimal.ZERO ;
        BigDecimal inspectionFee = BigDecimal.ZERO;
        BigDecimal treatmentFee = BigDecimal.ZERO;
        BigDecimal otherFee = BigDecimal.ZERO ;
        BigDecimal totalFee1 = BigDecimal.ZERO ;
        
       
        drugFee = infoMap.get("drugFee").equals("") ? drugFee : new BigDecimal(0);
        inspectionFee = infoMap.get("inspectionFee").equals("") ? inspectionFee: new BigDecimal(0);
        treatmentFee = infoMap.get("treatmentFee").equals("") ? treatmentFee: new BigDecimal(0);
        otherFee = infoMap.get("otherFee").equals("") ? otherFee: new BigDecimal(0);
        totalFee1 = infoMap.get("totalFee").equals("") ? totalFee1 : new BigDecimal(0);

        BigDecimal totalFee2 = inspectionFee.add(treatmentFee).add(otherFee).add(drugFee);
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        String str = df.format(totalFee2);
        if (totalFee1.compareTo(new BigDecimal(str)) != 0) {
            System.out.println("就诊编号【" + code + "】基本信息总费用计算不正确   基本信息显示总费用="+totalFee1+" 页面计算总费用="+totalFee2 );
        }

        return infoMap;

    }

}
