package com.iebm.ssm.urlClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.collections.Lists;
import com.iebm.ssm.util.Constant;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.List;

public class YiDianChaXun_FeesDetail_Other {


    /**
     * 查询病例收费明细---其他明细
     * @param infoMap
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws URISyntaxException
     */
    public Map getOtherDetail(Map infoMap) throws IOException, ClassNotFoundException, URISyntaxException {

        String id = infoMap.get("id").toString();

        //					获取疑点病例详情------收费明细（其他明细）
        String OtherUrl = Constant.url + "/app/diagnoseRelevant/view/diagnoseRelevantAction.action?method=loadOtherInfo&a_dhx_rSeed=1545356330008";

        List<NameValuePair> OtherParamValuePairList = Lists.newArrayList();
        OtherParamValuePairList.add(new BasicNameValuePair("pid",String.valueOf(id)));
        OtherParamValuePairList.add(new BasicNameValuePair("ssmLevel",""));
        OtherParamValuePairList.add(new BasicNameValuePair("pageRecords","200"));
//
        String Otherresponse = DoRequest.dopost(OtherUrl, OtherParamValuePairList, MyCookieStore.readCookieStore("cookie"));
//					获取分页信息
        JsonNode Otherpage = new ObjectMapper().readTree(Otherresponse);
        int OthertotalPages = Otherpage.get("page").get("totalPages").asInt();
        String Other_price_str="";
        String Other_num_str="";
        String Other_type = "";
        BigDecimal Other_alltotalprice = BigDecimal.ZERO;
        BigDecimal Other_llegal_totalprice = BigDecimal.ZERO;
        BigDecimal Other_price = BigDecimal.ZERO;
        BigDecimal Other_num = BigDecimal.ZERO;
        if (OthertotalPages>1) {
            for(int OtherPageNum=1;OtherPageNum<=OthertotalPages;OtherPageNum++){
                            /*
                            String OtherPageParam = "currentPage="+OtherPageNum+"&pageRecords=200&orderInfo=-1,asc&gridbox=app.common.diagnosis.recipeInfo.gridA&title=&&pid="+id+"&ssmLevel=";
                            String OtherPageResponse = HttpRequest.sendPost(OtherUrl, driver.manage().getCookies().toString(), OtherPageParam);
                            */
                List<NameValuePair> OtherPageParamValuePairList = Lists.newArrayList();
                OtherPageParamValuePairList.add(new BasicNameValuePair("currentPage",String.valueOf(OtherPageNum)));
                OtherPageParamValuePairList.add(new BasicNameValuePair("pageRecords","200"));
                OtherPageParamValuePairList.add(new BasicNameValuePair("orderInfo","-1,asc"));
                OtherPageParamValuePairList.add(new BasicNameValuePair("gridbox","app.common.diagnosis.recipeInfo.gridA"));
                OtherPageParamValuePairList.add(new BasicNameValuePair("title",""));
                OtherPageParamValuePairList.add(new BasicNameValuePair("pid",String.valueOf(id)));
                OtherPageParamValuePairList.add(new BasicNameValuePair("ssmLevel",""));
                String OtherPageResponse = DoRequest.dopost(OtherUrl, OtherPageParamValuePairList, MyCookieStore.readCookieStore("cookie"));
                JsonNode Otherrows = new ObjectMapper().readTree(OtherPageResponse).get("rows");
                if(Otherrows.isArray()){
                    for (JsonNode Otherrow : Otherrows) {
                        JsonNode Otherdata = Otherrow.get("data");
                        Other_price_str = Otherdata.get(5).asText();
                        Other_num_str = Otherdata.get(6).asText();
                        Other_price = Other_price_str.equals("") ? Other_price : new BigDecimal(Other_price_str);
                        Other_num = Other_num_str.equals("") ? Other_num : new BigDecimal(Other_num_str);
                        BigDecimal Other_totalprice = Other_price.multiply(Other_num);
                        Other_type = Otherdata.get(8).asText();
                        if(Other_type.equals("违规")){
                            Other_llegal_totalprice = Other_llegal_totalprice.add(Other_totalprice);
                        }
                        Other_alltotalprice = Other_alltotalprice.add(Other_totalprice);

                    }
                }
            }

        }else{
            JsonNode Otherrows = Otherpage.get("rows");
            if(Otherrows.isArray()){
                for (JsonNode Otherrow : Otherrows) {
                    JsonNode Otherdata = Otherrow.get("data");
                    Other_price_str = Otherdata.get(5).asText();
                    Other_num_str = Otherdata.get(6).asText();
                    Other_price = Other_price_str.equals("") ? Other_price : new BigDecimal(Other_price_str);
                    Other_num = Other_num_str.equals("") ? Other_num : new BigDecimal(Other_num_str);
                    BigDecimal Other_totalprice = Other_price.multiply(Other_num);
                    Other_type = Otherdata.get(8).asText();
                    if(Other_type.equals("违规")){
                        Other_llegal_totalprice = Other_llegal_totalprice.add(Other_totalprice);
                    }
                    Other_alltotalprice = Other_alltotalprice.add(Other_totalprice);

                }
            }
        }


        infoMap.put("Other_llegal_totalprice", Other_llegal_totalprice);
        infoMap.put("otherDetail_totalprice", Other_alltotalprice);

//					获取疑点病例详情------收费明细（其他明细）

        return infoMap;
    }
}
