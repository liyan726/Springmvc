package com.springmvc.others;

import java.io.UnsupportedEncodingException;

/**
 *  编码设置util
 * @author shitou.li
 * 2014年11月21日 下午3:36:52
 */
public class Encord {
   public static String Utf8Change(String name) throws UnsupportedEncodingException{
	   
	   byte bb[];
       bb = name.getBytes("ISO-8859-1"); //以"ISO-8859-1"方式解析name字符串
       name= new String(bb, "UTF-8"); 
       return name;
   }
}
