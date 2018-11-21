package cn.tedu.shoot;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

//����������ӵ�й�ͬ������width,height,x,y,�Լ�����step(),������ͬ����
public abstract class FlyingObject {
	public static final int LIFE = 0;
	public static final int DEAD = 1;
	public static final int REMOVE = 2;
	protected int state = LIFE;

	protected int width;
	protected int height;
	protected int x;
	protected int y;

	/** Ϊbullet,hero,sky�ṩ���๹�췽�� */
	public FlyingObject(int width, int height, int x, int y) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}

	/** Airplane,BigAirplane,Bee���������ṩ���췽�� */
	public FlyingObject(int width, int height) {
		this.width = width;
		this.height = height;
		Random rand = new Random();
		x = rand.nextInt(World.WIDTH - this.width);
		y = -this.height;
//		y=0;
	}

	/** ��ȡͼƬ */
	public static BufferedImage loadIamge(String fileName) {
		try {
			BufferedImage img = ImageIO.read(FlyingObject.class.getResource(fileName));
			return img;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	/** �ƶ��л�ͼƬ */
	public abstract void step();

	/** getImage()��ȡͼƬ */
	public abstract BufferedImage getImage();

	/** ���� */
	public boolean isLife() {
		return state == LIFE;
	}

	/** ���� */
	public boolean isDead() {
		return state == DEAD;
	}

	/** �Ƴ� */
	public boolean isRemove() {
		return state == REMOVE;
	}

	/** ������ */
	public void paintObject(Graphics g) {
		g.drawImage(getImage(), x, y, null);
	}
	
	/**Խ���ж�.���ڵ��˺��ӵ�����Խ��,������Խ�粻ͬ,����ж�س�����,�������д,*/
	public boolean outOfBounds(){
		return this.y >= World.HEIGHT;
	}
	
	/**ײ��*/
	public boolean hit(FlyingObject other){
		int x1 = this.x - other.width;
		int x2 = this.x + this.width;
		int y1 = this.y - other.height;
		int y2 = this.y + this.height;
		int x = other.x;
		int y = other.y;
		return x >= x1 && x <= x2 
				&&
				y >= y1 && y <= y2;
	}
	
	public void goDead(){
		state = DEAD;
	}
	
	
}
