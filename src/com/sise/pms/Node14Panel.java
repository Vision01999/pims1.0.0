package com.sise.pms;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *��Ŀ����:pms
 *����:Node14Panel
 *������:������Ϣ����Ĳ�ѯ��Ա��Ϣ
 *������:����Ⱥ
 *����ʱ��:2014��11��13�� ����10:04:09
 *�޸���:
 *�޸�ʱ��:
 *�޸ı�ע:
 *@version 1.0.0
 */
public class Node14Panel extends JPanel{
	PersonBean pbean = new PersonBean();
	JLabel title;
	JPanel p1,p2,p3;
	JTable table;//���
	JScrollPane scrollPane;
	JLabel numLabel,nameLabel,sexLabel,birLabel;
	JTextField numText,nameText,sexText,birText;
	public Node14Panel(){
		init();
	}
	public void init(){
		//a.�ϲ�����
		p1 = new JPanel();
		title = new JLabel("");
		p1.add(title);
		
		//b.�в�����
		p2 = new JPanel();
		
		String tableTitle[] = {"���","����","��������","����","��ַ","����"};
		
		String tableValues[][] = pbean.select();//��ȡ���ݿ��������
		
		table = new JTable(tableValues,tableTitle);
		
		scrollPane = new JScrollPane(table);
		
		p2.add(scrollPane);
		
		//c.�²�����
		p3 = new JPanel();

		
		add("North",p1);
		add("Center",p2);
		add("South",p3);
	}
}












