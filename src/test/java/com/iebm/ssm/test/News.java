package com.iebm.ssm.test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iebm.ssm.urlClient.DoRequest;
import com.iebm.ssm.util.Constant;
import com.iebm.ssm.util.JsonUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URISyntaxException;

public class News {

    public String getNews() throws IOException, URISyntaxException {
        String url = "https://36kr.com/newsflashes";
        String response = DoRequest.doget(url, null, null);
        return response;

    }

    public void getNewsTitle(String s) throws IOException {
        Document doc = Jsoup.parseBodyFragment(s);
        String script = doc.getElementById("app").nextElementSibling().html();
        script = script.replace("var props=", "");
//        System.out.println(script);
        if(JsonUtil.isJson(script)){
            JsonNode column = new ObjectMapper().readTree(script).get("newsflashColumns|column");
            JsonNode newsflash = new ObjectMapper().readTree(script).get("newsflashList|newsflash");
            System.out.println(newsflash);
            for(JsonNode title:newsflash){
                String t = title.get("title").asText();
                String name = title.get("column").get("name").asText();
                System.out.println("【"+name+"】"+t);
            }
        }

    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        News news = new News();
        String s = news.getNews();
//        System.out.println(s);
        news.getNewsTitle(s);
    }
}
