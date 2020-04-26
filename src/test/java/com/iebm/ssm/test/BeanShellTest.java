package com.iebm.ssm.test;
import java.math.BigDecimal;

/**
 * @Auther: LC
 * @Date: 2019/8/22 09:51
 * @Description:
 */

public class BeanShellTest {



    public void test(){
        String response = "123132";

//        Document doc = Jsoup.parseBodyFragment(response);
//        Elements titles = doc.getElementsByClass("layout_win_title");
//        String lastcheck = "sfsfsf";

        BigDecimal all_needCost_ = new BigDecimal("0");
        BigDecimal needCost_ = new BigDecimal("0");
        needCost_.add(needCost_);
        System.out.println(all_needCost_);

    }


    public static void main(String[] args) {
        BeanShellTest bs = new BeanShellTest();
        bs.test();
    }

}