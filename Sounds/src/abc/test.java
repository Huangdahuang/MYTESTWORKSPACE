package abc;
public class test {
	public static void main(String[] args){
		new Thread(new BgSoundThread("background_music.mp3")).start();
	}
}
