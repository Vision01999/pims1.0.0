package com.sise.pms;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *��Ŀ����:pms
 *����:Node22Panel
 *������:��Ա������ʷ��ѯ
 *������:����Ⱥ
 *����ʱ��:2014��11��13�� ����10:04:19
 *�޸���:
 *�޸�ʱ��:
 *�޸ı�ע:
 *@version 1.0.0
 */
public class Node22Panel extends JPanel{
	HistrjnBean hbean = new HistrjnBean();
	JLabel title;
	JTable table;
	JPanel p1,p2,p3;
	JScrollPane scrollPane;
	JLabel numLabel,nameLabel,sexLabel,birLabel;
	JTextField numText,nameText,sexText,birText;
	public Node22Panel(){
		init();
	}
	public void init(){
		//a.�ϲ�����
		p1 = new JPanel();
		title = new JLabel("");
		p1.add(title);
		//b.�в�����
		p2 = new JPanel();
		
		String tableTitle[] = {"��ˮ��","��Ա����","ԭ����","�²���","�������","�������"};
		
		String tableValues[][] = hbean.transferHis();//����Ա������ʷ����Ϣ��ӵ����
		//�������
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
