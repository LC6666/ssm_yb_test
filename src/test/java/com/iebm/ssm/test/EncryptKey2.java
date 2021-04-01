package com.iebm.ssm.test;

import java.util.Base64;
import java.util.Base64.Decoder;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class EncryptKey2 {
	private static String encryptKey = "7EV/Zzutjzg=";
	public EncryptKey2() {}
	public static SecretKey loadKey() throws Exception {
		
		Decoder  base64Decoder = Base64.getDecoder();
//		BASE64Decoder base64Decoder = new BASE64Decoder();
		byte b[] = base64Decoder.decode(encryptKey);
		DESKeySpec desKeySpec = new DESKeySpec(b);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		return keyFactory.generateSecret(desKeySpec);
	}
}
