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

public class YiDianChaXun_FeesDetail_Material {

    /**
     * 查询病例收费明细---材料明细
     * @param infoMap
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws URISyntaxException
     */
    public Map getMaterialDetail(Map infoMap) throws IOException, ClassNotFoundException, URISyntaxException {

        String id = infoMap.get("id").toString();
        String code = infoMap.get("code").toString();


        //					获取疑点病例详情------收费明细（材料明细）
        String MaterialsUrl = Constant.url + "/app/diagnoseRelevant/view/diagnoseRelevantAction.action?method=loadMaterialsInfo&a_dhx_rSeed=1545356330008";

        List<NameValuePair> MaterialParamValuePairList = Lists.newArrayList();
        MaterialParamValuePairList.add(new BasicNameValuePair("pid",String.valueOf(id)));
        MaterialParamValuePairList.add(new BasicNameValuePair("ssmLevel",""));
        MaterialParamValuePairList.add(new BasicNameValuePair("pageRecords","200"));


        String Materialsresponse = DoRequest.dopost(MaterialsUrl, MaterialParamValuePairList, MyCookieStore.readCookieStore("cookie"));
//					System.out.println(Materialsresponse);
//					获取分页信息
        JsonNode Materialspage = new ObjectMapper().readTree(Materialsresponse);
        int MaterialstotalPages = Materialspage.get("page").get("totalPages").asInt();
        String Materials_price_str="";
        String Materials_num_str="";
        String Materials_type = "";
        BigDecimal Materials_alltotalprice = BigDecimal.ZERO;
        BigDecimal Materials_llegal_totalprice = BigDecimal.ZERO;
        BigDecimal Materials_price = BigDecimal.ZERO;
        BigDecimal Materials_num = BigDecimal.ZERO;
        if (MaterialstotalPages>1) {
            for(int MaterialsPageNum=1;MaterialsPageNum<=MaterialstotalPages;MaterialsPageNum++){
                            /*
                            String MaterialsPageParam = "currentPage="+MaterialsPageNum+"&pageRecords=200&orderInfo=-1,asc&gridbox=app.common.diagnosis.recipeInfo.gridA&title=&&pid="+id+"&ssmLevel=";
                            String MaterialsPageResponse = HttpRequest.sendPost(MaterialsUrl, driver.manage().getCookies().toString(), MaterialsPageParam);
                            */
                List<NameValuePair> MaterialsPageParamValuePairList = Lists.newArrayList();
                MaterialsPageParamValuePairList.add(new BasicNameValuePair("currentPage",String.valueOf(MaterialsPageNum)));
                MaterialsPageParamValuePairList.add(new BasicNameValuePair("pageRecords","200"));
                MaterialsPageParamValuePairList.add(new BasicNameValuePair("orderInfo","-1,asc"));
                MaterialsPageParamValuePairList.add(new BasicNameValuePair("gridbox","app.common.diagnosis.recipeInfo.gridA"));
                MaterialsPageParamValuePairList.add(new BasicNameValuePair("title",""));
                MaterialsPageParamValuePairList.add(new BasicNameValuePair("pid",String.valueOf(id)));
                MaterialsPageParamValuePairList.add(new BasicNameValuePair("ssmLevel",""));
                String MaterialsPageResponse = DoRequest.dopost(MaterialsUrl, MaterialsPageParamValuePairList, MyCookieStore.readCookieStore("cookie"));
                JsonNode Materialsrows = new ObjectMapper().readTree(MaterialsPageResponse).get("rows");
                if(Materialsrows.isArray()){
                    for (JsonNode Materialsrow : Materialsrows) {
                        JsonNode Materialsdata = Materialsrow.get("data");
                        Materials_price_str = Materialsdata.get(5).asText();
                        Materials_num_str = Materialsdata.get(6).asText();
                        Materials_price = Materials_price_str.equals("") ? Materials_price : new BigDecimal(Materials_price_str);
                        Materials_num = Materials_num_str.equals("") ? Materials_num : new BigDecimal(Materials_num_str);
                        BigDecimal Materials_totalprice = Materials_price.multiply(Materials_num);
                        Materials_type = Materialsdata.get(8).asText();
                        if(Materials_type.equals("违规")){
                            Materials_llegal_totalprice = Materials_llegal_totalprice.add(Materials_totalprice);
                        }
                        Materials_alltotalprice = Materials_alltotalprice.add(Materials_totalprice);

                    }
                }
            }

        }else{
            JsonNode Materialsrows = Materialspage.get("rows");
            if(Materialsrows.isArray()){
                for (JsonNode Materialsrow : Materialsrows) {
                    JsonNode Materialsdata = Materialsrow.get("data");
                    Materials_price_str = Materialsdata.get(5).asText();
                    Materials_num_str = Materialsdata.get(6).asText();
                    Materials_price = Materials_price_str.equals("") ? Materials_price : new BigDecimal(Materials_price_str);
                    Materials_num = Materials_num_str.equals("") ? Materials_num : new BigDecimal(Materials_num_str);
                    BigDecimal Materials_totalprice = Materials_price.multiply(Materials_num);
                    Materials_type = Materialsdata.get(8).asText();
                    if(Materials_type.equals("违规")){
                        Materials_llegal_totalprice = Materials_llegal_totalprice.add(Materials_totalprice);
                    }
                    Materials_alltotalprice = Materials_alltotalprice.add(Materials_totalprice);

                }
            }
        }
        infoMap.put("Materials_llegal_totalprice", Materials_llegal_totalprice);
        infoMap.put("materialsDetail_totalprice", Materials_alltotalprice);
        return infoMap;

//					获取疑点病例详情------收费明细（材料明细）
    }
}
