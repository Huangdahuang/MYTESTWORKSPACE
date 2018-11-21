package com.itheima.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dsna.util.images.ValidateCode;
/**
 * 产生一个验证码图片
 * 
 * */
public class ServletDemo4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//test1(response);
		//告知客户端不缓存
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setDateHeader("expires", 0);
		
		ValidateCode vc = new ValidateCode(110, 25, 4, 9);
		vc.write(response.getOutputStream());
	}

	private void test1(HttpServletResponse response) throws IOException {
		//在内存中创建一个图像对象
		int width = 110;
		int height = 25;
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		//创建一个画笔
		Graphics g = img.getGraphics();
		
		//给图片添加背景色
		g.setColor(Color.PINK);
		g.fillRect(1, 1, width-2, height-2);
		
		//给边框一个颜色
		g.setColor(Color.RED);
		g.drawRect(0, 0, width-1, height-1);
		
		//设置文本样式
		g.setColor(Color.BLUE);
		g.setFont(new Font("宋体", Font.BOLD|Font.ITALIC, 15));
		
		//给图片添加文本
		Random rand = new Random();
		int position = 20;
		for(int i = 1;i <= 4;i++) {
			g.drawString(rand.nextInt(10)+"", position, 20);
			position+=20;
		}
		/*g.drawString(rand.nextInt(10)+"", 20, 20);
		g.drawString(rand.nextInt(10)+"", 40, 20);
		g.drawString(rand.nextInt(10)+"", 60, 20);
		g.drawString(rand.nextInt(10)+"", 80, 20);*/
		
		//添加九条干扰线
		g.setColor(Color.BLACK);
		for(int i = 1; i <= 9 ; i++) {
			g.drawLine(rand.nextInt(width), rand.nextInt(height), rand.nextInt(width), rand.nextInt(height));
		}
		
		//将图片对象以流的方式输出到客户端（网页）
		ImageIO.write(img, "jpg", response.getOutputStream());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
