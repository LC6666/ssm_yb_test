package com.iebm.ssm.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import java.io.*;
import java.util.List;

public class JsoupTest {

    public String ReadFile(){
        String txt="";
        try {
            File file = new File("./resource/html.txt");
//          要读取的input txt文件 建立一个输入流对象reader
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
//          建立一个对象，它把文件内容转成计算机能读懂的语言
            BufferedReader br = new BufferedReader(reader);

            try {
                String line="";
                line = br.readLine();
                while ((line = br.readLine()) != null){
//              一次读入一行数据
                    txt +=line;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return txt;
    }



    public static void main(String[] args) {
        String str = new JsoupTest().ReadFile();
        Document doc = Jsoup.parseBodyFragment(str);


    }


}
