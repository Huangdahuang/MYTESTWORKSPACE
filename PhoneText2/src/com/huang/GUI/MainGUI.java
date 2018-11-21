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
	 * GUI����
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
					System.out.println("��ѯ������ϵ��");
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
				//if(e.getKeyCode() == KeyEvent.VK_ENTER && e.isControlDown()) {	//isControlDown ctrl�Ƿ񱻰���
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
		int x = this.getLocation().x;							//��ȡ������λ��
		int y = this.getLocation().y;							//��ȡ������λ��
		
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
		ByteArrayOutputStream baos = new ByteArrayOutputStream();	//���ڴ��д���������
		
		int len;
		byte[] arr = new byte[8192];
		while((len = fis.read(arr)) != -1) {
			baos.write(arr, 0, len);
		}
		
		String str = baos.toString();				//���ڴ��е�����ת�������ַ���
		viewText.setText(str);
		
		fis.close();
	}
	
	private void send(byte[] arr, String ip) throws IOException {
							//��������
	}
	
	private void send() throws IOException {
		
		
		
	}
	
	private String getCurrentTime() {
		return "";					//��ʱ���ʽ��
	}

	public void centerPanel() {
		Panel center = new Panel();					//�����м��Panel
		viewText = new TextArea();
		sendText = new TextArea(5,1);
		center.setLayout(new BorderLayout());		//����Ϊ�߽粼�ֹ�����
		center.add(sendText,BorderLayout.SOUTH);	//���͵��ı���������ϱ�
		center.add(viewText,BorderLayout.CENTER);	//��ʾ��������м�
		viewText.setEditable(false);				//���ò����Ա༭
		viewText.setBackground(Color.WHITE);		//���ñ�����ɫ
		sendText.setFont(new Font("xxx", Font.PLAIN, 15));
		viewText.setFont(new Font("xxx", Font.PLAIN, 15));
		this.add(center,BorderLayout.CENTER);
	}

	public void southPanel() {
		Panel south = new Panel();					//�����ϱߵ�Panel
		tf = new TextField(15);
		tf.setText("127.0.0.1");
		insert = new Button("�� ��");
		select = new Button("�� ѯ");
		clear = new Button("�� ��");
		shake = new Button("�� ��");
		south.add(tf);
		south.add(insert);
		south.add(select);
		south.add(clear);
		south.add(shake);
		this.add(south,BorderLayout.SOUTH);			//��Panel����Frame���ϱ�
	}

	public void init() {
		this.setLocation(500, 50);
		this.setSize(400, 600);
		//new Receive().start();
		
		this.setVisible(true);
	}
	/*private class Receive extends Thread {			//���պͷ�����Ҫͬʱִ��,���Զ���ɶ��̵߳�
		public void run() {
			try {
				DatagramSocket socket = new DatagramSocket(9999);
				DatagramPacket packet = new DatagramPacket(new byte[8192], 8192);
				
				while(true) {
					socket.receive(packet);				//������Ϣ
					byte[] arr = packet.getData();		//��ȡ�ֽ�����
					int len = packet.getLength();		//��ȡ��Ч���ֽ�����
					if(arr[0] == -1 && len == 1) {		//����������������һ���洢��ֵ��-1,�������鳤����1
						shake();						//�����𶯷���
						continue;						//��ֹ����ѭ��,�����´�ѭ��,��Ϊ�𶯺���Ҫִ������Ĵ���
					}
					String message = new String(arr,0,len);	//ת�����ַ���
					String time = getCurrentTime();		//��ȡ��ǰʱ��
					String ip = packet.getAddress().getHostAddress();	//��ȡip��ַ
					String str = time + " " + ip + " ����˵:\r\n" + message + "\r\n\r\n";
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


