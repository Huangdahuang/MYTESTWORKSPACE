package cn.tedu.shoot;
import java.io.InputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class BgSoundThread implements Runnable{
	
	public String mp3Url;
	
	public BgSoundThread(String mp3Url) {
		this.mp3Url = mp3Url;
	}

	public void run(){
		for(;;){			
			//测试声音的播放
			//1. 加载MP3文件
			
			InputStream in = BgSoundThread.class.getClassLoader().getResourceAsStream(mp3Url);
			
			//2. 根据文件流，创建播放类的对象
			AdvancedPlayer ad;
			try {
				ad = new AdvancedPlayer(in);
				
				//3. 播放
				ad.play();
			} catch (JavaLayerException e) {
				e.printStackTrace();
			}
		}
	}
	
}