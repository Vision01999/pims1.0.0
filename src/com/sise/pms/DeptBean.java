package com.sise.pms;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *��Ŀ����:pms
 *����:DeptBean
 *������:ʵ�ֶԲ��������Ϣ�������ݿ�����Ĺ��ܣ�����������Ϣ�����ӡ��޸ġ�ɾ������ѯ��
 *������:����Ⱥ
 *����ʱ��:2014��11��13�� ����10:03:34
 *�޸���:
 *�޸�ʱ��:
 *�޸ı�ע:
 *@version 1.0.0
 */
public class DeptBean {
	Database db = new Database();//Database�����з�װ�����ݿ��������
	
		ResultSet res=null;//ResultSet����
		
		String id="";
	
/*
 * 	��ѯDept������������ݣ�����"���ź�-һ������-��������"��ʽ����һ���ַ�������
 *	����:(1)ģ��1��������Ϣ�������Ź���,�����ݼ��ص�����JComboBox����� 
 *		 (2)ģ��2����Ա�����������Ź���,�����ݼ��ص��²��ŵ�JComboBox�����
 */
	public String[] searchAllForDept(){
		
		String[] s = null;//�ַ������飬���ڽ��ղ�����Ϣ
		
		int rows = 0;//Dept���������
			
		int i = 0;//��i������
		
		String sql = "select * from Dept order by DeptID";//���ݲ�ѯ���
		
		res = db.query(sql);//����Database����Ĳ�ѯ����
	
		try {
			//���Dept�������ݣ��͵���Resultset���getRow����,��ȡ����
			if(res.last()){
				rows = res.getRow();
			}
			//�������Ϊ0,���鸳��ֵ,��,��ѯ������Ϣ
			if(rows == 0){
				s[0]="";
				s[1]="";
				s[2]="";
			}else{
				s = new String[rows];
				res.first();//��ȡ��һ��
				res.previous();//�����ѯ
				while(res.next()){
					s[i]=res.getString("DeptID")+"-"+res.getString("B_Dept")+"-"+
				res.getString("S_Dept");
					i++;//�������ۼ�
				}
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			db.close();//�ر����ݿ�
		}
		return s;//��������
	}
	/*
	 * ��ѯ������Ϣ
	 * ����:(1)ģ��1��������Ϣ�����Ĳ��Ź���,��������Ϣ���ص������Ա����޸ĵȲ���
	 * 
	 * ע��:���ض�ά����,��������кͱ������ж�Ӧ
	 */
	public String[][] select(){
		int i = 0;
		int rows = 0;
		String sql = "select DeptID,B_Dept,S_Dept from Dept order by DeptID";//��ѯ���
		String s[][] = null;//��ά����
		res = db.query(sql);//��ѯ
		try {
			if(res.last()){
				rows = res.getRow();//��ȡ����
			}
			
			if(rows == 0){
				s = new String[1][3];
				s[0][0]="";
				s[0][1]="";
				s[0][2]="";
			}else{//������Ϊ0
				s = new String[rows][3];
				res.first();//��һ��
				res.previous();//�����ѯ
				while(res.next()){
				
					s[i][0]=res.getString("DeptID");//���ź�
					s[i][1]=res.getString("B_Dept");//һ������
					s[i][2]=res.getString("S_Dept");//��������
					i++;//�������ۼ�
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.close();//�ر����ݿ�
		}
		
		return s;//���ض�ά����
	}
	/*
	 * ��ѯ������Ϣ
	 * ����:(1)����ģ��2����Ա����������ģ��3����Ա���˹�����ģ��4�����ʹ�����
	 * �ֱ���ز�����Ϣ����Ա��������Ա���ˡ����ʹ���ı������Ϣ��һ��
	 * 
	 */
	public String[][] searchMsg(){
		int i = 0;
		int rows = 0;
		String s[][]=null;
		
		//�漰2�ű�Ĳ�ѯ,Ҫͨ�������������
		String sql="select PersonID,Name,Sex,B_Dept,S_Dept,Salary,Assess,Dept.DeptID,Person.DeptID "
				+"from Dept,Person where Dept.DeptID = Person.DeptID order by PersonID";
		
		res = db.query(sql);
		
		try {
			if(res.last()){
				rows=res.getRow();//����
			}
		
			if(rows == 0){
				s = new String[1][6];
				s[0][0]="";
				s[0][1]="";
				s[0][2]="";
				s[0][3]="";
				s[0][4]="";
				s[0][5]="";
				
			}else{
				s = new String[rows][6];
				res.first();//��һ��
				res.previous();//�����ѯ
				while(res.next()){
					s[i][0]=res.getString("PersonID");
					s[i][1]=res.getString("Name");
					s[i][2]=res.getString("Sex");
					s[i][3]=res.getString("B_Dept")+"-"+res.getString("S_Dept");	
					s[i][4]=res.getString("Salary");//����
					s[i][5]=res.getString("Assess");//������Ϣ
					i++;
				}
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	
	
	
/*
 * ɾ��������Ϣ
 * ����:(1)ģ��1��������Ϣ�����Ĳ��Ź���ɾ��������Ϣ
 * 
 */

	String deptId;
	public void deleteDeptMsg(String deptId){
		this.deptId=deptId;
		String sql = "delete from Dept where DeptID="+deptId+"";//ɾ��������Ϣ
		db.update(sql);
		
	}
	String b,s,i;
/*
 * ������Ϣ
 * ����:(1)ģ��1��������Ϣ�����Ĳ��Ź����޸Ĳ�����Ϣ
 * 
 */
	public void update(String i,String b,String s){
		this.i=i;
		this.b=b;
		this.s=s;
		String sql="update Dept set B_Dept='"+b+"',S_Dept='"+s+"' where DeptID="+i+"";
		
		db.update(sql);
		
	}
	
/*
 * ��ȡ���ű�ŵ����ֵ
 * ����:(1)ģ��1��������Ϣ�����Ĳ��Ź�����ȡ�±��
 * 	
 */
	public int getNewId(){
		int i=0;
		String sql="select max(DeptID) from Dept";
		
		res=db.query(sql);
		
		try {
			if(res.next()){
				i=res.getInt(1)+1;//��ȡ�µĲ��ű��
			}else{
				i=1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	

}
