package com.iebm.ssm.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/*
 *TODO 从EXCEL读取数据测试
 *Administrator
 *上午11:17:23
 */

public class TestDataDrivenByExcelFile {

    /**
     *
     * 功能描述: 读取数据
     *
     * @param: 文件路径，文件名，sheet页名
     * @return:
     * @auther: LC
     * @date: 2019/3/7 10:42
     */
    public static Object[][] getDataFromXlxs(String filePath,String fileName,String sheetName) throws IOException {
//      根据参数传入的数据文件路径和文件名称，组合出excel数据文件的绝对路径
//      声明一个File文件对象
        File file = new File(filePath+"\\"+fileName);
//      创建FileInputStream对象用于读取Excel文件
        FileInputStream inputStream = new FileInputStream(file);
//      声明Workbook对象
        Workbook workbook = null;
//      获取文件名参数的扩展名，判断是.xlsx文件还是.xls文件
        String fileExtensionName = fileName.substring(fileName.indexOf("."));
//      判断文件类型如果是.xlsx，则使用XSSFWorkbook对象进行实例化
//      判断文件类型如果是.xls，则使用SSFWorkbook对象进行实例化
        if(fileExtensionName.equals(".xlsx")){
            workbook = new XSSFWorkbook(inputStream);

        }else if(fileExtensionName.equals(".xls")){
            workbook = new HSSFWorkbook(inputStream);
        }

//       通过sheetName参数，生成sheet对象
        Sheet sheet = workbook.getSheet(sheetName);
//      获取Excel数据文件Sheet1中数据的行数，getLastRowNum方法获取数据的最后一行行号
//      getFirstRowNum方法获取数据的第一行行号，相减之后算出数据的行数
//      注意：excel文件的行号和列号都是从0开始的
        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
//      创建名为records的list对象来存储从excel数据文件读取的数据
        List<Object[]> records = new ArrayList<Object[]>();
//      使用两个for循环遍历excel数据文件的所有数据（除了第一行，第一行是数据列名称）所以i从1开始，而不是从0开始
        for(int i=1;i<=rowCount;i++){
//          使用getrow方法获取row对象
            Row row = sheet.getRow(i);
//          声明一个数组，用来存储excel数据文件第i行中的几个数据，数组的大小用getLastCellNum办法来进行动态声明，实现测试数据个数和数组大小相一致
            String fields[] = new String[row.getLastCellNum()];
            for(int j=0;j<row.getLastCellNum();j++){
               fields[j] = row.getCell(j)==null?"":row.getCell(j).getStringCellValue();
            }
//          将fields的数据对象存储到records的list中
            records.add(fields);
        }
//      定义函数返回值，即Object[][]，将存储测试数据的list转换为一个Object的二维数组
        Object[][] results = new Object[records.size()][];
//      设置二维数组每行的值，每行是一个Object对象
        for(int i=0;i<records.size();i++){
            results[i] = records.get(i);

        }
        return results;
    }

}


