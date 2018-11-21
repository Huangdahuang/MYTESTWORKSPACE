package cn.tedu.shoot;

import java.awt.image.BufferedImage;
import java.util.Random;

import javax.lang.model.type.PrimitiveType;

public class BoosAirplane extends FlyingObject implements Enemy{
	private static BufferedImage[] images;
	static {
		images = new BufferedImage[9];
		for (int i = 0; i < images.length; i++) {
			images[i] = loadIamge("boos" + i + ".png");
		}
	}
	private int speed;
	private int life;
	/** Airplane的构造方法 */
	public BoosAirplane() {
		super(300, 200);
		speed = 2;
		life = 5000;
		x = 10;
	}

	@Override
	public void step() {
		if(new Random().nextInt(10) > 6)
			y += speed;
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
	public int getScore() {
		// TODO Auto-generated method stub
		return 50;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	
	
}
