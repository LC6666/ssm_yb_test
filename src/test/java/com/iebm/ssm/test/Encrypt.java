package com.iebm.ssm.test;

import java.io.ByteArrayOutputStream;
import java.util.Properties;

import javax.crypto.Cipher;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.FactoryBean;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


/**
 * 
 * @ClassName: Encrypt 
 * @Description: 閺佺増宓佹惔鎾舵暏閹村嘲鎮曢崝鐘盒掔�碉拷
 * @author HuZongJian
 * @date 2013楠烇拷1閺堬拷閺冿拷娑撳宕�2:17:36 
 *
 */
public class Encrypt  implements FactoryBean<Object> {
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
			javax.crypto.SecretKey key = EncryptKey.loadKey();
			enCipher.init(1, key);
			result = enCipher.doFinal(needEncrypt.getBytes());
			BASE64Encoder base64Encoder = new BASE64Encoder();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			base64Encoder.encode(result, bos);
			result = bos.toByteArray();
		} catch (Exception e) {
			throw new IllegalStateException(
					"System doesn't support DES algorithm.");
		}
		return new String(result);
	}

	public String dCode(byte result[]) {
		String s = null;
		try {
			Cipher deCipher = Cipher.getInstance("DES");
			deCipher.init(2, EncryptKey.loadKey());
			BASE64Decoder base64Decoder = new BASE64Decoder();
			result = base64Decoder.decodeBuffer(new String(result));
			byte strByte[] = deCipher.doFinal(result);
			s = new String(strByte);
		} catch (Exception e) {
			throw new IllegalStateException(
					"System doesn't support DES algorithm.");
		}
		return s;
	}

	public static void main(String[] args) {
//		String s = "zzqbj_ssmmid";
//		String s = "ordos_ssm";
//		String s = "ssm_eeds";
//		String s = "ssm_new";
		// String s = "+LFyPEiaZxdV+Ir/vG8gkA=="
	     String s = "ebm83881021";
		String s1 = "jdbc:oracle:thin:@192.168.29.144:1521:orcl";
		//String s = "ulm_ssm";
		Encrypt p = new Encrypt();
		String afterE = p.eCode(s);
		System.out.println("after s:" + afterE);
		System.out.println("s1:" + p.eCode(s1));
		System.out.println(1);
		System.out.println("before:" + p.dCode("/WoSAA//pvYvv2QcudGpZQ==".getBytes()));
		System.out.println("before:" + p.dCode("MqhP4FEa0uAF7UfSFO44Xw==".getBytes()));
		System.out.println("before:" + p.dCode("Kbs2u6NELkMD+i6RnR+aSVshbAPcIa9Or5MUq0SHUFNNGguiRfIOeVX4iv+8byCQ".getBytes()));
		StringBuilder sb=new StringBuilder("72pc:");
		sb.appendCodePoint(72);
		System.out.println(sb.toString());
		//System.out.println('鐪�');
	}
	
	@Test
	public void test() {
//		String s = "zzqbj_ssmmid";
//		String s = "ordos_ssm";
//		String s = "ssm_eeds";
//		String s = "ssm_new";
		// String s = "+LFyPEiaZxdV+Ir/vG8gkA=="
//		String s = "ssm_bt_new";
//		String s = "tc_ssm_test";
	//	String s = "jdbc:oracle:thin:@192.168.29.171:1521:orcl";
		String s1 = " als_ssm";
		String s = "jdbc:oracle:thin:@192.168.29.171:1521:orcl";
		//String s = "ulm_ssm";
		Encrypt p = new Encrypt();
		String afterE = p.eCode(s);
		System.out.println("after:" + afterE);
		System.out.println("after:" + p.eCode(s1));
		System.out.println("before:" + p.dCode("pqODKd/CU1AF7UfSFO44Xw==".getBytes()));
		System.out.println("before:" + p.dCode("szCx9JW4gLiIFegxTyEfbA==".getBytes()));
		System.out.println("before:" + p.dCode("Kbs2u6NELkMD+i6RnR+aSQQSJDG9EpkVQpiEHUomAvG9BkQOdPdZGBgCtVrBwlQv".getBytes()));
		//System.out.println('鐪�');
	}
	
}
