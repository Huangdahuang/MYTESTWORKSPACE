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
	JLabel connector = new JLabel("��ϵ�ˣ�");
	JTextField JTConnector = new JTextField(10); // �����˺�����
	JLabel address = new JLabel("��ϵ��ʽ��");
	JTextField JTAddress = new JTextField(10); // �����˺�����
	JLabel connectorEmail = new JLabel("��ϵ���䣺");
	JTextField JTConnectorEmail = new JTextField(10); // �����˺�����
	JButton sure = new JButton("ȷ��");
	JButton clear = new JButton("���");
	
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
		
		
		this.add(jp, BorderLayout.CENTER); // ��������嶨�����м�
		this.setTitle("������ϵ��");
		this.setLocation(500, 300); // ���ó�ʼλ��
		this.pack(); // ��ʾ��������Զ�������С
		this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String username = JTConnector.getText();
		String password = JTAddress.getText();
		String email = JTConnectorEmail.getText();
		if(e.getSource() == sure){
			System.out.println("������ϵ�˳ɹ�");
		}else{
			JOptionPane.showMessageDialog(null, "������������ϵ�ˣ�");
			JTConnector.setText("");
			JTAddress.setText("");
			JTConnectorEmail.setText("");
		}
	}

}
