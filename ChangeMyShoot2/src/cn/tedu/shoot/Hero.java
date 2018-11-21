package cn.tedu.shoot;

import java.awt.image.BufferedImage;

public class Hero extends FlyingObject {
	private static BufferedImage[] images;
	static {
		images = new BufferedImage[2];
		for (int i = 0; i < images.length; i++) {
			images[i] = loadIamge("hero" + i + ".png");
		}
	}

	// 宽、高、X,Y，命、火力，速度
	private int life;
	private static int doubleFires;
	private int health = 100;

	/** Hero的构造方法 */
	public Hero() {
		super(128, 128, 200, 450);
		life = 3;
		doubleFires = 0;
	}

	// 跟随鼠标移动
	public void moveTo(int x, int y) {
		this.x = x - this.width / 2;
		this.y = y - this.height / 2;
	}

	@Override
	public void step() {
	}

	int index = 0;

	@Override
	public BufferedImage getImage() {
		if (isLife()) {
			BufferedImage img = images[index++ % images.length];
			return img;
		}
		return null;
	}

	/** shoot产生子弹 */
	public Bullet[] shoot() {
		int xStep = this.width / 6;
		int yStep = 20;
		if (doubleFires > 80) {
			Bullet[] bs = new Bullet[3];
			bs[0] = new Bullet(this.x + 1 * xStep, this.y - yStep);
			bs[1] = new Bullet(this.x + 3 * xStep, this.y + yStep);
			bs[2] = new Bullet(this.x + 5 * xStep, this.y + yStep);
			doubleFires -= 6;
			return bs;
		} else if (doubleFires > 40) {
			Bullet[] bs = new Bullet[2];
			bs[0] = new Bullet(this.x + 2 * xStep, this.y - yStep);
			bs[1] = new Bullet(this.x + 4 * xStep, this.y + yStep);
			doubleFires -= 2;
			return bs;
		} else {
			Bullet[] bs = new Bullet[1];
			bs[0] = new Bullet(this.x + 3 * xStep, this.y - yStep);
			return bs;
		}
	}

	public void addLife() {
		life++;
	}

	public void reduceLife(){
		life--;
	}
	
	public void addFire() {
		doubleFires += 40;
	}

	public int getLife() {
		// TODO Auto-generated method stub
		return life;
	}

	public int getFire() {
		// TODO Auto-generated method stub
		return doubleFires;
	}

	public void substractLife() {
		life--;
	}

	public void clearDoubleFire() {
		doubleFires = 0;
	}

	public static boolean changeBullet() {
		if (doubleFires > 80) {
			return true;
		}
		return false;
	}

	public static int getSumFire(){
		return doubleFires;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public void substractHealth() {
		health-=2;
	}
	
}
