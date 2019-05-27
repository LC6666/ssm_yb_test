package com.iebm.ssm.urlClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.iebm.ssm.util.Constant;
import com.iebm.ssm.util.JsonUtil;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;


public class YiDianChaXun_illegalInfo {


    /**
     * 查询疑点信息
     * @param infoMap
     * @throws URISyntaxException
     * @throws IOException
     */


    public void getIllegalInfo(Map infoMap) throws IOException, ClassNotFoundException, URISyntaxException {

        String id= infoMap.get("illegalInfo_id").toString();
        String url= Constant.url + "/app/diagnoseRelevant/view/diagnoseRelevantAction.action?method=loadDoubtDetail&pageRecords=100";
        List<NameValuePair> nameValuePairList = Lists.newArrayList();
        nameValuePairList.add(new BasicNameValuePair("illegalId",id));
        nameValuePairList.add(new BasicNameValuePair("pageRecords","undefined"));

        String response = DoRequest.dopost(url, nameValuePairList, MyCookieStore.readCookieStore("cookie"));
        if(JsonUtil.isJson(response)){
            JsonNode drugpage = new ObjectMapper().readTree(response);

            int totalPages = drugpage.get("page").get("totalPages").asInt();
            int totalRecords = drugpage.get("page").get("totalRecords").asInt();
            if(totalRecords>1&&totalPages>1){
                System.out.println("就诊编号【" + infoMap.get("code").toString() + "】   违规过多，请注意！" );
            }
            if(totalRecords==0){
                System.out.println("没有违规,违规费用为："+infoMap.get("illegalFee_str").toString());
            }else{
                JsonNode rows = new ObjectMapper().readTree(response).get("rows");
                for (JsonNode row :rows ) {
                    JsonNode data = row.get("data");
//                   序号
                    String index = data.get(0).asText();
//                    规则信息
                    String str1 = data.get(1).asText();
//                    违规类型
                    String ilegalType = data.get(4).asText();
//                    违规费用
                    String ilegalFees = data.get(6).asText();
//                    疑似违规费用
                    String ilegalFees2 = data.get(7).asText();


                }

            }
        }else {
            System.out.println("就诊编号【" + infoMap.get("code").toString() + "】   违规信息返回异常，请注意！" );
        }




    }
}
