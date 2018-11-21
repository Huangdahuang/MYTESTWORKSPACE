package com.huang.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.huang.servlet.RegServlet;

public class RegGUI extends JDialog implements ActionListener{
	private String host ;
	JLabel JLname = new JLabel("�û�����");
	JTextField JTUsername = new JTextField(10); // �����˺�����
	JLabel JLpasspword = new JLabel("����:");
	JPasswordField JPPassword = new JPasswordField(10); // �������������룻
	JLabel JLemail = new JLabel("����:");
	JTextField JTEmail = new JTextField(10);
	JLabel JLage = new JLabel("����:");
	JTextField JTAge = new JTextField(10);
	JButton sure = new JButton("ȷ��");
	JButton clear = new JButton("���");
	
	
	public RegGUI(){
		System.out.println("RegGUI:" + host);
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(5, 2)); // 3��2�е����jp�����񲼾֣�

		JLname.setHorizontalAlignment(SwingConstants.CENTER); // ���ø�����Ķ��뷽ʽΪ���Ҷ���
		JLpasspword.setHorizontalAlignment(SwingConstants.CENTER);
		JLemail.setHorizontalAlignment(SwingConstants.CENTER);
		JLage.setHorizontalAlignment(SwingConstants.CENTER);
		
		jp.add(JLname);
		jp.add(JTUsername);
		jp.add(JLpasspword);
		jp.add(JPPassword);
		jp.add(JLemail);
		jp.add(JTEmail);
		jp.add(JLage);
		jp.add(JTAge);
		jp.add(sure);
		jp.add(clear);
		
		sure.addActionListener(this);
		clear.addActionListener(this);
		
		
		this.add(jp, BorderLayout.CENTER); // ��������嶨�����м�

		this.setTitle("ע�ᴰ��");
		this.setLocation(500, 300); // ���ó�ʼλ��
		this.pack(); // ��ʾ��������Զ�������С
		this.setVisible(true);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String username = JTUsername.getText();
		String password = String.valueOf(JPPassword.getPassword());
		String email = JTEmail.getText();
		host = username;
		int age = 0;
		try {
			age = Integer.parseInt(JTAge.getText());
		} catch (NumberFormatException e1) {
		}
		if(e.getSource() == sure){
			if("".equals(username) || "".equals(password)){
				JOptionPane.showMessageDialog(null, "�û������벻��Ϊ��,������ע��!");
				JTUsername.setText("");
				JPPassword.setText("");
				JTEmail.setText("");
				JTAge.setText("");
			}else{
				RegServlet loginServlet = new RegServlet(host ,username,password ,email,age);
				loginServlet.reg();
				JOptionPane.showMessageDialog(null, "ע����ɣ�");
			}
		}else{
			JOptionPane.showMessageDialog(null, "����������ע����Ϣ��");
			JTUsername.setText("");
			JPPassword.setText("");
			JTEmail.setText("");
			JTAge.setText("");
		}
		
	}

	/*public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new RegGUI();
	}*/
}
