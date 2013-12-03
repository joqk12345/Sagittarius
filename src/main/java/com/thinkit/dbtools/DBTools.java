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
			Class.forName("com.mysql.jdbc.Driver");// 加载Mysql数据驱动
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");// 创建数据连接
		} catch (Exception e) {
			System.out.println("数据库连接失败" + e.getMessage());
		}
		return conn;	//返回所建立的数据库连接
	}
	/**
	 * 插入流水信息
	 */
	public  void insertIdentifyInfo(SpeechVo speechVo){
//		conn = getConnection();	//同样先要获取连接，即连接到数据库
		
	     Connection con = null;
	     Statement st; 
	        try {
	            con =  C3P0Tools.getInstance().getConnection();
	            String sql = "INSERT INTO identifyinfo(speechId, xmlresult, status,insertt)"
						+ " VALUES ('"+speechVo.getSpeechId()+"','"+speechVo.getXmlresult()+"', '"+speechVo.getStatus()+"', '"+speechVo.getInsertTime()+"')";	// 插入数据的sql语句
				System.out.println("sql"+sql);
				st = (Statement) con.createStatement();	// 创建用于执行静态sql语句的Statement对象
				int count = st.executeUpdate(sql);	// 执行插入操作的sql语句，并返回插入数据的个数
				System.out.println("向identifyinfo表中插入 " + count + " 条数据");	//输出插入操作的处理结果
	        } catch (Exception e) {
	        	e.printStackTrace();
	        } finally {
	            if (con != null) {
	                try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("插入数据失败" + e.getMessage());
					}
	            }
	        }
	}
	
	public static List<String > queryIdentifyInfo(Date startTime, Date endTime){
		conn = getConnection();	//同样先要获取连接，即连接到数据库
		List<String> re = new ArrayList<String>();
		String startT=ConvertDateToString(startTime);
		String endT=ConvertDateToString(endTime);
		try {
			
			String sql = "select speechId from identifyinfo where insertt > '"+startT +"' and insertt< '"+endT+"'  ";		// 查询数据的sql语句
			System.out.println("sql:"+sql);
			st = (Statement) conn.createStatement();	//创建用于执行静态sql语句的Statement对象，st属局部变量
			ResultSet rs = st.executeQuery(sql);	//执行sql查询语句，返回查询数据的结果集

			while (rs.next()) {	// 判断是否还有下一个数据
				// 根据字段名获取相应的值
				String id = rs.getString("speechId");
				re.add(id);
				//输出查到的记录的各个字段的值
				System.out.println("最后的查询结果为："+id);
			}
			conn.close();	//关闭数据库连接
		} catch (SQLException e) {
			System.out.println("查询数据失败");
		}
		return re;
	}

	

	/* 插入数据记录，并输出插入的数据记录数*/
	public static void insert() {
		conn = getConnection();	// 首先要获取连接，即连接到数据库
		try {
			String sql = "INSERT INTO staff(name, age, sex,address, depart, worklen,wage)"
					+ " VALUES ('Tom1', 32, 'M', 'china','Personnel','3','3000')";	// 插入数据的sql语句
			
			st = (Statement) conn.createStatement();	// 创建用于执行静态sql语句的Statement对象
			
			int count = st.executeUpdate(sql);	// 执行插入操作的sql语句，并返回插入数据的个数
			
			System.out.println("向staff表中插入 " + count + " 条数据");	//输出插入操作的处理结果
			
			conn.close();	//关闭数据库连接
			
		} catch (SQLException e) {
			System.out.println("插入数据失败" + e.getMessage());
		}
	}
	
	/* 查询数据库，输出符合要求的记录的情况*/
	public static void query() {
		
		conn = getConnection();	//同样先要获取连接，即连接到数据库
		try {
			String sql = "select * from staff";		// 查询数据的sql语句
			st = (Statement) conn.createStatement();	//创建用于执行静态sql语句的Statement对象，st属局部变量
			
			ResultSet rs = st.executeQuery(sql);	//执行sql查询语句，返回查询数据的结果集
			System.out.println("最后的查询结果为：");
			while (rs.next()) {	// 判断是否还有下一个数据
				
				// 根据字段名获取相应的值
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String sex = rs.getString("sex");
				String address = rs.getString("address");
				String depart = rs.getString("depart");
				String worklen = rs.getString("worklen");
				String wage = rs.getString("wage");
				//输出查到的记录的各个字段的值
				System.out.println(name + " " + age + " " + sex + " " + address
						+ " " + depart + " " + worklen + " " + wage);
			}
			conn.close();	//关闭数据库连接
		} catch (SQLException e) {
			System.out.println("查询数据失败");
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
