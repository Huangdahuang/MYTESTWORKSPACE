package cn.tedu.shoot;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.Random;

public class BigAirplane extends FlyingObject implements Enemy {
	private static BufferedImage[] images;
	static {
		images = new BufferedImage[5];
		for (int i = 0; i < images.length; i++) {
			if (i == 0) {
				// Image Itemp = loadIamge("bigplane" + i +
				// ".png").getScaledInstance(69, 95, loadIamge("bigplane" + i +
				// ".png").SCALE_SMOOTH);//设置缩放目标图片模板
				/*
				 * new AffineTransformOp(AffineTransform.getScaleInstance(69 *
				 * 1.0 / 256, 95 * 1.0 /256), null). filter(loadIamge("bigplane"
				 * + i + ".png"), null);
				 */
				images[i] = new AffineTransformOp(AffineTransform.getScaleInstance(69 * 1.0 / 256, 95 * 1.0 / 256),
						null).filter(loadIamge("bigplane" + i + ".png"), null);
			}
			images[i] = loadIamge("bigplane" + i + ".png");
		}
	}

	private int speed;
	private int xSpeed;

	/** BigAirplane的构造方法 */
	public BigAirplane() {
		super(127, 121);
		speed = 2;
		xSpeed = 4;
	}

	@Override
	public void step() {
		y += speed;
		if (new Random().nextInt(100) < 50) {
			if (x <= 0 || x >= World.WIDTH - this.width) {
				xSpeed *= -1;
			}
			x += xSpeed;
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
	public int getScore() {
		// TODO Auto-generated method stub
		return 3;
	}

	/* 大敌机产生子弹 */

	/** shoot产生子弹 */
	public EmemyBullet[] shoot() {
		int xStep = 127 / 6;
		int yStep = 120;
		EmemyBullet[] bs = new EmemyBullet[3];
		bs[0] = new EmemyBullet(x + 1 * xStep, y + yStep);
		bs[1] = new EmemyBullet(x + 3 * xStep, y + yStep);
		bs[2] = new EmemyBullet(x + 5 * xStep, y + yStep);
		return bs;
	}
}
