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
	JLabel JLname = new JLabel("用户名：");
	JTextField JTUsername = new JTextField(10); // 明文账号输入
	JLabel JLpasspword = new JLabel("密码:");
	JPasswordField JPPassword = new JPasswordField(10); // 非明文密码输入；
	JLabel JLemail = new JLabel("邮箱:");
	JTextField JTEmail = new JTextField(10);
	JLabel JLage = new JLabel("年龄:");
	JTextField JTAge = new JTextField(10);
	JButton sure = new JButton("确定");
	JButton clear = new JButton("清除");
	
	
	public RegGUI(){
		System.out.println("RegGUI:" + host);
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(5, 2)); // 3行2列的面板jp（网格布局）

		JLname.setHorizontalAlignment(SwingConstants.CENTER); // 设置该组件的对齐方式为向右对齐
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
		
		
		this.add(jp, BorderLayout.CENTER); // 将整块面板定义在中间

		this.setTitle("注册窗口");
		this.setLocation(500, 300); // 设置初始位置
		this.pack(); // 表示随着面板自动调整大小
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
				JOptionPane.showMessageDialog(null, "用户或密码不得为空,请重新注册!");
				JTUsername.setText("");
				JPPassword.setText("");
				JTEmail.setText("");
				JTAge.setText("");
			}else{
				RegServlet loginServlet = new RegServlet(host ,username,password ,email,age);
				loginServlet.reg();
				JOptionPane.showMessageDialog(null, "注册完成！");
			}
		}else{
			JOptionPane.showMessageDialog(null, "请重新填入注册信息！");
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
