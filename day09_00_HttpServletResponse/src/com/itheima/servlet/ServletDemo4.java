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
 * ����һ����֤��ͼƬ
 * 
 * */
public class ServletDemo4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//test1(response);
		//��֪�ͻ��˲�����
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setDateHeader("expires", 0);
		
		ValidateCode vc = new ValidateCode(110, 25, 4, 9);
		vc.write(response.getOutputStream());
	}

	private void test1(HttpServletResponse response) throws IOException {
		//���ڴ��д���һ��ͼ�����
		int width = 110;
		int height = 25;
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		//����һ������
		Graphics g = img.getGraphics();
		
		//��ͼƬ��ӱ���ɫ
		g.setColor(Color.PINK);
		g.fillRect(1, 1, width-2, height-2);
		
		//���߿�һ����ɫ
		g.setColor(Color.RED);
		g.drawRect(0, 0, width-1, height-1);
		
		//�����ı���ʽ
		g.setColor(Color.BLUE);
		g.setFont(new Font("����", Font.BOLD|Font.ITALIC, 15));
		
		//��ͼƬ����ı�
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
		
		//��Ӿ���������
		g.setColor(Color.BLACK);
		for(int i = 1; i <= 9 ; i++) {
			g.drawLine(rand.nextInt(width), rand.nextInt(height), rand.nextInt(width), rand.nextInt(height));
		}
		
		//��ͼƬ���������ķ�ʽ������ͻ��ˣ���ҳ��
		ImageIO.write(img, "jpg", response.getOutputStream());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
