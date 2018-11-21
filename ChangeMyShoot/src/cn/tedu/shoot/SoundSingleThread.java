package cn.tedu.shoot;

import java.io.InputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class SoundSingleThread implements Runnable{
	
	public String mp3Url;
	
	public SoundSingleThread(String mp3Url) {
		this.mp3Url = mp3Url;
		//System.out.println(mp3Url);
	}

	public void run(){
		//���������Ĳ���
		//1. ����MP3�ļ�
		InputStream in = SoundSingleThread.class.getClassLoader().getResourceAsStream(mp3Url);
		
		//2. �����ļ���������������Ķ���
		AdvancedPlayer ad;
		try {
			ad = new AdvancedPlayer(in);
			//3. ����
			ad.play();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
	}
}