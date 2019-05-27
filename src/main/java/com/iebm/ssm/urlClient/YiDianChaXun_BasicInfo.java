package com.iebm.ssm.urlClient;

import com.google.common.collect.Lists;
import com.iebm.ssm.util.Constant;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class YiDianChaXun_BasicInfo {

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

        String id = infoMap.get("id").toString();
        String code = infoMap.get("code").toString();

        String totalFee_str = "";
        String drugFee_str = "";
        String inspectionFee_str = ""	;
        String treatmentFee_str = "";
        String otherFee_str = "";
        String ownExpense_str ="";
        String initialIllegalFee_str = "";
        BigDecimal drugFee = BigDecimal.ZERO ;
        BigDecimal inspectionFee = BigDecimal.ZERO;
        BigDecimal treatmentFee = BigDecimal.ZERO;
        BigDecimal otherFee = BigDecimal.ZERO ;
        BigDecimal totalFee1 = BigDecimal.ZERO ;


        String url2 = Constant.url+"/app/common/cureInfoJoint.jsp";
        List<NameValuePair> pageParam2ValuePairList = Lists.newArrayList();
        pageParam2ValuePairList.add(new BasicNameValuePair("miid",id));
        pageParam2ValuePairList.add(new BasicNameValuePair("zclcsofttimestamp","1545303922287"));

        String s = DoRequest.dopost(url2, pageParam2ValuePairList, MyCookieStore.readCookieStore("cookie"));
        Document doc = Jsoup.parseBodyFragment(s);
        totalFee_str = doc.getElementById("app.common.diagnosis.basicInfo.form0.totalFee").attr("value").replace(",", "");
        drugFee_str = doc.getElementById("app.common.diagnosis.basicInfo.form0.drugFee").attr("value").replace(",", "");
        inspectionFee_str = doc.getElementById("app.common.diagnosis.basicInfo.form0.inspectionFee")
                .attr("value").replace(",", "");
        treatmentFee_str = doc.getElementById("app.common.diagnosis.basicInfo.form0.treatmentFee")
                .attr("value").replace(",", "");
        otherFee_str = doc.getElementById("app.common.diagnosis.basicInfo.form0.otherFee").attr("value").replace(",", "");
        ownExpense_str = doc.getElementById("app.common.diagnosis.basicInfo.form0.ownExpense").attr("value").replace(",", "");
        initialIllegalFee_str = doc.getElementById("app.common.diagnosis.basicInfo.form0.initialIllegalFee").attr("value").replace(",", "");


        drugFee = drugFee_str.equals("") ? drugFee : new BigDecimal(drugFee_str);
        inspectionFee = inspectionFee_str.equals("") ? inspectionFee: new BigDecimal(inspectionFee_str);
        treatmentFee = treatmentFee_str.equals("") ? treatmentFee: new BigDecimal(treatmentFee_str);
        otherFee = otherFee_str.equals("") ? otherFee: new BigDecimal(otherFee_str);
        totalFee1 = totalFee_str.equals("") ? totalFee1 : new BigDecimal(totalFee_str);

        BigDecimal totalFee2 = inspectionFee.add(treatmentFee).add(otherFee).add(drugFee);
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        String str = df.format(totalFee2);
        if (totalFee1.compareTo(new BigDecimal(str)) != 0) {
            System.out.println("就诊编号【" + code + "】基本信息总费用计算不正确   基本信息显示总费用="+totalFee1+" 页面计算总费用="+totalFee2 );
        }

//      总费用
        infoMap.put("totalFee_str", totalFee_str);
//      药品费用
        infoMap.put("drugFee_str", drugFee_str);
//      检查费用
        infoMap.put("inspectionFee_str", inspectionFee_str);
//      治疗费用
        infoMap.put("treatmentFee_str", treatmentFee_str);
//      其他费用
        infoMap.put("otherFee_str", otherFee_str);
//      违规费用
        infoMap.put("ownExpense_str", ownExpense_str);
//      最终违规金额
        infoMap.put("initialIllegalFee_str", initialIllegalFee_str);

        return infoMap;

    }

}
