package com.huang.GUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JDialog;

public class MainGUI extends /*Frame*/JDialog {

	private TextField tf;
	private Button insert;
	private Button select;
	private Button clear;
	private Button shake;
	private TextArea viewText;
	private TextArea sendText;
	private String host;
	//private DatagramSocket socket;
	//private BufferedWriter bw;
	/**
	 * @param args
	 * GUI聊天
	 */
	public MainGUI(String host) {
		this.host = host;
		init();
		southPanel();
		centerPanel();
		event();
	}

	public void event() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					//socket.close();
					//bw.close();
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				//System.exit(0);
				
			}
		});
		
		insert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
//					send();
					new InsertGUI(host);
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}

		});
		
		select.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("查询所有联系人");
					logFile();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}

		});
		
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				viewText.setText("");
			}
		});
		
		shake.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
//					send(new byte[]{-1},tf.getText());
					shake();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		});
		
		sendText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//if(e.getKeyCode() == KeyEvent.VK_ENTER && e.isControlDown()) {	//isControlDown ctrl是否被按下
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						send();
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
				}
			}
		});
	}
	

	private void shake() {
		int x = this.getLocation().x;							//获取横坐标位置
		int y = this.getLocation().y;							//获取纵坐标位置
		
		for(int i = 0; i < 20; i++) {
			try {
				this.setLocation(x + 20, y + 20);
				Thread.sleep(20);
				this.setLocation(x + 20, y - 20);
				Thread.sleep(20);
				this.setLocation(x - 20, y + 20);
				Thread.sleep(20);
				this.setLocation(x - 20, y - 20);
				Thread.sleep(20);
				this.setLocation(x, y);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void logFile() throws IOException {
		FileInputStream fis = new FileInputStream("./phone/" + host + ".xml");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();	//在内存中创建缓冲区
		
		int len;
		byte[] arr = new byte[8192];
		while((len = fis.read(arr)) != -1) {
			baos.write(arr, 0, len);
		}
		
		String str = baos.toString();				//将内存中的内容转换成了字符串
		viewText.setText(str);
		
		fis.close();
	}
	
	private void send(byte[] arr, String ip) throws IOException {
							//发送数据
	}
	
	private void send() throws IOException {
		
		
		
	}
	
	private String getCurrentTime() {
		return "";					//将时间格式化
	}

	public void centerPanel() {
		Panel center = new Panel();					//创建中间的Panel
		viewText = new TextArea();
		sendText = new TextArea(5,1);
		center.setLayout(new BorderLayout());		//设置为边界布局管理器
		center.add(sendText,BorderLayout.SOUTH);	//发送的文本区域放在南边
		center.add(viewText,BorderLayout.CENTER);	//显示区域放在中间
		viewText.setEditable(false);				//设置不可以编辑
		viewText.setBackground(Color.WHITE);		//设置背景颜色
		sendText.setFont(new Font("xxx", Font.PLAIN, 15));
		viewText.setFont(new Font("xxx", Font.PLAIN, 15));
		this.add(center,BorderLayout.CENTER);
	}

	public void southPanel() {
		Panel south = new Panel();					//创建南边的Panel
		tf = new TextField(15);
		tf.setText("127.0.0.1");
		insert = new Button("增 加");
		select = new Button("查 询");
		clear = new Button("清 屏");
		shake = new Button("震 动");
		south.add(tf);
		south.add(insert);
		south.add(select);
		south.add(clear);
		south.add(shake);
		this.add(south,BorderLayout.SOUTH);			//将Panel放在Frame的南边
	}

	public void init() {
		this.setLocation(500, 50);
		this.setSize(400, 600);
		//new Receive().start();
		
		this.setVisible(true);
	}
	/*private class Receive extends Thread {			//接收和发送需要同时执行,所以定义成多线程的
		public void run() {
			try {
				DatagramSocket socket = new DatagramSocket(9999);
				DatagramPacket packet = new DatagramPacket(new byte[8192], 8192);
				
				while(true) {
					socket.receive(packet);				//接收信息
					byte[] arr = packet.getData();		//获取字节数据
					int len = packet.getLength();		//获取有效的字节数据
					if(arr[0] == -1 && len == 1) {		//如果发过来的数组第一个存储的值是-1,并且数组长度是1
						shake();						//调用震动方法
						continue;						//终止本次循环,继续下次循环,因为震动后不需要执行下面的代码
					}
					String message = new String(arr,0,len);	//转换成字符串
					String time = getCurrentTime();		//获取当前时间
					String ip = packet.getAddress().getHostAddress();	//获取ip地址
					String str = time + " " + ip + " 对我说:\r\n" + message + "\r\n\r\n";
					viewText.append(str);
					bw.write(str);
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
	}*/
	
/*	public static void main(String[] args) {
		new MainGUI();
	}*/

}


