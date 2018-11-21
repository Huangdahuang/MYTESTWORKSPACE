package cn.tedu.shoot;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Lightning extends FlyingObject{
	private static BufferedImage[] images;
	static {
		images = new BufferedImage[5];
		for (int i = 0; i < images.length; i++) {
			images[i] = loadIamge("wsparticle_superlight0"+i+".png");
		}
	}
	public Lightning() {
		super(256, 256);
		x = new Random().nextInt(World.WIDTH);
		y = new Random().nextInt(World.HEIGHT);
	}

	@Override
	public void step() {

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


}
