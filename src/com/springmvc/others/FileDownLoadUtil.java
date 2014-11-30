package com.springmvc.others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shitou.li
 * 2014年11月21日 下午3:41:11
 */
public class FileDownLoadUtil {
	
	/**
	 * 
	 *传入文件名称、文件类型、文件路径信息对文件进行下载
	 * @param filename
	 * @param suffix
	 * @param ctxPath
	 * @param request
	 * @param response
	 * @throws Exception
	 * @auth:shitou.li
	 * 2014年11月21日 下午3:45:00
	 *
	 */
    public static void fileDownload(String filename,String suffix,String ctxPath,HttpServletRequest request, HttpServletResponse response) throws Exception{
    	
    	 response.setContentType("text/html;charset=utf-8");  
         request.setCharacterEncoding("UTF-8");  
         java.io.BufferedInputStream bis = null;  
         java.io.BufferedOutputStream bos = null;  
   
     
         String downLoadPath = ctxPath + filename+suffix;  
         try {  
             long fileLength = new File(downLoadPath).length();  
             response.setContentType("application/x-msdownload;");  
             response.setHeader("Content-disposition", "attachment; filename="  
                     + new String(filename.getBytes("utf-8"), "ISO8859-1"));  
             response.setHeader("Content-Length", String.valueOf(fileLength));  
             bis = new BufferedInputStream(new FileInputStream(downLoadPath));  
             bos = new BufferedOutputStream(response.getOutputStream());  
             byte[] buff = new byte[2048];  
             int bytesRead;  
             while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
                 bos.write(buff, 0, bytesRead);  
             }  
         } catch (Exception e) {  
             e.printStackTrace();  
         } finally {  
             if (bis != null)  
                 bis.close();  
             if (bos != null)  
                 bos.close();  
         }  
    }
}
