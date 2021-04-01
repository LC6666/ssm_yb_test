package com.iebm.ssm.test;

import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Properties;

import javax.crypto.Cipher;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author LC
 * 适用于JDK1.8以上的加解密处理
 *
 */
public class Encrypt2 implements FactoryBean<Object>  {
	private static final Log logger = LogFactory.getLog(Encrypt.class);
	private Properties properties;

	public Object getObject() throws Exception {
		return getProperties();
	}

	public Class<Properties> getObjectType() {
		return java.util.Properties.class;
	}

	public boolean isSingleton() {
		return true;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties inProperties) {
		this.properties = inProperties;
		String originalUsername = properties.getProperty("user");
		String originalPassword = properties.getProperty("password");
		if (originalUsername != null) {
			String newUsername = deEncryptUsername(originalUsername);
			properties.put("user", newUsername);
		}
		if (originalPassword != null) {
			String newPassword = deEncryptPassword(originalPassword);
			properties.put("password", newPassword);
		}
	}

	private String deEncryptUsername(String originalUsername) {
		return dCode(originalUsername.getBytes());
	}

	private String deEncryptPassword(String originalPassword) {
		return dCode(originalPassword.getBytes());
	}

	public String eCode(String needEncrypt) {
		
		byte result[] = null;
		try {
			Cipher enCipher = Cipher.getInstance("DES");
			javax.crypto.SecretKey key = EncryptKey2.loadKey();
			enCipher.init(1, key);
			result = enCipher.doFinal(needEncrypt.getBytes());
			Base64.Encoder base64Encoder = Base64.getEncoder();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			result = base64Encoder.encode(result);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
//			throw new IllegalStateException(
//					"System doesn't support DES algorithm.");
		}
		return new String(result);
	}

	public String dCode(byte result[]) {
		String s = null;
		try {
			Cipher deCipher = Cipher.getInstance("DES");
			deCipher.init(2, EncryptKey2.loadKey());
//			Decoder  base64Decoder = Base64.getDecoder();
//			result = base64Decoder.decode(result);
			
			result = Base64.getDecoder().decode(result);
			byte strByte[] = deCipher.doFinal(result);
			s = new String(strByte);
			
//			byte[] b64UrlDe = Base64.getUrlDecoder().decode(result);
//			s= new String(b64UrlDe, "utf-8");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new IllegalStateException(	"System doesn't support DES algorithm.");
			
		}
		return s;
	}

	public static void main(String[] args) {
		Encrypt2 p = new Encrypt2();
		System.out.println(p.eCode("als_ssm"));
		System.out.println(p.dCode("Kbs2u6NELkMD+i6RnR+aSQQSJDG9EpkVU2T3JdyYNtG9BkQOdPdZGBgCtVrBwlQv".getBytes()));
		
		System.out.println(p.dCode("Kbs2u6NELkMD+i6RnR+aSQQSJDG9EpkV0fr8q0E8yBBqZ6DOxTfkgJyuN8CSuxrZ".getBytes()));
		
		System.out.println(p.dCode("saRx0Us3Xacvv2QcudGpZQ==".getBytes()));
		
		
		
		
	}
	
	
}
