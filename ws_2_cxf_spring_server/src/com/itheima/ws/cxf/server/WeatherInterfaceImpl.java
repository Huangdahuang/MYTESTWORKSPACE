package com.itheima.ws.cxf.server;
/**
 * 
 * <p>WeatherInterfaceImpl.java</p>
 * @author ZhiHong_Huang
 * @Date   2017-9-3
 */
public class WeatherInterfaceImpl implements WeatherInterface {

	@Override
	public String queryWeather(String cityName) {
		System.out.println("from client..."+cityName);
		if("����".equals(cityName)){
			return "������";
		} else {
			return "ů����";
		}
	}

}
