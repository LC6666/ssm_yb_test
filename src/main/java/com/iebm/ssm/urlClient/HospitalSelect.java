package com.iebm.ssm.urlClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.collections.Lists;
import com.iebm.ssm.util.Constant;
import com.iebm.ssm.util.JsonUtil;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class HospitalSelect {

    public void FindHospital(Map infoMap) throws IOException, ClassNotFoundException, URISyntaxException {
        String hospital = infoMap.get("hospital").toString();
        String index = infoMap.get("index").toString();
        String id = infoMap.get("id").toString();
        String code = infoMap.get("code").toString();
        if(!hospital.equals("-")){
            String url = Constant.url + "/framework/taglib/selectorAction.action?method=loadQureyGrid";
            String qureySql = "select '', oid,institution_level_key,institution_name,institution_level_name,area_name from  (  select mi.INSTITUTION_ID as oid, mi.institution_name,cm.key_ as institution_level_key, cm.value_ as institution_level_name, ta.area_name as area_name from MSK_INSTITUTION mi inner join ( select pv.key_, pv.value_ from fw_proplist pl inner join fw_propvalue pv on pv.enable_ = 1 and pv.proplistid_= pl.id_ where pl.enable_ = 1 and pl.code_ = 'app.medical.institution.class' ) cm on cm.key_ = mi.INSTITUTION_LEVEL inner join  msk_area_tata  ta  ON  mi.AREA_ID = ta.area_id where mi.enable_ = 1 and ta.area_id in (select REGEXP_SUBSTR(a.area_id, '[^,]+', 1, LEVEL, 'i') from (select fu.area_id from fw_user fu where fu.id_ = ?) a CONNECT BY LEVEL <= LENGTH(a.area_id) - LENGTH(REGEXP_REPLACE(a.area_id, ',', '')) + 1) order by mi.institution_name asc ) where  institution_name like '%'||replace(replace(?, '/', '//'), '%', '/%')||'%' escape '/'";
            List<NameValuePair> pageParam2ValuePairList = Lists.newArrayList();
            pageParam2ValuePairList.add(new BasicNameValuePair("qureySql", qureySql));
            pageParam2ValuePairList.add(new BasicNameValuePair("params", "30002"));
            pageParam2ValuePairList.add(new BasicNameValuePair("qureyCols", "institution_name"));
            pageParam2ValuePairList.add(new BasicNameValuePair("institution_name", hospital));
            pageParam2ValuePairList.add(new BasicNameValuePair("undefined", ""));
            pageParam2ValuePairList.add(new BasicNameValuePair("pageRecords", "200"));

            String response = DoRequest.dopost(url, pageParam2ValuePairList, MyCookieStore.readCookieStore("cookie"));
//        System.out.println(response);
            if(JsonUtil.isJson(response)){
                JsonNode page = new ObjectMapper().readTree(response).get("page");
                int totalRecords = page.get("totalRecords").asInt();
                if (totalRecords < 1) {

                    System.out.println("就诊编号【"+code+"】"+hospital+"查询不到");
                } else {
                    JsonNode rows = new ObjectMapper().readTree(response).get("rows");
                    if (rows.isArray()) {
                        for (JsonNode row : rows) {
                            JsonNode data = row.get("data");
                            String hos = data.get(4).asText();
                            if (hos.equals(hospital)) {
                                return;
                            }
                        }
                    }
                    System.out.println("就诊编号【"+code+"】"+hospital+"查询不到");

                }
            }else{
                System.out.println("医院【"+hospital+"】查询有异常！");
                return;

            }
        }


    }

}
