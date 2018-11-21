package com.itheima.ws.cxf.server;

import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;


/**
 * 
 * <p>WeatherInterface.java</p>
 * @author ZhiHong_Huang
 * @Date   2017-9-3
 */
@WebService
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public interface WeatherInterface {
	
	public String queryWeather(String cityName);
	
}
