package cn.tedu.shoot;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.security.KeyStore.PrivateKeyEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class World extends JPanel {
	
	private static JFrame frame;
	private static int xLocation = 100;
	private static int yLocation = 0;
	public static final int WIDTH = 512;
	//public static final int HEIGHT = 512;
	public static final int HEIGHT = 1024;
	//public static final int WIDTH = 800;
	//public static final int HEIGHT = 1080;

	public static final int START = 0;// 启动状态
	public static final int RUNNING = 1;// 运行状态
	public static final int PAUSE = 2;// 暂停状态
	public static final int GAME_OVER = 3;// 游戏结束
	private int state = START;

	private static BufferedImage[] start = new BufferedImage[2];
	private static BufferedImage pause;
	private static BufferedImage gameover;
	static {
		start[0] = FlyingObject.loadIamge("start.jpg");
		start[1] = FlyingObject.loadIamge("start0.png");
		pause = FlyingObject.loadIamge("PAUSE.png");
		gameover = FlyingObject.loadIamge("gameover.png");
	}

	private Hero hero = new Hero();
	private Sky sky = new Sky();
	// private FlyingObject[] enemies = {};
	// private Bullet[] bullets = {};
	// 数组改集合
	private ArrayList<FlyingObject> enemies = new ArrayList<FlyingObject>();
	private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	private ArrayList<Lightning> lights = new ArrayList<Lightning>();

	
	
	/** 返回一个flyingobject对象 */
	public FlyingObject nextOne() {
		Random rand = new Random();
		int type = rand.nextInt(20);
		if(type < 3){
			return new BigBee();
		}else if (type < 6) {
			return new Bee();
		} else if (type < 13) {
			return new Airplane(new Random().nextInt(5));
		} else {
			return new BigAirplane();
		}
	}

	/*闪电入场
	 */
	int lightIndex = 0;
	public synchronized void lightAction() {
		lightIndex++;
		if(lightIndex % 80 == 0){
			if(lights.size() == 6)
				lights.remove(0);
			lights.add(new Lightning());
		}
		//new Thread(new SoundSingleThread("Boss_Comming.mp3")).start();
	}
	
	/**
	 * boosAction()boos机
	 * 
	 */
	public void boosAction() {
		enemies.add(new BoosAirplane());
		new Thread(new SoundSingleThread("Boss_Comming.mp3")).start();
	}

	/** enterAction敌人进入 */
	int enterIndex = 0;
	public synchronized void enterAction() {
		enterIndex++;
		if (enterIndex % 40 == 0) {
			FlyingObject obj = nextOne();
			enemies.add(obj);
		}
	}

	/** shootAction子弹进入 */
	int shootIndex = 0;
	public synchronized void shootAction() {
		shootIndex++;
		if (shootIndex % 30 == 0) {
			Bullet[] bs = hero.shoot();
			bullets.addAll(Arrays.asList(bs));
		}
	}

	/** stepAction() */
	public synchronized void stepAction() {
		sky.step();
		for (Bullet bullet : bullets) {
			bullet.step();
		}
		for (FlyingObject e : enemies) {
			e.step();
		}
	}
	static int level = 1;
	static int prevLevel = 1;
	int shanke = 0;
	/** 主要运行代码 */
	public void action() {
		
		
		MouseAdapter l = new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if (state == RUNNING) {
					int x = e.getX();
					int y = e.getY();
					hero.moveTo(x, y);
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (state == START) {
					state = RUNNING;
				}
				if (state == GAME_OVER) {
					score = 0;
					sky = new Sky();
					hero = new Hero();
					enemies.clear();
					bullets.clear();
					clear = 0;
					state = START;
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (state == RUNNING)
					state = PAUSE;
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (state == PAUSE)
					state = RUNNING;
			}
		};
		this.addMouseListener(l);// 鼠标操作事件
		this.addMouseMotionListener(l);// 鼠标滑动事件
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					if (state == RUNNING) {
						//闪电入场
						lightAction();
						enterAction();// 敌人进入
						shootAction();// 子弹进入
						// boos进场
						level = score / 100 +1;
						if (level != prevLevel ) {
							boosAction();
							prevLevel = level;
						}
						stepAction();// 移动
						outOfBoundsAction();// 越界检查
						bulletBangAction();// 敌人与子弹撞
						heroBangAciton();// 英雄机与敌人碰撞
						checkGameOverAction();// 检测游戏结束
						//穿越时空
						if(clear >= 5 ){
							shanke = 1;
							enemies.clear();
							bullets.clear();
							clear = 0;
							/**
							 * 窗口抖动
							 */
							new Thread(new Runnable() {
								
								@Override
								public void run() {
									int i = 500;
									while(i >= 0){
										xLocation+=50;
										frame.setLocation(xLocation, yLocation);
										xLocation-=50;
										frame.setLocation(xLocation, yLocation);
										yLocation+=50;
										frame.setLocation(xLocation, yLocation);
										yLocation-=50;
										frame.setLocation(xLocation, yLocation);
										i--;
										//System.out.println(xLocation+"sss"+yLocation);
									}
								}
							}).start();
						}
					}
					repaint();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	public void checkGameOverAction() {
		if (hero.getLife() <= 0) {
			state = GAME_OVER;
			new Thread(new SoundSingleThread("gameover.mp3")).start();
		}
	}

	int clear = 0;
	public void heroBangAciton() {
		for (int i = 0; i < enemies.size(); i++) {
			if (hero.isLife() && enemies.get(i).isLife() && enemies.get(i).hit(hero)) {
				if(enemies.get(i) instanceof BigBee){
					clear++;
					enemies.get(i).goDead();
					new Thread(new SoundSingleThread("SuperFire.mp3")).start();
					break;
				}
				enemies.get(i).goDead();
				hero.substractLife();
				hero.clearDoubleFire();
			}
		}
	}

	int score = 0;
	public void bulletBangAction() {
		for (int i = 0; i < bullets.size(); i++) {
			Bullet b = bullets.get(i);
			for (int j = 0; j < enemies.size(); j++) {
				FlyingObject f = enemies.get(j);
				if (b.isLife() && f.isLife() && f.hit(b)) {
					if (f instanceof BoosAirplane) {
						BoosAirplane boos = (BoosAirplane) f;
						if (boos.getLife() > 0) {
							int li = boos.getLife();
							li--;
							boos.setLife(li);
							System.out.println(boos.getLife());
							break;
						}
					}
					if(f instanceof BigBee){
						break;
					}

					b.goDead();
					f.goDead();
					new Thread(new SoundSingleThread("Enemy_Boom.mp3")).start();

					if (f instanceof Enemy) {
						Enemy e = (Enemy) f;
						score += e.getScore();
					}
					if (f instanceof Award) {
						Award a = (Award) f;
						int type = a.getAwardType();
						switch (type) {
						case Award.DOUBLE_FIRE:
							hero.addFire();
							break;
						case Award.LIFE:
							hero.addLife();
							break;
						case Award.CLEAR:
							//clear++;
							break;
						}
					}
				}
			}
		}

	}

	public synchronized void outOfBoundsAction() {
		for (int i = 0; i < enemies.size(); i++) {
			if (enemies.get(i).outOfBounds() /* && enemies.get(i).isRemove() */) {
				if(enemies.get(i) instanceof BoosAirplane){
					level--;
					hero.reduceLife();
				}
				enemies.remove(i);
			}
		}
		for (int i = 0; i < bullets.size(); i++) {
			if (bullets.get(i).outOfBounds() /* && bullets.get(i).isRemove() */) {
				// bulletsLives[index++] = bullets[i];
				bullets.remove(i);
			}
		}
	}

	/** paint() */
	public synchronized void paint(Graphics g) {
		sky.paintObject(g);
		hero.paintObject(g);
		for (Lightning l : lights) {
			l.paintObject(g);
			l.goDead();
		}
		for (Bullet bullet : bullets) {
			bullet.paintObject(g);
		}
		for (FlyingObject e : enemies) {
			e.paintObject(g);
		}
		
		
		/**
		 * 穿越特效
		 */
		if(shanke == 1){
			if(sky.getBgNum() == 0){
				sky.setBgNum(1);
			}else{
				sky.setBgNum(0);
			}
			shanke = 0;
		}

		g.drawString("LIFE" + hero.getLife(), 10, 20);
		g.drawString("SCORE" + score, 10, 40);
		g.drawString("DOUBLEFIRE" + hero.getFire(), 10, 60);
		g.drawString("CLEAR" + clear, 10, 80);
		g.drawString("LEVEL" + level, 10, 100);

		switch (state) {
		case START:
			g.drawImage(start[0], 0, 0, null);
			g.drawImage(start[1], 0, 927, null);
			break;
		case PAUSE:
			g.drawImage(pause, 0, 0, null);
			break;
		case GAME_OVER:
			g.drawImage(gameover, 0, 0, null);
			break;
		}

	}

	public static void main(String[] args) {
		new Thread(new BgSoundThread("background_music.mp3")).start();
		frame = new JFrame();
		World world = new World();
		frame.add(world);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);;
		frame.setLocation(xLocation,yLocation);
		frame.setVisible(true);
		world.action();
		
	}

}
