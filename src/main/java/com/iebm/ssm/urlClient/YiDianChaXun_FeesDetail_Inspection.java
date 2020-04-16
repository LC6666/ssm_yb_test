package com.iebm.ssm.urlClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.collections.Lists;
import com.iebm.ssm.util.Constant;
import com.iebm.ssm.util.MyCookieStore;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.List;

public class YiDianChaXun_FeesDetail_Inspection {

    /**
     * 查询病例收费明细---检查明细
     * @param infoMap
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws URISyntaxException
     */
    public Map getInspection(Map infoMap) throws IOException, ClassNotFoundException, URISyntaxException {

        String id = infoMap.get("id").toString();
        String code = infoMap.get("code").toString();
        String inspectionFee_str = infoMap.get("inspectionFee_str").toString();

//     	获取疑点病例详情------收费明细（检查明细）

        String InspectionUrl = Constant.url + "/app/diagnoseRelevant/view/diagnoseRelevantAction.action?method=loadInspectionDetail&a_dhx_rSeed=1545356330008";

        List<NameValuePair> InspectionParamValuePairList = Lists.newArrayList();
        InspectionParamValuePairList.add(new BasicNameValuePair("pid",String.valueOf(id)));
        InspectionParamValuePairList.add(new BasicNameValuePair("ssmLevel",""));
        InspectionParamValuePairList.add(new BasicNameValuePair("pageRecords","200"));
        String Inspectionresponse =DoRequest.dopost(InspectionUrl,InspectionParamValuePairList,MyCookieStore.readCookieStore("cookie"));


//					获取分页信息
        JsonNode Inspectionpage = new ObjectMapper().readTree(Inspectionresponse);
        int InspectiontotalPages = Inspectionpage.get("page").get("totalPages").asInt();
        String Inspection_price_str="";
        String Inspection_num_str="";
        String Inspection_type = "";
        BigDecimal Inspection_alltotalprice = BigDecimal.ZERO;
        BigDecimal Inspection_illegal_totalprice = BigDecimal.ZERO;
        BigDecimal Inspection_price = BigDecimal.ZERO;
        BigDecimal Inspection_num = BigDecimal.ZERO;
        if (InspectiontotalPages>1) {
            for(int InspectionPageNum=1;InspectionPageNum<=InspectiontotalPages;InspectionPageNum++){

                List<NameValuePair> InspectionPageParamValuePairList = Lists.newArrayList();
                InspectionPageParamValuePairList.add(new BasicNameValuePair("currentPage",String.valueOf(InspectionPageNum)));
                InspectionPageParamValuePairList.add(new BasicNameValuePair("pageRecords","200"));
                InspectionPageParamValuePairList.add(new BasicNameValuePair("orderInfo","-1,asc"));
                InspectionPageParamValuePairList.add(new BasicNameValuePair("gridbox","app.common.diagnosis.recipeInfo.gridA"));
                InspectionPageParamValuePairList.add(new BasicNameValuePair("title",""));
                InspectionPageParamValuePairList.add(new BasicNameValuePair("pid",id));
                InspectionPageParamValuePairList.add(new BasicNameValuePair("ssmLevel",""));
                String InspectionPageResponse =DoRequest.dopost(InspectionUrl,InspectionPageParamValuePairList,MyCookieStore.readCookieStore("cookie"));
                JsonNode InspectionPagerows = new ObjectMapper().readTree(InspectionPageResponse).get("rows");
                if(InspectionPagerows.isArray()){
                    for (JsonNode Inspectionrow : InspectionPagerows) {
                        JsonNode Inspectiondata = Inspectionrow.get("data");
                        Inspection_price_str = Inspectiondata.get(5).asText();
                        Inspection_num_str = Inspectiondata.get(6).asText();
                        Inspection_price = Inspection_price_str.equals("") ? Inspection_price : new BigDecimal(Inspection_price_str);
                        Inspection_num = Inspection_num_str.equals("") ? Inspection_num : new BigDecimal(Inspection_num_str);
                        BigDecimal Inspection_totalprice = Inspection_price.multiply(Inspection_num);
                        Inspection_type = Inspectiondata.get(8).asText();
                        if(Inspection_type.equals("违规")){
                            Inspection_illegal_totalprice = Inspection_illegal_totalprice.add(Inspection_totalprice);
                        }
                        Inspection_alltotalprice = Inspection_alltotalprice.add(Inspection_totalprice);

                    }
                }
            }

        }else{
            JsonNode InspectionPagerows = Inspectionpage.get("rows");
            if(InspectionPagerows.isArray()){
                for (JsonNode Inspectionrow : InspectionPagerows) {
                    JsonNode Inspectiondata = Inspectionrow.get("data");
                    Inspection_price_str = Inspectiondata.get(5).asText();
                    Inspection_num_str = Inspectiondata.get(6).asText();
                    Inspection_price = Inspection_price_str.equals("") ? Inspection_price : new BigDecimal(Inspection_price_str);
                    Inspection_num = Inspection_num_str.equals("") ? Inspection_num : new BigDecimal(Inspection_num_str);
                    BigDecimal Inspection_totalprice = Inspection_price.multiply(Inspection_num);
                    Inspection_type = Inspectiondata.get(8).asText();
                    if(Inspection_type.equals("违规")){
                        Inspection_illegal_totalprice = Inspection_illegal_totalprice.add(Inspection_totalprice);
                    }
                    Inspection_alltotalprice = Inspection_alltotalprice.add(Inspection_totalprice);

                }
            }
        }

        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        String Inspection_alltotalprice_str = df.format(Inspection_alltotalprice);
        if(!Inspection_alltotalprice_str.equals(inspectionFee_str)){
            System.out.println("【"+id+"】就诊编号:"+code+"【检查】明细总费用与基本信息页面不一致	");
            System.out.println("基本信息【检查】总计="+inspectionFee_str);
            System.out.println("【检查】明细费用总计="+Inspection_alltotalprice+"	 明细费用总计取两位小数="+Inspection_alltotalprice_str);
            System.out.println("-----------------------------------------------------------------------");

        }

//					获取疑点病例详情------收费明细（检查明细）
        infoMap.put("Inspection_illegal_totalprice", Inspection_illegal_totalprice);
        infoMap.put("inspectionDetail_totalprice", Inspection_alltotalprice);

        return infoMap;

    }
}
