package com.saoraozhe.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//操作数据库的工具类，返回一个数据库连接
public class DBUtil {
	
	//该类的不同对象共用一份static成员
	private static final String URL="jdbc:mysql://localhost:3306/test";
	private static final String USER="root";
	private static final String PASSWORD="";	
	private static Connection conn=null;
	
	static {
		try {
			//forName 是 Class类 的静态方法，按类名返回并记录一个Class 的对象
			//这个Class 的对象即Driver.class，或Driver.getClass()
			//Driver.class.newInstance() 相当于 new Driver()
			Class.forName("com.mysql.jdbc.Driver");
			//getConnection 是 DriverManager 类的静态方法，会先Driver.class.newInstance()
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//静态方法，能直接通过类名来调用
	public static Connection getConnection(){
		//单例模式
		return conn;
	}
	
	//以下是使用jdbc的完整步骤
	public static void main(String[] arg) throws Exception{
		
		//1、利用反射机制，加载驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		//2.获得数据库的连接
		Connection connect = DriverManager.getConnection(URL,USER,PASSWORD);
		//3.获得连接的声明
		Statement state = connect.createStatement();
		//3.通过声明的操作数据库，并获取结果
		ResultSet result = state.executeQuery("select name from user");
		
		while(result.next()){
			System.out.println(result.getString("name"));
		}
	}
}
