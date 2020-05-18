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

public class YiDianChaXun_FeesDetail_Drug {

    /**
     * 查询病例收费明细---药品明细
     * @param infoMap
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws URISyntaxException
     */
    public Map getDrugDetail(Map infoMap) throws IOException, ClassNotFoundException, URISyntaxException {

        String id = infoMap.get("id").toString();
        String code = infoMap.get("code").toString();
        String drugFee_str = infoMap.get("drugFee_str").toString();

        //					获取疑点病例详情------收费明细（药品明细）

        String drugUrl = Constant.url + "/app/diagnoseRelevant/view/diagnoseRelevantAction.action?method=loadDrugInfo&a_dhx_rSeed=1545356330008";


        List<NameValuePair> drugParamValuePairList = Lists.newArrayList();
        drugParamValuePairList.add(new BasicNameValuePair("pid",String.valueOf(id)));
        drugParamValuePairList.add(new BasicNameValuePair("ssmLevel",""));
        drugParamValuePairList.add(new BasicNameValuePair("pageRecords","200"));

        String Drugresponse =DoRequest.dopost(drugUrl, drugParamValuePairList, MyCookieStore.readCookieStore("cookie"));

//					获取分页信息
//                    System.out.println(Drugresponse);
        JsonNode drugpage = new ObjectMapper().readTree(Drugresponse);
        int drugtotalPages = drugpage.get("page").get("totalPages").asInt();
        String drug_price_str="";
        String drug_num_str="";
        String illegalFlag = "";
        String drug_type = "";
        BigDecimal drug_alltotalprice = BigDecimal.ZERO;
        BigDecimal drug_firstType_totalprice = BigDecimal.ZERO;
        BigDecimal drug_secondType_totalprice = BigDecimal.ZERO;
        BigDecimal drug_otherType_totalprice = BigDecimal.ZERO;
        BigDecimal drug_llegal_totalprice = BigDecimal.ZERO;
        BigDecimal drug_price = BigDecimal.ZERO;
        BigDecimal drug_num = BigDecimal.ZERO;
        if (drugtotalPages>1) {
            for(int drugPageNum=1;drugPageNum<=drugtotalPages;drugPageNum++){

                List<NameValuePair> drugPageValuePairList = Lists.newArrayList();
                drugPageValuePairList.add(new BasicNameValuePair("currentPage",String.valueOf(drugPageNum)));
                drugPageValuePairList.add(new BasicNameValuePair("pageRecords","200"));
                drugPageValuePairList.add(new BasicNameValuePair("orderInfo","-1,asc"));
                drugPageValuePairList.add(new BasicNameValuePair("gridbox","app.common.diagnosis.recipeInfo.gridA"));
                drugPageValuePairList.add(new BasicNameValuePair("title",""));
                drugPageValuePairList.add(new BasicNameValuePair("pid",id));
                drugPageValuePairList.add(new BasicNameValuePair("ssmLevel",""));
                String DrugPageResponse =DoRequest.dopost(drugUrl, drugPageValuePairList, MyCookieStore.readCookieStore("cookie"));
                JsonNode drugrows = new ObjectMapper().readTree(DrugPageResponse).get("rows");
                if(drugrows.isArray()){
                    for (JsonNode drugrow : drugrows) {
                        JsonNode drugdata = drugrow.get("data");
                        drug_price_str = drugdata.get(11).asText();
                        drug_num_str = drugdata.get(12).asText();
                        drug_price = drug_price_str.equals("") ? drug_price : new BigDecimal(drug_price_str);
                        drug_num = drug_price_str.equals("") ? drug_num : new BigDecimal(drug_num_str);
                        BigDecimal drug_totalprice = drug_price.multiply(drug_num);
                        drug_type = drugdata.get(13).asText();
                        switch(drug_type){
                            case "甲类":
                                drug_firstType_totalprice = drug_firstType_totalprice.add(drug_totalprice);
                                break;
                            case "乙类":
                                drug_secondType_totalprice = drug_secondType_totalprice.add(drug_totalprice);
                                break;
                            default :
                                drug_otherType_totalprice = drug_otherType_totalprice.add(drug_totalprice);
                                break;

                        };

                        illegalFlag = drugdata.get(14).asText();
                        if(illegalFlag.equals("违规")){
                            drug_llegal_totalprice = drug_llegal_totalprice.add(drug_totalprice);
                        }
                        drug_alltotalprice = drug_alltotalprice.add(drug_totalprice);

                    }
                }
            }

        }else{
            JsonNode drugrows = drugpage.get("rows");
            if(drugrows.isArray()){
                for (JsonNode drugrow : drugrows) {
                    JsonNode drugdata = drugrow.get("data");
                    drug_price_str = drugdata.get(11).asText();
                    drug_num_str = drugdata.get(12).asText();
                    drug_price = drug_price_str.equals("") ? drug_price : new BigDecimal(drug_price_str);
                    drug_num = drug_num_str.equals("") ? drug_num : new BigDecimal(drug_num_str);
                    BigDecimal drug_totalprice = drug_price.multiply(drug_num);
                    drug_type = drugdata.get(13).asText();
                    switch(drug_type){
                        case "甲类":
                            drug_firstType_totalprice = drug_firstType_totalprice.add(drug_totalprice);
                            break;
                        case "乙类":
                            drug_secondType_totalprice = drug_secondType_totalprice.add(drug_totalprice);
                            break;
                        default :
                            drug_otherType_totalprice = drug_otherType_totalprice.add(drug_totalprice);
                            break;

                    };
                    illegalFlag = drugdata.get(14).asText();
                    if(illegalFlag.equals("违规")){
                        drug_llegal_totalprice = drug_llegal_totalprice.add(drug_totalprice);
                    }
                    drug_alltotalprice = drug_alltotalprice.add(drug_totalprice);


                }
            }
        }

        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        String drug_alltotalprice_str = df.format(drug_alltotalprice);
        if(!drug_alltotalprice_str.equals(drugFee_str)){
            System.out.println("【"+id+"】就诊编号:"+code+"【药品】明细总费用与基本信息页面不一致	");
            System.out.println("基本信息【药品】总计="+drugFee_str);
            System.out.println("【药品】明细费用总计="+drug_alltotalprice+"	 明细费用总计取两位小数="+drug_alltotalprice_str);
            System.out.println("-----------------------------------------------------------------------");

        }

        infoMap.put("drug_llegal_totalprice", drug_llegal_totalprice);
        infoMap.put("drugDetail_totalprice", drug_alltotalprice);
        infoMap.put("drug_firstType_totalprice", drug_firstType_totalprice);
        infoMap.put("drug_secondType_totalprice", drug_secondType_totalprice);
        infoMap.put("drug_otherType_totalprice", drug_otherType_totalprice);

        return infoMap;
//					获取疑点病例详情------收费明细（药品明细）
    }
}
