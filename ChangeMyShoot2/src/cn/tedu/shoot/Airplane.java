package cn.tedu.shoot;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Airplane extends FlyingObject implements Enemy{
	private static BufferedImage[] images;
	static {
		images = new BufferedImage[11];
		for (int i = 0; i < images.length; i++) {
			images[i] = loadIamge("airplane" + i + ".png");
		}
	}
	private int speed;
	private int num;

	/** Airplane的构造方法 */
	public Airplane(int num) {
		super(69, 99);
		speed = 2;
		this.num = num;
	}

	@Override
	public void step() {
		y += speed;
	}

	int index = 5;
	@Override
	public BufferedImage getImage() {
		if (isLife()) {
			return images[num];
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
		return 1;
	}

}
