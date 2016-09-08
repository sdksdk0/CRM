package cn.tf.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	
	public static String getMD5Value(String value){
		if(value==null){
			return null;
		}
		
		try {
			MessageDigest instance = MessageDigest.getInstance("MD5");
			
			byte[] md5ValueByTeArray=instance.digest(value.getBytes());
			
			BigInteger bigInteger=new BigInteger(1,md5ValueByTeArray);		
			return bigInteger.toString(16);
		
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return value;
		}	
	}
}
