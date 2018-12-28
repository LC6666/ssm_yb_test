package com.iebm.ssm.urlClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.iebm.ssm.util.Constant;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.List;

public class YiDianChaXun_FeesDetail_Cure {

    /**
     * 查询病例收费明细---治疗明细
     * @param infoMap
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws URISyntaxException
     */
    public Map getCureDetail(Map infoMap) throws IOException, ClassNotFoundException, URISyntaxException {

        String id = infoMap.get("id").toString();
        String code = infoMap.get("code").toString();
        String treatmentFee_str = infoMap.get("treatmentFee_str").toString();

        //					获取疑点病例详情------收费明细（治疗明细）
        String CureUrl = Constant.url + "/app/diagnoseRelevant/view/diagnoseRelevantAction.action?method=loadCureInfo&a_dhx_rSeed=1545356330008";


        List<NameValuePair> CureParamValuePairList = Lists.newArrayList();
        CureParamValuePairList.add(new BasicNameValuePair("pid",id));
        CureParamValuePairList.add(new BasicNameValuePair("ssmLevel",""));
        CureParamValuePairList.add(new BasicNameValuePair("pageRecords","200"));

        String Cureresponse =DoRequest.dopost(CureUrl,CureParamValuePairList,MyCookieStore.readCookieStore("cookie"));

        //					获取分页信息
        JsonNode Curepage = new ObjectMapper().readTree(Cureresponse);
        int CuretotalPages = Curepage.get("page").get("totalPages").asInt();
        String Cure_price_str="";
        String Cure_num_str="";
        String Cure_type = "";
        BigDecimal Cure_alltotalprice = BigDecimal.ZERO;
        BigDecimal Cure_llegal_totalprice = BigDecimal.ZERO;
        BigDecimal Cure_price = BigDecimal.ZERO;
        BigDecimal Cure_num = BigDecimal.ZERO;
        if (CuretotalPages>1) {
            for(int CurePageNum=1;CurePageNum<=CuretotalPages;CurePageNum++){
                List<NameValuePair> CurePageParamValuePairList = Lists.newArrayList();
                CurePageParamValuePairList.add(new BasicNameValuePair("currentPage",String.valueOf(CurePageNum)));
                CurePageParamValuePairList.add(new BasicNameValuePair("pageRecords","200"));
                CurePageParamValuePairList.add(new BasicNameValuePair("orderInfo","-1,asc"));
                CurePageParamValuePairList.add(new BasicNameValuePair("gridbox","app.common.diagnosis.recipeInfo.gridA"));
                CurePageParamValuePairList.add(new BasicNameValuePair("title",""));
                CurePageParamValuePairList.add(new BasicNameValuePair("pid",String.valueOf(id)));
                CurePageParamValuePairList.add(new BasicNameValuePair("ssmLevel",""));
                String CurePageResponse = DoRequest.dopost(CureUrl, CurePageParamValuePairList, MyCookieStore.readCookieStore("cookie"));

                JsonNode Curerows = new ObjectMapper().readTree(CurePageResponse).get("rows");
                if(Curerows.isArray()){
                    for (JsonNode Curerow : Curerows) {
                        JsonNode Curedata = Curerow.get("data");
                        Cure_price_str = Curedata.get(5).asText();
                        Cure_num_str = Curedata.get(6).asText();
                        Cure_price = Cure_price_str.equals("") ? Cure_price : new BigDecimal(Cure_price_str);
                        Cure_num = Cure_num_str.equals("") ? Cure_num : new BigDecimal(Cure_num_str);
                        BigDecimal Cure_totalprice = Cure_price.multiply(Cure_num);
                        Cure_type = Curedata.get(8).asText();
                        if(Cure_type.equals("违规")){
                            Cure_llegal_totalprice = Cure_llegal_totalprice.add(Cure_totalprice);
                        }
                        Cure_alltotalprice = Cure_alltotalprice.add(Cure_totalprice);

                    }
                }
            }

        }else{
            JsonNode Curerows = Curepage.get("rows");
            if(Curerows.isArray()){
                for (JsonNode Curerow : Curerows) {
                    JsonNode Curedata = Curerow.get("data");
                    Cure_price_str = Curedata.get(5).asText();
                    Cure_num_str = Curedata.get(6).asText();
                    Cure_price = Cure_price_str.equals("") ? Cure_price : new BigDecimal(Cure_price_str);
                    Cure_num = Cure_num_str.equals("") ? Cure_num : new BigDecimal(Cure_num_str);
                    BigDecimal Cure_totalprice = Cure_price.multiply(Cure_num);
                    Cure_type = Curedata.get(8).asText();
                    if(Cure_type.equals("违规")){
                        Cure_llegal_totalprice = Cure_llegal_totalprice.add(Cure_totalprice);
                    }
                    Cure_alltotalprice = Cure_alltotalprice.add(Cure_totalprice);

                }
            }
        }

        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        String Cure_alltotalprice_str = df.format(Cure_alltotalprice);
        if(!Cure_alltotalprice_str.equals(treatmentFee_str)){
            System.out.println("【"+id+"】就诊编号:"+code+"【治疗】明细总费用与基本信息页面不一致	");
            System.out.println("基本信息【治疗】总计="+treatmentFee_str);
            System.out.println("【治疗】明细费用总计="+Cure_alltotalprice+"	 明细费用总计取两位小数="+Cure_alltotalprice_str);
            System.out.println("-----------------------------------------------------------------------");

        }

        infoMap.put("Cure_llegal_totalprice", Cure_llegal_totalprice);
        infoMap.put("cureDetail_totalprice", Cure_alltotalprice);

        return infoMap;

//					获取疑点病例详情------收费明细（治疗明细）

    }


}
