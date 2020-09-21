package com.iebm.ssm.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CreateBigFile {
	
	
	/** 
	 * 创建固定大小的文件 
	 * @param file 
	 * @param length 字节单位 
	 * @throws IOException  
	 */  
	public static void createFixLengthFile(File file, long length) throws IOException{  
//	    long start = System.currentTimeMillis();  
	    FileOutputStream fos = null;  
	    FileChannel output = null;  
	    try {  
	        fos = new FileOutputStream(file);  
	        output = fos.getChannel();  
	        output.write(ByteBuffer.allocate(1), length-1);  
	    } finally {  
	        try {  
	            if (output != null) {  
	                output.close();  
	            }  
	            if (fos != null) {  
	                fos.close();  
	            }  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	    }  
//	    long end = System.currentTimeMillis();  
//	    System.out.println("total times "+(end-start));  
	}  
	
	
	
	private static void createFile(File file, long length) throws IOException {
        RandomAccessFile r = null;
        try {
            r = new RandomAccessFile(file, "rw");
            r.setLength(length);
        } finally {
            if (r != null) {
                r.close();
            }
        }
   }
	
	public static void main(String[] args) throws IOException {
//		CreateBigFile.createFile(new File("c:/test.docx"), 10*1024*1024);
		CreateBigFile.createFixLengthFile(new File("c:/test1.docx"), 10*1024*1024);
	}

}
