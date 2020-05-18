package com.iebm.ssm.urlClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.iebm.ssm.util.Constant;
import com.iebm.ssm.util.JsonUtil;
import com.iebm.ssm.util.MyCookieStore;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.collections.Lists;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class YiDianChaXun {

    YiDianChaXun_BasicInfo basicInfo = new YiDianChaXun_BasicInfo();
    YiDianChaXun_FeesDetail_Drug drugInfo = new YiDianChaXun_FeesDetail_Drug();
    YiDianChaXun_FeesDetail_Inspection inspection = new YiDianChaXun_FeesDetail_Inspection();
    YiDianChaXun_FeesDetail_Cure cure = new YiDianChaXun_FeesDetail_Cure();
    YiDianChaXun_FeesDetail_Material material = new YiDianChaXun_FeesDetail_Material();
    YiDianChaXun_FeesDetail_Other other = new YiDianChaXun_FeesDetail_Other();
    YiDianChaXun_DrugReport drugReport = new YiDianChaXun_DrugReport();
    YiDianChaXun_illegalInfo illegalinfo = new YiDianChaXun_illegalInfo();
    DiseaseSelect diseaseSelect = new DiseaseSelect();
    HospitalSelect hospitalSelect = new HospitalSelect();
    DecimalFormat df = new DecimalFormat("0.00");


    public YiDianChaXun() {
        df.setRoundingMode(RoundingMode.HALF_UP);
    }

    /**
     * 疑点查询--查询所有病例分页信息
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws URISyntaxException
     */
    public int getTotalPages() throws IOException, ClassNotFoundException, URISyntaxException {

//        获取分页信息
        String url = Constant.url + "/app/illegalMedical/illegalMedicalAllotAction.action?method=queryAllRecord";
        List<NameValuePair> nameValuePairList = Lists.newArrayList();
        nameValuePairList.add(new BasicNameValuePair("institutionName",""));
        nameValuePairList.add(new BasicNameValuePair("institutionId",""));
        nameValuePairList.add(new BasicNameValuePair("institutionLevelKey",""));
        nameValuePairList.add(new BasicNameValuePair("diseaseName",""));
        nameValuePairList.add(new BasicNameValuePair("diseaseId",""));
        nameValuePairList.add(new BasicNameValuePair("startCreateTime","2019-01-01"));
        nameValuePairList.add(new BasicNameValuePair("endCreateTime","2020-12-31"));
        nameValuePairList.add(new BasicNameValuePair("siCode",""));
        nameValuePairList.add(new BasicNameValuePair("insuredName",""));
        nameValuePairList.add(new BasicNameValuePair("undefined",""));
        nameValuePairList.add(new BasicNameValuePair("pageRecords","200"));


        String response = DoRequest.dopost(url, nameValuePairList,MyCookieStore.readCookieStore("cookie"));
        JsonNode page = new ObjectMapper().readTree(response).get("page");
        int totalPages = page.get("totalPages").asInt();
        return totalPages;
    }


    /**
     * 疑点查询-分页查询
     * @param totalPages
     * @throws IOException
     * @throws URISyntaxException
     * @throws ClassNotFoundException
     */
    public void queryYiD(int totalPages) throws IOException, URISyntaxException, ClassNotFoundException {
        String url = Constant.url + "/app/illegalMedical/illegalMedicalAllotAction.action?method=queryAllRecord";
        BigDecimal total_illegeFee = BigDecimal.ZERO;

//		==================================================================
//		页面信息循环，获取疑点病例详情
        for (int i = 1; i <= totalPages; i++) {
            List<NameValuePair> pageParamValuePairList = Lists.newArrayList();
            pageParamValuePairList.add(new BasicNameValuePair("currentPage",String.valueOf(i)));
            pageParamValuePairList.add(new BasicNameValuePair("pageRecords","200"));
            pageParamValuePairList.add(new BasicNameValuePair("orderInfo","-1,asc"));
            pageParamValuePairList.add(new BasicNameValuePair("gridbox","app.suspicion.allrecord.query.grid"));
            pageParamValuePairList.add(new BasicNameValuePair("title",""));
            pageParamValuePairList.add(new BasicNameValuePair("institutionName",""));
            pageParamValuePairList.add(new BasicNameValuePair("institutionId",""));
            pageParamValuePairList.add(new BasicNameValuePair("institutionLevelKey",""));
            pageParamValuePairList.add(new BasicNameValuePair("diseaseName",""));
            pageParamValuePairList.add(new BasicNameValuePair("diseaseId",""));
            pageParamValuePairList.add(new BasicNameValuePair("startCreateTime","2019-01-01"));
            pageParamValuePairList.add(new BasicNameValuePair("endCreateTime","2029-12-31"));
            pageParamValuePairList.add(new BasicNameValuePair("siCode",""));
            pageParamValuePairList.add(new BasicNameValuePair("insuredName",""));
            pageParamValuePairList.add(new BasicNameValuePair("institutionLevel",""));
            pageParamValuePairList.add(new BasicNameValuePair("handleState",""));
            pageParamValuePairList.add(new BasicNameValuePair("ruleNum",""));
            pageParamValuePairList.add(new BasicNameValuePair("undefined",""));
            String PageResponse = DoRequest.dopost(url, pageParamValuePairList,MyCookieStore.readCookieStore("cookie"));

            if(JsonUtil.isJson(PageResponse)){
                JsonNode rows = new ObjectMapper().readTree(PageResponse).get("rows");
                if (rows.isArray()) {
                    for (JsonNode row : rows) {
                        JsonNode data = row.get("data");
//                        System.out.println(data);
//                        /*
                        String index = data.get(0).asText();
                        String id = data.get(2).asText();
                        String code = data.get(3).asText();
                        String disease = data.get(7).asText();
//                        String hospital = data.get(6).asText();
                        String hospital = data.get(5).asText();
                        String illegalFee_str = data.get(10).asText();
                        Map info_map = new HashMap();
                        info_map.put("index", index);
                        info_map.put("id", id);
                        info_map.put("code", code);
                        info_map.put("disease", disease);
                        info_map.put("hospital", hospital);
                        info_map.put("illegalFee_str", illegalFee_str);
                        info_map.put("illegalInfo_id",row.get("id").asText());
//                        ======================================================================================================================
//                        计算年度病例违规费用
//                        BigDecimal illegeFee = new BigDecimal(illegalFee_str);
//                        total_illegeFee = total_illegeFee.add(illegeFee);
//                        System.out.println("【"+index+"】【"+id+"】当前病例【"+code+"】违规费用="+illegeFee+"  当前所有病例违规费用总和="+total_illegeFee);
//                        ======================================================================================================================

//                        ======================================================================================================================
//                        病种查询
//                        diseaseSelect.FindDisease(info_map);

//                        医院查询
                          hospitalSelect.FindHospital(info_map);
//                        ======================================================================================================================

//                         病例详情分析
//                        info_map = this.getDetail(info_map);
//                        this.validateIllgal(info_map);
//                        this.validateBasic(info_map);


//                        drugReport.loadReportInfo(info_map);
//                        drugReport.loadReportDrugRate(info_map);

//                        illegalinfo.getIllegalInfo(info_map);


                    }
                }
            }else {
                System.out.println("访问出错！");
            }

        }
//        System.out.println("违规费用总计="+total_illegeFee);

    }

    /**
     * 获取病例详情，分析病例
     * @param info_map
     * @throws URISyntaxException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Map getDetail(Map info_map) throws URISyntaxException, IOException, ClassNotFoundException {


//      基本信息页面的费用分析
        info_map = basicInfo.getBasicInfo(info_map);
//      收费明细--药品明细费用分析
        info_map = drugInfo.getDrugDetail(info_map);
//      收费明细--检查明细费用分析
        info_map = inspection.getInspection(info_map);
//      收费明细--治疗明细费用分析
        info_map = cure.getCureDetail(info_map);
//      收费明细--材料明细费用分析
        info_map = material.getMaterialDetail(info_map);
//      收费明细--其他明细费用分析
        info_map = other.getOtherDetail(info_map);
        return info_map;


    }


    /**
     * 验证基本信息各项总费用是否一致
     * 验证违规费用是否一致
     * @param info_map
     */
    public void validateBasic(Map info_map){
//        验证明细费用与基本信息的总费用是否一致
        String id = info_map.get("id").toString();
        String code = info_map.get("code").toString();
        BigDecimal Materials_alltotalprice = (BigDecimal) info_map.get("materialsDetail_totalprice");
        BigDecimal Other_alltotalprice  = (BigDecimal) info_map.get("otherDetail_totalprice");
        BigDecimal totalOther = Other_alltotalprice.add(Materials_alltotalprice);
        String otherFee_str = info_map.get("otherFee_str").toString();
        String totalOther_str = df.format(totalOther);
        if(!totalOther_str.equals(otherFee_str)){
            System.out.println("【"+id+"】就诊编号:"+code+"【其他】明细总费用与基本信息页面不一致	");
            System.out.println("基本信息【其他】总计="+otherFee_str);
            System.out.println("【其他】明细费用总计="+totalOther+"	 明细费用总计取两位小数="+totalOther_str);

        }
    }


    /**
     * 验证违规费用是否一致
     * 违规费用有可能与明细中的违规总费用有差别（占比类规则原因），此场景可作废
     *
     * @param info_map
     */
    public void validateIllgal(Map info_map){
//        验证明细违规费用与基本信息中的违规总费用是否一致
        String id = info_map.get("id").toString();
        String code = info_map.get("code").toString();
        BigDecimal drug_llegal_totalprice = (BigDecimal) info_map.get("drug_llegal_totalprice");
        BigDecimal Inspection_illegal_totalprice = (BigDecimal) info_map.get("Inspection_illegal_totalprice");
        BigDecimal Cure_llegal_totalprice = (BigDecimal) info_map.get("Cure_llegal_totalprice");
        BigDecimal Materials_llegal_totalprice = (BigDecimal) info_map.get("Materials_llegal_totalprice");
        BigDecimal Other_llegal_totalprice  = (BigDecimal) info_map.get("Other_llegal_totalprice");

        BigDecimal all_illegalprice = drug_llegal_totalprice.add(Inspection_illegal_totalprice).add(Cure_llegal_totalprice).add(Materials_llegal_totalprice).add(Other_llegal_totalprice);
        String all_illegalprice_str = df.format(all_illegalprice);

        String illegalFee_str = info_map.get("illegalFee_str").toString();
        BigDecimal illegalFee = new BigDecimal(illegalFee_str);
        String illegalFee_str2 = df.format(illegalFee);

        String ownExpense_str = info_map.get("ownExpense_str").toString();

//        验证病例违规费用与基本信息违规费用是否一致
        if(!illegalFee_str2.equals(ownExpense_str)){
            System.out.println("【"+id+"】就诊编号【"+code+"】违规总费用与基本信息违规费用不一致   违规费用="+illegalFee_str2+" 基本信息违规费用="+ownExpense_str);
        }

//       验证病例违规费用与费用详情是否一致
        if(!all_illegalprice_str.equals(illegalFee_str2)){
            System.out.println("【"+id+"】就诊编号【"+code+"】违规总费用与明细违规总费用不一致   明细违规费用="+all_illegalprice_str+" 基本信息违规费用="+ownExpense_str);
        }
    }



    public static void main(String[ ] args) throws IOException, URISyntaxException, ClassNotFoundException {
        Login login = new Login();
        login.openLoginPage();
        String s = login.loginURL();
        if(JsonUtil.isJson(s)){
            YiDianChaXun y = new YiDianChaXun();
            int totalPages = y.getTotalPages();
            y.queryYiD(totalPages);
        }else {
            System.out.println("登录失败!退出请求!");
        }

    }

}
