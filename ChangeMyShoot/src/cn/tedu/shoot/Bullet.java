package cn.tedu.shoot;

import java.awt.image.BufferedImage;

public class Bullet extends FlyingObject {
	private static BufferedImage[] images;
	static {
		images = new BufferedImage[2];
		/*for (int i = 0; i < images.length; i++) {
			images[i] = loadIamge("bullet"+i+".png");
		}*/
		images[0] = loadIamge("img_bullet_pet_water.png").getSubimage(0, 0, 16, 32);
		images[1] = loadIamge("img_bullet_pet_fire.png").getSubimage(0, 0, 16, 32);
	}

	private int speed;

	/** Bullet的构造方法 */
	public Bullet(int x, int y) {
		super(16, 32, x, y);
		speed = 3;
	}

	@Override
	public void step() {
		y -= speed;
	}
	
	@Override
	public BufferedImage getImage() {
		if(Hero.changeBullet()){
			return images[1];
		}
		return images[0];
	}
	
	@Override
	public boolean outOfBounds() {
		return this.y <= -this.height;
	}
}
