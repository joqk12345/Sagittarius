package com.thinkit.dbtools;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Connection;

import com.thinkit.vo.SpeechVo;
/**
 * run  strong man
 * @author qiaokai
 *
 */
public class DBTools {
	
	private static Connection conn = null;
	
	private static Statement st; 
	
	public DBTools(){
		
	}
	
	public static  Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");// ����Mysql��������
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");// ������������
		} catch (Exception e) {
			System.out.println("���ݿ�����ʧ��" + e.getMessage());
		}
		return conn;	//���������������ݿ�����
	}
	/**
	 * ������ˮ��Ϣ
	 */
	public  void insertIdentifyInfo(SpeechVo speechVo){
//		conn = getConnection();	//ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�
		
	     Connection con = null;
	     Statement st; 
	        try {
	            con =  C3P0Tools.getInstance().getConnection();
	            String sql = "INSERT INTO identifyinfo(speechId, xmlresult, status,insertt)"
						+ " VALUES ('"+speechVo.getSpeechId()+"','"+speechVo.getXmlresult()+"', '"+speechVo.getStatus()+"', '"+speechVo.getInsertTime()+"')";	// �������ݵ�sql���
				System.out.println("sql"+sql);
				st = (Statement) con.createStatement();	// ��������ִ�о�̬sql����Statement����
				int count = st.executeUpdate(sql);	// ִ�в��������sql��䣬�����ز������ݵĸ���
				System.out.println("��identifyinfo���в��� " + count + " ������");	//�����������Ĵ�����
	        } catch (Exception e) {
	        	e.printStackTrace();
	        } finally {
	            if (con != null) {
	                try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("��������ʧ��" + e.getMessage());
					}
	            }
	        }
	}
	
	public static List<String > queryIdentifyInfo(Date startTime, Date endTime){
		conn = getConnection();	//ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�
		List<String> re = new ArrayList<String>();
		String startT=ConvertDateToString(startTime);
		String endT=ConvertDateToString(endTime);
		try {
			
			String sql = "select speechId from identifyinfo where insertt > '"+startT +"' and insertt< '"+endT+"'  ";		// ��ѯ���ݵ�sql���
			System.out.println("sql:"+sql);
			st = (Statement) conn.createStatement();	//��������ִ�о�̬sql����Statement����st���ֲ�����
			ResultSet rs = st.executeQuery(sql);	//ִ��sql��ѯ��䣬���ز�ѯ���ݵĽ����

			while (rs.next()) {	// �ж��Ƿ�����һ������
				// �����ֶ�����ȡ��Ӧ��ֵ
				String id = rs.getString("speechId");
				re.add(id);
				//����鵽�ļ�¼�ĸ����ֶε�ֵ
				System.out.println("���Ĳ�ѯ���Ϊ��"+id);
			}
			conn.close();	//�ر����ݿ�����
		} catch (SQLException e) {
			System.out.println("��ѯ����ʧ��");
		}
		return re;
	}

	

	/* �������ݼ�¼���������������ݼ�¼��*/
	public static void insert() {
		conn = getConnection();	// ����Ҫ��ȡ���ӣ������ӵ����ݿ�
		try {
			String sql = "INSERT INTO staff(name, age, sex,address, depart, worklen,wage)"
					+ " VALUES ('Tom1', 32, 'M', 'china','Personnel','3','3000')";	// �������ݵ�sql���
			
			st = (Statement) conn.createStatement();	// ��������ִ�о�̬sql����Statement����
			
			int count = st.executeUpdate(sql);	// ִ�в��������sql��䣬�����ز������ݵĸ���
			
			System.out.println("��staff���в��� " + count + " ������");	//�����������Ĵ�����
			
			conn.close();	//�ر����ݿ�����
			
		} catch (SQLException e) {
			System.out.println("��������ʧ��" + e.getMessage());
		}
	}
	
	/* ��ѯ���ݿ⣬�������Ҫ��ļ�¼�����*/
	public static void query() {
		
		conn = getConnection();	//ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�
		try {
			String sql = "select * from staff";		// ��ѯ���ݵ�sql���
			st = (Statement) conn.createStatement();	//��������ִ�о�̬sql����Statement����st���ֲ�����
			
			ResultSet rs = st.executeQuery(sql);	//ִ��sql��ѯ��䣬���ز�ѯ���ݵĽ����
			System.out.println("���Ĳ�ѯ���Ϊ��");
			while (rs.next()) {	// �ж��Ƿ�����һ������
				
				// �����ֶ�����ȡ��Ӧ��ֵ
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String sex = rs.getString("sex");
				String address = rs.getString("address");
				String depart = rs.getString("depart");
				String worklen = rs.getString("worklen");
				String wage = rs.getString("wage");
				//����鵽�ļ�¼�ĸ����ֶε�ֵ
				System.out.println(name + " " + age + " " + sex + " " + address
						+ " " + depart + " " + worklen + " " + wage);
			}
			conn.close();	//�ر����ݿ�����
		} catch (SQLException e) {
			System.out.println("��ѯ����ʧ��");
		}
	}
	public static  String ConvertDateToString(Date date){
		String s;
		 java.text.DateFormat format1 = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
	        s = format1.format(date);  
	        System.out.println(s);
	        return s;
	}
	
	

}
