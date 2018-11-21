package com.huang.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.huang.servlet.LoginServlet;
import com.huang.servlet.RegServlet;

public class Login extends JFrame implements ActionListener {
	JButton login = new JButton("登录");
	JButton exit = new JButton("退出");
	JButton registe = new JButton("注册");
	JButton get_back_password = new JButton("忘记密码?");
	JLabel name = new JLabel("用户名：");
	JLabel password = new JLabel("密码：");
	JTextField JName = new JTextField(10); // 明文账号输入
	JPasswordField JPassword = new JPasswordField(10); // 非明文密码输入；

	public Login() {
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(4, 2)); // 3行2列的面板jp（网格布局）

		name.setHorizontalAlignment(SwingConstants.CENTER); // 设置该组件的对齐方式为向右对齐
		password.setHorizontalAlignment(SwingConstants.CENTER);

		jp.add(name); // 将内容加到面板jp上
		jp.add(JName);
		jp.add(password);
		jp.add(JPassword);
		jp.add(login);
		jp.add(exit);
		jp.add(registe);
		jp.add(get_back_password);

		login.addActionListener(this); // 登录增加事件监听
		exit.addActionListener(this); // 退出增加事件监听
		registe.addActionListener(this); // 注册增加事件监听
		get_back_password.addActionListener(this); // 忘记密码增加事件监听

		this.add(jp, BorderLayout.CENTER); // 将整块面板定义在中间

		this.setTitle("登录窗口");
		this.setLocation(500, 300); // 设置初始位置
		this.pack(); // 表示随着面板自动调整大小
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {// 对时间进行处理
		String username = JName.getText();
		String password = String.valueOf(JPassword.getPassword());
		if (e.getSource() == exit) {
			int i = JOptionPane.showConfirmDialog(null, "确认要退出吗？", "确认", JOptionPane.YES_NO_OPTION);
			// 显示选择对话框
			if (i == JOptionPane.YES_OPTION);
				System.exit(0);
		} else if(e.getSource() == login){
			LoginServlet loginServlet = new LoginServlet(username, password);
			if (loginServlet.login()) {
				JOptionPane.showMessageDialog(null, "登录成功，欢迎到来！");
				// 显示信息提示框
				new MainGUI();
				//System.exit(0);
			} else {
				JOptionPane.showMessageDialog(null, "用户或密码错误！请从新登录！");
				// 显示信息提示框
				JName.setText("");
				JPassword.setText("");
			}
		}else if(e.getSource() == registe){
			new RegGUI();
			/*if("".equals(username) || "".equals(password)){
				JOptionPane.showMessageDialog(null, "用户或密码不得为空,请重新注册!");
				JName.setText("");
				JPassword.setText("");
			}else{
				RegServlet loginServlet = new RegServlet(username,password);
				loginServlet.reg();
				JOptionPane.showMessageDialog(null, "注册完成！");
			}*/
		}else if(e.getSource() == get_back_password){
			JOptionPane.showMessageDialog(null, "忘记密码！");
		}
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new Login();
	}
}
