package com.tz.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 
 * @ClassName
 * @Description
 * @author Zhihong_Huang
 * @Date 2017-9-7 下午8:51:10
 */
public class CopyOfDataUtil {
	/**
	 * @Description    获取网页数据的方法
	 * @param url      目标网址
	 * @param encoding 目标网址的编码
	 * @return
	 */
    public static String getHtmlResourceByUrl(String url,String encoding) throws Exception{
    	//1:建立网络连接
    	
			URL urlObj = new URL(url);   //建立网络连接
			HttpURLConnection uc = (HttpURLConnection) urlObj.openConnection();  //打开网络链接
			/**
			 * 拿网页的源码，下载到本地，输入输出流
			 * IO流
			 * 如何获取网页的源码?
			 */
			InputStream is = uc.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			StringBuilder sb = new StringBuilder();
			String line;
			while((line = br.readLine()) != null) {
				 line = line.replaceAll("</?a[^>]*>", "");
		           //这里是对样式进行处理
		         line = line.replaceAll("<(\\w+)[^>]*>", "<$1>");
		         sb.append(line);
			}
			is.close();
			br.close();
		
    	return new String(sb.toString().trim());
    }
	
	public static void main(String[] args) throws Exception{
		String home = getHtmlResourceByUrl("http://vacations.ctrip.com/tours/d-xiamen-21#ctm_ref=va_hom_s278_idx1_p0_l2_2.1_txt","utf-8");
		System.out.println(home);
     }
}
