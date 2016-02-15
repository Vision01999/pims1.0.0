package com.sise.pms;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *��Ŀ����:pms
 *����:HrMain
 *������:������
 *������:����Ⱥ
 *����ʱ��:2014��11��13�� ����10:03:49
 *�޸���:
 *�޸�ʱ��:
 *�޸ı�ע:
 *@version 1.0.0
 */
public class HrMain extends JFrame implements TreeSelectionListener{

	JSplitPane splitPane ;//split���
	JPanel p1,p2;//�������
	JScrollPane scrollPane;//�������
	JTree tree ;//��
	Image image;//ͼƬ
	JLabel label,imgLabel;
	DefaultMutableTreeNode root;//����
	DefaultMutableTreeNode node1,node2,node3,node4;//���ڵ�1��2��3��4,��Ӧģ��
	DefaultMutableTreeNode node11,node12,node13,node14,node15;//��һ���ڵ���ӽڵ�
	DefaultMutableTreeNode node21,node22;//�ڶ����ڵ���ӽڵ�
	DefaultMutableTreeNode node31,node32;//�������ڵ���ӽڵ�
	DefaultMutableTreeNode node41,node42;//���ĸ��ڵ���ӽڵ�
	//���캯�������ڳ�ʼ
	HrMain(){

		Image image = Toolkit.getDefaultToolkit().getImage("../pms/images/sing.png");
		setIconImage(image);//���ñ�������ͼ��
		setTitle("���¹���ϵͳ");//���ñ������ı���
		
		root = new DefaultMutableTreeNode("���¹���ϵͳ");

		//��ӽڵ�1���ӽڵ�
		node1 = new DefaultMutableTreeNode("������Ϣ����");
		node11 = new DefaultMutableTreeNode("�����Ա��Ϣ");
		node1.add(node11);
		node12 = new DefaultMutableTreeNode("�޸���Ա��Ϣ");
		node1.add(node12);
		node13 = new DefaultMutableTreeNode("ɾ����Ա��Ϣ");
		node1.add(node13);
		node14 = new DefaultMutableTreeNode("��ѯ��Ա��Ϣ");
		node1.add(node14);
		node15 = new DefaultMutableTreeNode("���Ź���");
		node1.add(node15);
		root.add(node1);
		
		//��ӽڵ�2���ӽڵ�
		node2 = new DefaultMutableTreeNode("��Ա��������");
		node21 = new DefaultMutableTreeNode("��Ա����");
		node2.add(node21);
		node22 = new DefaultMutableTreeNode("������ʷ��ѯ");
		node2.add(node22);
		root.add(node2);
		//��ӽڵ�3���ӽڵ�
		node3 = new DefaultMutableTreeNode("��Ա���˹���");
		node31 = new DefaultMutableTreeNode("��Ա����");
		node3.add(node31);
		node32 = new DefaultMutableTreeNode("������ʷ��ѯ");
		node3.add(node32);
		root.add(node3);
		//��ӽڵ�4���ӽڵ�
		node4 = new DefaultMutableTreeNode("���ʹ���");
		node41 = new DefaultMutableTreeNode("���ʷ������");
		node4.add(node41);
		node42 = new DefaultMutableTreeNode("������ʷ��ѯ");
		node4.add(node42);
		root.add(node4);
		//����һ����
		tree = new JTree(root);
		tree.addTreeSelectionListener(this);//�������ѡ���¼�

		scrollPane = new JScrollPane(tree);//������ӵ��������
		//�����
		p1 = new JPanel();
		p1.add(scrollPane);
		//����壬���Ա����
		p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		//ͼ��,�ӵ���ǩ���ټӵ������
        ImageIcon icon = new ImageIcon("../pms/images/building1.png");
	
		
		imgLabel = new JLabel("",icon,SwingConstants.CENTER);
		imgLabel.setBounds(10, 10, 300, 300);
		
		
		p2.add("Center",imgLabel);
		//���������ӵ�split���
		splitPane = new JSplitPane();
		splitPane.setLeftComponent(p1);
		splitPane.setRightComponent(p2);
		
		setContentPane(splitPane);
			
		//����JFrame������
		setResizable(false);//���ò����Ըı��С
		pack();//�Զ�����
		setSize(900,450);
		
		
		//��������ʱ���ڵ�λ��
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				Dimension frameSize = getSize();
				if (frameSize.height > screenSize.height) {
					frameSize.height = screenSize.height;
				}
				if (frameSize.width > screenSize.width) {
					frameSize.width = screenSize.width;
				}
				setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		setVisible(true);
	}
	
	@Override
	/*
	 * ���ص�valueChange����
	 * ���������ڵ�ʱ���¼�������
	 * �����������Ա��Ϣ���޸���Ա��Ϣ�������Զ��ӵ����������
	 */
	public void valueChanged(TreeSelectionEvent e) {
		DefaultMutableTreeNode dnode = (DefaultMutableTreeNode)e.getPath().getLastPathComponent();
		String dnode_str = dnode.toString();
		if(dnode_str == "���¹���ϵͳ"){
			splitPane.setRightComponent(p2);	
		}else if(dnode_str == "�����Ա��Ϣ"){
			splitPane.setRightComponent(new Node11Panel());
		}else if(dnode_str == "�޸���Ա��Ϣ"){
				splitPane.setRightComponent(new Node12Panel());	
		}else if(dnode_str == "��ѯ��Ա��Ϣ"){
			splitPane.setRightComponent(new Node14Panel());	
		}else if(dnode_str == "ɾ����Ա��Ϣ"){
			splitPane.setRightComponent(new Node13Panel());	
		}else if(dnode_str == "���Ź���"){
			splitPane.setRightComponent(new Node15Panel());	
		}else if(dnode_str == "��Ա����"){
			splitPane.setRightComponent(new Node21Panel());	
		}else if(dnode_str == "������ʷ��ѯ"){
			splitPane.setRightComponent(new Node22Panel());	
		}else if(dnode_str == "��Ա����"){
			splitPane.setRightComponent(new Node31Panel());	
		}else if(dnode_str == "������ʷ��ѯ"){
			splitPane.setRightComponent(new Node32Panel());	
		}else if(dnode_str == "���ʷ������"){
			splitPane.setRightComponent(new Node41Panel());
		}else if(dnode_str == "������ʷ��ѯ"){
			splitPane.setRightComponent(new Node42Panel());
		}else{
			splitPane.setRightComponent(p2);
		}
		
	}

}
