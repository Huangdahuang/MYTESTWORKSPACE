package cn.tedu.shoot;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Bee extends FlyingObject implements Award{
	private static BufferedImage[] images;
	static {
		images = new BufferedImage[5];
		for (int i = 0; i < images.length; i++) {
			images[i] = loadIamge("bee" + i + ".png");
		}
	}

	private int xSpeed;
	private int ySpeed;
	private int awardType;

	/** Bee的构造方法 */
	public Bee() {
		super(60, 50);
		xSpeed = 1;
		ySpeed = 2;
		awardType = new Random().nextInt(2);// 0,1两种奖励类型
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
			BufferedImage img = images[index++ % images.length];
			if (index == images.length) {
				state = REMOVE;
			}
			return img;
		}
		return null;
	}

	@Override
	public int getAwardType() {
		// TODO Auto-generated method stub
		return awardType;
	}
	
	

}
