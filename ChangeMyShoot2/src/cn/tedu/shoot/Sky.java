package cn.tedu.shoot;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Sky extends FlyingObject {
	private static BufferedImage[] images;
	static {
		images = new BufferedImage[2];
		for (int i = 0; i < images.length; i++) {
			images[i] = loadIamge("background"+i+".jpg");
		}
	}
	
	private int speed;
	private int y1;// �ڶ���ͼƬ
	private int y2;// �ڶ���ͼƬ
	private int y3;// �ڶ���ͼƬ
	private int bgNum =0;

	/** Sky�Ĺ��췽�� */
	public Sky() {
		super(World.WIDTH, World.HEIGHT, 0, 0);
		y1 = -World.HEIGHT;
		speed = 1;
	}
	@Override
	public void step() {
		y += speed;
		y1 += speed;
		if(y >= World.HEIGHT){
			y = -World.HEIGHT;
		}
		if(y1 >= World.HEIGHT){
			y1 = -World.HEIGHT;
		}
	}
	@Override
	public BufferedImage getImage() {
		return images[bgNum];
	}
	
	
	public int getBgNum() {
		return bgNum;
	}
	public void setBgNum(int bgNum) {
		this.bgNum = bgNum;
	}
	/**��Ҫ���������/*/
	public void paintObject(Graphics g) {
		g.drawImage(getImage(), x, y, null);
		g.drawImage(getImage(), x, y1, null);
	}
	
}
