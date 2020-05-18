package com.iebm.ssm.urlClient;

import org.testng.collections.Lists;
import com.iebm.ssm.util.Constant;
import com.iebm.ssm.util.MyCookieStore;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.math.RoundingMode;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class YiDianChaXun_DrugReport {

    DecimalFormat df = new DecimalFormat("0.00");

    /**
     * @// TODO: 2018/12/29  药品报销类别费用统计
     * @param infoMap
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws URISyntaxException
     */
    public Map loadReportInfo(Map infoMap) throws IOException, ClassNotFoundException, URISyntaxException {
        String id= infoMap.get("id").toString();
        String url= Constant.url + "/app/diagnoseRelevant/view/diagnoseRelevantAction.action";
        List<NameValuePair> nameValuePairList = Lists.newArrayList();
        nameValuePairList.add(new BasicNameValuePair("method","loadReportInfo"));
        nameValuePairList.add(new BasicNameValuePair("yInfo","1"));
        nameValuePairList.add(new BasicNameValuePair("miid",id));
        String response = DoRequest.doget(url, nameValuePairList,MyCookieStore.readCookieStore("cookie"));
        Document doc = Jsoup.parseBodyFragment(response);
        Elements elements= doc.getElementsByTag("set");
        df.setRoundingMode(RoundingMode.HALF_UP);
        for (Element element : elements) {
            String label = element.attr("label");
            String value = element.attr("value");
            if(label.contains("甲")){
                String drug_firstType_totalprice = df.format(infoMap.get("drug_firstType_totalprice"));

                if (!value.equals(drug_firstType_totalprice)){
                    System.out.println("病例【"+infoMap.get("code").toString()+"】药品报销类别费用统计 甲类费用统计不一致    明细中甲类费用="+drug_firstType_totalprice+"   视图中甲类费用="+value);
                }
//                infoMap.put("firstDrug_chart", value);
            }if(label.contains("乙")){
                String drug_secondType_totalprice = df.format(infoMap.get("drug_secondType_totalprice"));
                if (!value.equals(drug_secondType_totalprice)){
                    System.out.println("病例【"+infoMap.get("code").toString()+"】药品报销类别费用统计 乙类费用统计不一致    明细中乙类费用="+drug_secondType_totalprice+"   视图中乙类费用="+value);
                }
//                infoMap.put("secondDrug_chart", value);
            }else if(label.contains("目录外费用")){
                String drug_otherType_totalprice = df.format(infoMap.get("drug_otherType_totalprice"));
                if (!value.equals(drug_otherType_totalprice)){
                    System.out.println("病例【"+infoMap.get("code").toString()+"】药品报销类别费用统计 其他类费用统计不一致    明细中目录外费用="+drug_otherType_totalprice+"   视图中目录外费用="+value);
                }
//                infoMap.put("orhterDrug_chart", value);
            }

        }



        return infoMap;
    }


    /**
     * @// TODO: 2018/12/29  药占比统计
     * @param infoMap
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws URISyntaxException
     */
    public Map loadReportDrugRate(Map infoMap) throws IOException, ClassNotFoundException, URISyntaxException {
        String id= infoMap.get("id").toString();
        String url=Constant.url + "/app/diagnoseRelevant/view/diagnoseRelevantAction";
        List<NameValuePair> nameValuePairList = Lists.newArrayList();
        nameValuePairList.add(new BasicNameValuePair("method","loadReportDrugRate"));
        nameValuePairList.add(new BasicNameValuePair("yInfo","1"));
        nameValuePairList.add(new BasicNameValuePair("miid",id));
        String response = DoRequest.doget(url, nameValuePairList,MyCookieStore.readCookieStore("cookie"));
        Document doc = Jsoup.parseBodyFragment(response);
        Elements elements= doc.getElementsByTag("set");
        for (Element element : elements) {
            String label = element.attr("label");
            String value = element.attr("value");
            if(label.contains("药品")){
                String drugFee_str = infoMap.get("drugFee_str").toString();
                if(!drugFee_str.equals(value)){
                    System.out.println("病例【"+infoMap.get("code").toString()+"】药占比统计不正确    基本信息中药品费用="+drugFee_str+"   视图中药品费用="+value);
                }
//                infoMap.put("drugFees_chart", value);
            }if(label.contains("其它")){
//                infoMap.put("otherFees_chart", value);
            }

        }



        return infoMap;
    }
}
