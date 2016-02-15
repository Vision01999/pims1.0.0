package com.sise.pms;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 *��Ŀ����:pms
 *����:HrMS
 *������:����һ����½��
 *������:����Ⱥ
 *����ʱ��:2014��11��13�� ����10:03:55
 *�޸���:
 *�޸�ʱ��:
 *�޸ı�ע:
 *@version 1.0.0
 */
public class HrMS {
	JOptionPane op=new JOptionPane();
	JFrame f;
	JLabel label1;
	JLabel label2;
	JTextField user;//�û���
	JPasswordField pwd;//����
	JButton exit;//�˳�
	JButton registerBtn;//��½
	
	public HrMS(){
	
		int width=13;
		f=new JFrame();
		
		f.setLocation(300, 300);
		
		Image image=Toolkit.getDefaultToolkit().getImage("../pms/images/leaf.png");
	
		
		f.setIconImage(image);
		
		f.setTitle("���¹���ϵͳ��¼��");
		
		f.setLayout(new GridLayout(3,1));//3��1�еĲ���
			
		JPanel p1=new JPanel();
		
		JPanel p2=new JPanel();
		
		JPanel p3=new JPanel();
		
		
		label1=new JLabel("�û���:");
		
		label2=new JLabel("����:");
		
		user=new JTextField(width);
		user.setText("admin");
		
		pwd=new JPasswordField(width);//�����
		pwd.setText("123");
		pwd.setEchoChar('*');
		
		ImageIcon image1=new ImageIcon("../pms/images/no.png");
		
		
		exit=new JButton("�˳�",image1);

		
		ImageIcon image2=new ImageIcon("../pms/images/login.png");
		
		registerBtn=new JButton("��¼",image2);
		
		
		registerBtn.setSize(30, 30);
		
		//registerBtn.
		//�����˳�����¼��ر�
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		
		//�û���admin,����123
	//������¼��֤�û����������Ƿ���ȷ,����ȷ������������,����ʾ����
		registerBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(user.getText().equals("admin")&&pwd.getText().equals("123")){
					op.showMessageDialog(null, "��¼�ɹ�!");//��ʾ��¼�ɹ�
					new HrMain();
					f.setVisible(false);//���ص�¼��
				}else{
					op.showMessageDialog(null, "���¼!��������:123");
				}
			}
		});

		
		p1.add(label1);
		
		p1.add(user);
		
		p2.add(label2);
		
		p2.add(pwd);
		
		p3.add(registerBtn);
		
		p3.add(exit);
		
		f.add(p1);
		f.add(p2);
		f.add(p3);
		
		f.setVisible(true);//���ÿɼ���
		
		f.setSize(300,300);

      
	}
	
	
	public static void main(String[] args) {
	
			new HrMS();//��������
	
	}

	
	
}
