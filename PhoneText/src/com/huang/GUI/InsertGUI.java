package com.huang.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InsertGUI extends JDialog implements ActionListener{
	JLabel connector = new JLabel("联系人：");
	JTextField JTConnector = new JTextField(10); // 明文账号输入
	JLabel address = new JLabel("联系方式：");
	JTextField JTAddress = new JTextField(10); // 明文账号输入
	JLabel connectorEmail = new JLabel("联系邮箱：");
	JTextField JTConnectorEmail = new JTextField(10); // 明文账号输入
	JButton sure = new JButton("确定");
	JButton clear = new JButton("清除");
	
	public InsertGUI(){
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(4, 2));
		
		JTConnector.setHorizontalAlignment(SwingConstants.CENTER);
		JTAddress.setHorizontalAlignment(SwingConstants.CENTER);
		JTConnectorEmail.setHorizontalAlignment(SwingConstants.CENTER);
		
		jp.add(connector);
		jp.add(JTConnector);
		jp.add(address);
		jp.add(JTAddress);
		jp.add(connectorEmail);
		jp.add(JTConnectorEmail);
		jp.add(sure);
		jp.add(clear);
		
		sure.addActionListener(this);
		clear.addActionListener(this);
		
		
		this.add(jp, BorderLayout.CENTER); // 将整块面板定义在中间
		this.setTitle("新增联系人");
		this.setLocation(500, 300); // 设置初始位置
		this.pack(); // 表示随着面板自动调整大小
		this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String username = JTConnector.getText();
		String password = JTAddress.getText();
		String email = JTConnectorEmail.getText();
		if(e.getSource() == sure){
			System.out.println("新增联系人成功");
		}else{
			JOptionPane.showMessageDialog(null, "请重新填入联系人！");
			JTConnector.setText("");
			JTAddress.setText("");
			JTConnectorEmail.setText("");
		}
	}

}
