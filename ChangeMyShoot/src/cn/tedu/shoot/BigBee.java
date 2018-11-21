package cn.tedu.shoot;

import java.awt.image.BufferedImage;
import java.util.Random;

public class BigBee extends FlyingObject implements Award{
	private static BufferedImage[] images;
	static {
		images = new BufferedImage[1];
		for (int i = 0; i < images.length; i++) {
			images[i] = loadIamge("SuperFireBox.png");
		}
	}

	private int xSpeed;
	private int ySpeed;
	private int awardType;

	/** Bee的构造方法 */
	public BigBee() {
		super(67, 77);
		xSpeed = 1;
		ySpeed = 2;
		awardType = 3;// 0,1两种奖励类型
	}

	@Override
	public void step() {
		x += xSpeed;
		y += ySpeed;
		if(x <= 0 || x >= World.WIDTH-this.width){
			xSpeed *= -1;
		}
	}

	int index = 1;
	@Override
	public BufferedImage getImage() {
		if (isLife()) {
			return images[0];
		} else if (isDead()) {
			
			return null;
		}
		return null;
	}

	@Override
	public int getAwardType() {
		// TODO Auto-generated method stub
		return awardType;
	}
	
	

}
