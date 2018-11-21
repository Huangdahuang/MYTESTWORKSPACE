package cn.tedu.shoot;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

//根据六个类拥有共同的属性width,height,x,y,以及方法step(),创建共同父类
public abstract class FlyingObject {
	public static final int LIFE = 0;
	public static final int DEAD = 1;
	public static final int REMOVE = 2;
	protected int state = LIFE;

	protected int width;
	protected int height;
	protected int x;
	protected int y;

	/** 为bullet,hero,sky提供父类构造方法 */
	public FlyingObject(int width, int height, int x, int y) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}

	/** Airplane,BigAirplane,Bee这三个类提供构造方法 */
	public FlyingObject(int width, int height) {
		this.width = width;
		this.height = height;
		Random rand = new Random();
		x = rand.nextInt(World.WIDTH - this.width);
		y = -this.height;
//		y=0;
	}

	/** 读取图片 */
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

	/** 移动切换图片 */
	public abstract void step();

	/** getImage()获取图片 */
	public abstract BufferedImage getImage();

	/** 活着 */
	public boolean isLife() {
		return state == LIFE;
	}

	/** 死亡 */
	public boolean isDead() {
		return state == DEAD;
	}

	/** 移除 */
	public boolean isRemove() {
		return state == REMOVE;
	}

	/** 画对象 */
	public void paintObject(Graphics g) {
		g.drawImage(getImage(), x, y, null);
	}
	
	/**越界判断.对于敌人和子弹都有越界,但两者越界不同,将其卸载超类中,子类可重写,*/
	public boolean outOfBounds(){
		return this.y >= World.HEIGHT;
	}
	
	/**撞击*/
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
