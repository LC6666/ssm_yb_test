package com.iebm.ssm.urlClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iebm.ssm.util.Constant;
import com.iebm.ssm.util.JsonUtil;
import com.iebm.ssm.util.MyCookieStore;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.collections.Lists;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class DiseaseSelect {

    public void FindDisease(Map infoMap) throws IOException, ClassNotFoundException, URISyntaxException {
        String disease = infoMap.get("disease").toString();
        String index = infoMap.get("index").toString();
        String id = infoMap.get("id").toString();
        String code = infoMap.get("code").toString();
        if(!disease.equals("-")){
            String url = Constant.url + "/framework/taglib/selectorAction.action?method=loadQureyGrid";
            String qureySql = "select '', oid,disease_name,disease_remark from  (  select d.disease_id as oid, d.dis_name as disease_name, d.dis_remark as disease_remark from mr_disease d where d.enable_ = 1 and d.diagnosis_type  = 1 order by replace(d.dis_name,replace(?, '%', '/%'),'') desc,d.disease_id asc ) where  disease_name like '%'||replace(replace(?, '/', '//'), '%', '/%')||'%' escape '/'";
            List<NameValuePair> pageParam2ValuePairList = Lists.newArrayList();
            pageParam2ValuePairList.add(new BasicNameValuePair("qureySql", qureySql));
            pageParam2ValuePairList.add(new BasicNameValuePair("params", "'"+disease+"'"));
            pageParam2ValuePairList.add(new BasicNameValuePair("qureyCols", "disease_name"));
            pageParam2ValuePairList.add(new BasicNameValuePair("disease_name", disease));
            pageParam2ValuePairList.add(new BasicNameValuePair("undefined", ""));
            pageParam2ValuePairList.add(new BasicNameValuePair("pageRecords", "200"));

            String response = DoRequest.dopost(url, pageParam2ValuePairList, MyCookieStore.readCookieStore("cookie"));
//        System.out.println(response);
            if(JsonUtil.isJson(response)){
                JsonNode page = new ObjectMapper().readTree(response).get("page");
                int totalRecords = page.get("totalRecords").asInt();
                if (totalRecords < 1) {

                    System.out.println("就诊编号【"+code+"】"+disease+"查询不到");
                } else {
                    JsonNode rows = new ObjectMapper().readTree(response).get("rows");
                    if (rows.isArray()) {
                        for (JsonNode row : rows) {
                            JsonNode data = row.get("data");
                            String dis = data.get(3).asText();
                            if (dis.equals(disease)) {
                                return;
                            }
                        }
                    }
                    System.out.println("就诊编号【"+code+"】"+"疾病【"+disease+"】查询不到");

                }
            }else{
                System.out.println("就诊编号【"+code+"】"+"疾病【"+disease+"】查询有异常！");
                return;

            }
        }


    }

}
