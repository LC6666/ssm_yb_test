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
import java.util.List;

/**
 *  TODO: 2018/12/29  病历查询
 */
public class BingLiChaXun {

    public int getTotalPage() throws IOException, ClassNotFoundException, URISyntaxException {
        //        获取分页信息
        String url = Constant.url + "/app/illegalMedical/illegalMedicalAllotAction.action?method=queryAllRecord";
        List<NameValuePair> nameValuePairList = Lists.newArrayList();
        nameValuePairList.add(new BasicNameValuePair("institutionName",""));
        nameValuePairList.add(new BasicNameValuePair("institutionId",""));
        nameValuePairList.add(new BasicNameValuePair("institutionLevelKey",""));
        nameValuePairList.add(new BasicNameValuePair("diseaseName",""));
        nameValuePairList.add(new BasicNameValuePair("diseaseId",""));
        nameValuePairList.add(new BasicNameValuePair("startCreateTime","2012-12-31"));
        nameValuePairList.add(new BasicNameValuePair("endCreateTime","2020-03-26"));
        nameValuePairList.add(new BasicNameValuePair("siCode",""));
        nameValuePairList.add(new BasicNameValuePair("insuredName",""));
        nameValuePairList.add(new BasicNameValuePair("undefined",""));
        nameValuePairList.add(new BasicNameValuePair("pageRecords","200"));


        String response = DoRequest.dopost(url, nameValuePairList,MyCookieStore.readCookieStore("cookie"));

        if(JsonUtil.isJson(response)){
            JsonNode page = new ObjectMapper().readTree(response).get("page");
            int totalPages = page.get("totalPages").asInt();
            return totalPages;
        }
        return 0;

    }



    public void getPerPage(int totalPages) throws IOException, ClassNotFoundException, URISyntaxException {
        if(totalPages>0){
            String url = Constant.url + "/app/illegalMedical/illegalMedicalAllotAction.action?method=queryAllRecord";
            int illegalcount=0,normalcount=0;
            for(int pageNum=1;pageNum<=totalPages;pageNum++){
                List<NameValuePair> nameValuePairList = Lists.newArrayList();
                nameValuePairList.add(new BasicNameValuePair("pageRecords","200"));
                nameValuePairList.add(new BasicNameValuePair("orderInfo","-1,asc"));
                nameValuePairList.add(new BasicNameValuePair("gridbox","app.suspicion.allrecord.query.grid"));
                nameValuePairList.add(new BasicNameValuePair("title",""));
                nameValuePairList.add(new BasicNameValuePair("institutionName",""));
                nameValuePairList.add(new BasicNameValuePair("institutionId",""));
                nameValuePairList.add(new BasicNameValuePair("institutionLevelKey",""));
                nameValuePairList.add(new BasicNameValuePair("diseaseName",""));
                nameValuePairList.add(new BasicNameValuePair("diseaseId",""));
                nameValuePairList.add(new BasicNameValuePair("startCreateTime","2012-12-31"));
                nameValuePairList.add(new BasicNameValuePair("endCreateTime","2020-03-26"));
                nameValuePairList.add(new BasicNameValuePair("siCode",""));
                nameValuePairList.add(new BasicNameValuePair("insuredName",""));
                nameValuePairList.add(new BasicNameValuePair("institutionLevel",""));
                nameValuePairList.add(new BasicNameValuePair("undefined",""));
                nameValuePairList.add(new BasicNameValuePair("currentPage",String.valueOf(pageNum)));
                String PageResponse = DoRequest.dopost(url, nameValuePairList,MyCookieStore.readCookieStore("cookie"));
                if(JsonUtil.isJson(PageResponse)){
                    JsonNode rows = new ObjectMapper().readTree(PageResponse).get("rows");
                    if(rows.isArray()){
                        for (JsonNode row:rows){
                            JsonNode data = row.get("data");
                            String flag = data.get(8).asText();
                            if(flag.equals("是")){
                                illegalcount++;
                            }else{
                                normalcount++;
                            }
                        }
                    }

                }else{
                    System.out.println("病例查询异常！");
                }
            }
            System.out.println("总病例中，正常病例有"+normalcount+"   违规病例有"+illegalcount);

        }

    }

    public static void main(String[] args) throws IOException, URISyntaxException, ClassNotFoundException {
        Login login = new Login();
        login.openLoginPage();
        String s = login.loginURL();
        if(JsonUtil.isJson(s)){
            BingLiChaXun bc = new BingLiChaXun();
            int totalpage = bc.getTotalPage();
            bc.getPerPage(totalpage);
        }else {
            System.out.println("登录失败!退出请求!");
        }
    }
}
