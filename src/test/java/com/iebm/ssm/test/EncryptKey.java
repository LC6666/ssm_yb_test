package com.iebm.ssm.test;

import java.util.Base64;
import java.util.Base64.Decoder;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
import sun.misc.BASE64Decoder;
 import sun.misc.BASE64Decoder;
 */

/**
 * 
 * @ClassName: EncryptKey
 * @Description: 加解密key
 * @author HuZongJian
 * @date 2013年11月8日 下午1:59:53
 * 
 */
public class EncryptKey {
	private static String encryptKey = "7EV/Zzutjzg=";
	public EncryptKey() {}
	public static SecretKey loadKey() throws Exception {
		
//		BASE64Decoder base64Decoder = new BASE64Decoder();
//		byte b[] = base64Decoder.decodeBuffer(encryptKey);
//		DESKeySpec desKeySpec = new DESKeySpec(b);
//		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
//		return keyFactory.generateSecret(desKeySpec);
		return null;
		
		
	
	}
}
