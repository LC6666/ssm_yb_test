package com.iebm.ssm.util;


import java.io.*;
import java.util.ArrayList;
import java.util.List;



/*
 *TODO 从CSV读取数据测试
 *Administrator
 *上午11:17:23
 */
public class TestDataDrivenByCSVFile {


    public static Object[][] getTestData(String filename) throws IOException {
        List<Object[]> records = new ArrayList<>();
        String record;
//      设定UTF-8字符集，使用带缓冲区的字符输入流BufferedReader读取文件内容
//        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));
        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(new File("./case"+"\\"+filename)), "UTF-8"));
//      
//      忽略读取CSV文件的标题行（第一行）
        file.readLine();
//      遍历读取文件中除第一行以外的其他所有行内容并存储在名为records的ArrayList中，第个recods中存储的对象为一个String数组
        while ((record=file.readLine())!=null){
            String fields[] = record.split(",");
            records.add(fields);
        }
//        关闭文件对象
        file.close();

//      定义函数返回值，即object[][]
//      将存储测试数据的list转换为一个object的二维数组
        Object[][] results = new Object[records.size()][];
//      设置二维数组每行的值，每行是一个object对象
        for (int i=0;i<records.size();i++){
            results[i] = records.get(i);
//            System.out.println(results[i]);
        }

        return results;

    }



}
