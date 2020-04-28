package com.iebm.ssm.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 文件通用类
 * @author LC
 *
 */
public class FileUtil {
	
	
	/**
	 * 多个匹配条件匹配文件（去重）
	 * @param dir
	 * @param fileConf
	 * @return
	 */
	public static List<File>  getFilesByConf(String dir,String fileConf){
//		 多个配置‘;’分开
		String[] fileConfArr = fileConf.split(";");
		
		List<File> list = new ArrayList<File>();
		if(fileConfArr !=null && fileConfArr.length>0) {
			for(String conftemp:fileConfArr) {
				int at = conftemp.lastIndexOf("/");
				File file = null;
				String fileContextPath = "";
//				绝对目录路径
				String contextPath = dir;
				if(at>0) {
					fileContextPath = fileConf.substring(0, at);
				}
				if(StringUtil.isNotEmpty(fileContextPath)) {
					contextPath = contextPath+fileContextPath;
				}
				file = new File(contextPath);
				String fileNameConf = conftemp.substring(at+1,conftemp.length());
				String fileConfTemp = generatePattern(fileNameConf);
				System.out.println("FileUtil getFilesByConf fileConfTemp="+fileConfTemp);
				
				Pattern p = Pattern.compile(fileConfTemp);
				ArrayList<File> listtemp = filePattern(file,p);
				list.addAll(listtemp);
			}
		}
		
		return null;
		
	}

	
	/**
	 * 根据正则匹配正确的文件
	 * @param file
	 * @param p
	 * @return
	 */
	private static ArrayList<File> filePattern(File file, Pattern p) {
		// TODO Auto-generated method stub
		if(file == null) {
			return null;
		}
//		 如果是文件
		if(file.isFile()) {
			Matcher fMatcher = p.matcher(file.getName());
			if(fMatcher.matches()) {
				ArrayList<File> list = new ArrayList<File>();
				list.add(file);
				return list;
			}
//			如果是目录
		}else if(file.isDirectory()) {
			File[] files = file.listFiles();
			if(files !=null && files.length>0) {
				ArrayList<File> list = new ArrayList<File>();
				for(File f:files) {
					ArrayList<File> rlist = filePattern(f,p);
					if(rlist !=null) {
						list.addAll(rlist);
					}
				}
				return list;
			}
		}
		
		return null;
	}


	/**
	 * 根据配置生成正确的正则
	 * @param fileNameConf
	 * @return
	 */
	private static String generatePattern(String fileNameConf) {
		// TODO Auto-generated method stub
		fileNameConf = fileNameConf.trim();
//		根据配置生成正确的正则
		fileNameConf = fileNameConf.replace('*', '#');
//		将*号之前加上.
		fileNameConf = fileNameConf.replaceAll("#", ".*");
		return fileNameConf;
	}
	
	
	
	/**
	 * @param is
	 * @param filePath
	 * @return
	 */
	public static boolean writeFile(InputStream is,String filePath) {
		File file = new File(filePath);
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		FileOutputStream fileout;
		try {
			fileout = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	
//		根据实际运行效果 设置缓冲区大小
		byte[] buffer = new byte[10*1024];
		int ch = 0;
		try {
			while((ch = is.read(buffer)) !=-1) {
				fileout.write(buffer,0,ch);
			}
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			try {
				is.close();
				fileout.flush();
				fileout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
	}

}
