package com.iebm.ssm.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fasterxml.jackson.databind.util.JSONPObject;

public class ExcelUtil {
		
	/**
	 * 获取excel表所有sheet数据
	 * @param clz
	 * @param path
	 * @return
	 */
	public static <T> List<T> readExcel(Class<T> clz,String path){
//		System.out.println(path);
		if(null == path||"".equals(path)){
			return null;
		}
		InputStream is;
		Workbook xssfWorkbook;
		try {
			is = new FileInputStream(path);
			if(path.endsWith(".xls")){
				xssfWorkbook = new HSSFWorkbook(is);
			}else{
				xssfWorkbook = new XSSFWorkbook(is);
			}
			is.close();
			
			int sheetNumber = xssfWorkbook.getNumberOfNames();
			List<T> allData = new ArrayList<T>();
			
			for(int i = 0; i<sheetNumber;i++){
				allData.addAll(transToObject(clz, xssfWorkbook, xssfWorkbook.getSheetName(i)));
			}
			
			return allData;			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("转换excel文件失败："+e.getMessage());
		}
		
		
	}
	
	
	/**
	 * 获取excel表指定sheet表数据
	 * @param clz
	 * @param path
	 * @param sheetName
	 * @return
	 */
	public static <T> List<T> readExcel(Class<T> clz, String path, String sheetName) {
		// TODO Auto-generated method stub
//		Log.info("readExcel");
		if(null == path||"".equals(path)){
			return null;
		}
		InputStream is;
		Workbook xssfWorbook;
		
		try {
			is = new FileInputStream(path);
			if(path.endsWith(".xls")){
				xssfWorbook = new HSSFWorkbook(is);
			}else{
				xssfWorbook = new XSSFWorkbook(is);
			}
			is.close();
			return transToObject(clz, xssfWorbook, sheetName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("转换excel文件失败："+e.getMessage());
		}
		
	}

	
	
	
	private static <T> List<T> transToObject(Class<T> clz,Workbook xssfWorkbook,String sheetName){
		
		List<T> list = new ArrayList<T>();
		Sheet xssfSheet = xssfWorkbook.getSheet(sheetName);
		Row firstRow = xssfSheet.getRow(0);
		if(null == firstRow){
			return list;
		}
		List<Object> heads = getRow(firstRow);
//		添加sheetName字段，用于封装至bean中，与bean中的字段相匹配。
		heads.add("sheetName");
		Map<String,Method> headMethod = getSetMethod(clz,heads);
		for(int rowNum = 1;rowNum<=xssfSheet.getLastRowNum();rowNum++){
			Row xssfRow = xssfSheet.getRow(rowNum);
			if(xssfRow == null){
				continue;
			}
			try {
				T t = clz.newInstance();
				List<Object> data = getRow(xssfRow);
				while(data.size()+1<heads.size()){
					data.add("");
				}
				data.add(sheetName);
				setValue(t,data,heads,headMethod);
				list.add(t);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return list;		
	}
	
	
	private static void setValue(Object obj,List<Object> data,List<Object> heads,Map<String,Method> methods) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
//		Log.info("setValue");
		for(Map.Entry<String, Method> entry:methods.entrySet()){
			Object value = "";
			int dataIndex = heads.indexOf(entry.getKey());
			if(dataIndex < data.size()){
				value = data.get(heads.indexOf(entry.getKey()));
			}
			Method method = entry.getValue();
			Class<?> param = method.getParameterTypes()[0];
			if(String.class.equals(param)){
				method.invoke(obj, value);
			}else if(Integer.class.equals(param)||int.class.equals(param)){
				if(value.toString()==""){
					value=0;
				}
				method.invoke(obj, new BigDecimal(value.toString()).intValue());
			}else if(Long.class.equals(param)||long.class.equals(param)){
				if(value.toString()==""){
					value=0;
				}
				method.invoke(obj, new BigDecimal(value.toString()).longValue());
			}else if(Short.class.equals(param)||short.class.equals(param)){
				if(value.toString()==""){
					value=0;
				}
				method.invoke(obj, new BigDecimal(value.toString()).shortValue());
			}else if(Boolean.class.equals(param)||boolean.class.equals(param)){
				method.invoke(obj, Boolean.class.equals(value.toString())||value.toString().toLowerCase().equals("y"));
			}else if(JSONPObject.class.equals(param)){
//				method.invoke(obj, JSONObject.parseObject(value.toString()));
			}else{
				method.invoke(obj, value);
			}
			
		}
	}


	private static Map<String, Method> getSetMethod(Class<?> clz, List<Object> heads) {
		// TODO Auto-generated method stub
		Map<String,Method> map = new HashMap<String,Method>();
		Method[] methods = clz.getMethods();
		for(Object head:heads){
			for(Method method:methods){
				if(method.getName().toLowerCase().equals("set"+head.toString().toLowerCase())&&method.getParameterTypes().length == 1){
					map.put(head.toString(), method);
					break;
				}
			}
		}
		return map;
	}



	public static List<Object> getRow(Row xssfRow){
		List<Object> cells = new ArrayList<Object>();
		if(xssfRow != null){
			for(short cellNum = 0;cellNum < xssfRow.getLastCellNum();cellNum++){
				Cell xssfCell = xssfRow.getCell(cellNum);
				cells.add(getValue(xssfCell));
			}
		}
		return cells;
	}
	
	public static String getValue(Cell cell){
		if(null == cell){
			return "";
		}else if(cell.getCellType() == CellType.BOOLEAN){
//			返回布尔类型的值
			return String.valueOf(cell.getBooleanCellValue());
		}else if(cell.getCellType() == CellType.NUMERIC){
//			返回数值型的值
			return String.valueOf(cell.getNumericCellValue());
		}else {
//			返回字符串类型的值
			return String.valueOf(cell.getStringCellValue());
		}
		
		
	}



	

}
