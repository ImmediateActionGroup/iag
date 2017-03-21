package com.iag.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * the security tools
 * @author xueshan.wei
 *
 */
public class SecurityTools {

	/**
	 * md5 encryption
	 * @param str The string need to encryption
	 * @return 
	 */
	public static String toMd5(String str){
		try {  
            MessageDigest md = MessageDigest.getInstance("MD5");  
            md.update(str.getBytes());  
            byte b[] = md.digest();  

            int i;  

            StringBuffer buf = new StringBuffer("");  
            for (int offset = 0; offset < b.length; offset++) {  
                i = b[offset];  
                if (i < 0)  
                    i += 256;  
                if (i < 16)  
                    buf.append("0");  
                buf.append(Integer.toHexString(i));  
            }  
            //32bit encryption 
            return buf.toString();  
            // 16 bit encryption
            //return buf.toString().substring(8, 24);  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
            return null;  
        }  
	}
}
